import java.lang.IllegalArgumentException;

/** A class represents a market for a stock and maintains all the buy and sell
  * orders for the stock.
  * 
  * @author Asya Akkus 
  * 
  */
public class Market {
  
  /** a field that stores the LLNodes for sell orders  
    */
  private LLNode <SellLimitOrder> sellOrders;
  
  /** a field that stores the LLNodes for buy orders
    */ 
  private LLNode <BuyLimitOrder> buyOrders; 
  
  /** a field that stores all the open orders associated 
    * with a specific trader 
    */
  private LLNode <Order> openOrders;
  
  /** a field that stores the stock's alphabetical symbol 
    */
  private char stockSymbol = ' '; 
  
  /** a field that stores the stock's market maker instance
    */
  public static MarketMaker marketMaker = new MarketMaker(" ", 0, 0.0); 
  
  /** Creating an instance for the buy limit order
    */
  public static BuyLimitOrder buyLimitOrder = new BuyLimitOrder(' ', 0, 0.0, marketMaker, true, true);
  
  /** Creating an instance for the buy limit order
    */
  public static SellLimitOrder sellLimitOrder = new SellLimitOrder(' ', 0, 0.0, marketMaker, true, true);
  
  
  /** a constructor that is used to set up an instance of Market
    * @param stockSymbol, which is the symbol used to differentiate varying stocks 
    * @param buyOrders, which is the series of LLNodes representing buy orders
    * @param openOrders, which is the series of LLNodes representing orders active in 
    * the market 
    * @param sellOrders, which is the series of LLNodes representing sell orders
    * @param marketMaker, which is the instance of market maker that places this order
    * @param buyLimitOrder, which is a single instance of a buy limit order
    * @param sellLimitOrder, which is a single instance of a sell limit order 
    */
  public Market (char stockSymbol, LLNode <BuyLimitOrder> buyOrders, LLNode <Order> openOrders, 
                 LLNode <SellLimitOrder> sellOrders, MarketMaker marketMaker, BuyLimitOrder buyLimitOrder, 
                 SellLimitOrder sellLimitOrder ) {
    this.stockSymbol = stockSymbol; 
    this.buyOrders = buyOrders; 
    this.openOrders = openOrders; 
    this.sellOrders = sellOrders; 
    this.marketMaker = marketMaker;
    this.buyLimitOrder = buyLimitOrder; 
    this.sellLimitOrder = sellLimitOrder; 
  }
  
  /** a method that returns the characters of the stock's alphabetical symbol
    * @return stockSymbol, which tells the user the stock's symbol
    */
  public char getStockSymbol() {
    return stockSymbol; 
  }
  
  /** a method that returns the sell orders of the stock's market
    * @return sellOrders, which are the LLNodes of sell orders
    */
  public LLNode <SellLimitOrder> getSellOrders(){
    return sellOrders; 
  }
  
  /** a method that returns the buy orders of the stock's market
    * @return buyOrders, which are the LLNodes of buy orders
    */
  public LLNode <BuyLimitOrder> getBuyOrders() {
    return buyOrders; 
  }
  
  /** a method that returns all of a specific trader's or market
    * maker's orders in the stock's market
    * @return openOrders, which are the LLNodes of all types of orders
    * @param t, which is the instance of trader that placed this order 
    * COME BACK TO THIS
    */
  public LLNode<Order> getOpenOrders(Trader t) {
    return openOrders; 
  }
  
  /** a method that returns the highest price of a buy order in the market
    * that is not an all or nothing order
    * @return double, which is the value of the highest-priced LLNode representing
    * a buy order
    */
  public double getCurrentBuyPrice() {
    LLNode <BuyLimitOrder> nodeptr = buyOrders.getNext();
    if (nodeptr == null) 
      return 0.0; 
    if (buyOrders.getElement().isAllOrNone() == false)
      return buyOrders.getElement().getPrice(); 
    else {
      while ((nodeptr != null) && (nodeptr.getElement().isAllOrNone() == true)){
        nodeptr = nodeptr.getNext();
      }
      return nodeptr.getElement().getPrice(); 
    }
  }
  
  /** a method that returns the lowest price of a sell order in the market
    * that is not an all or nothing order
    * @return double, which is the value of the lowest-priced LLNode representing
    * a sell order
    */
  public double getCurrentSellPrice() {
    LLNode <SellLimitOrder> nodeptr = sellOrders.getNext();
    if (sellOrders.getElement().isAllOrNone() == false)
      return sellOrders.getElement().getPrice(); 
    else {
      while ((nodeptr != null) && (nodeptr.getElement().isAllOrNone() == true)){
        nodeptr = nodeptr.getNext();
      }
      return nodeptr.getElement().getPrice(); 
    }
  }
  
  /** a method that returns true if there are sell and buy orders in the market
    * and returns false if there are no sell or buy orders in the market 
    * @return boolean, which is only true if the order elements are not null 
    */
  public boolean isOpen() {
    if ((sellOrders != null) && (buyOrders != null))
      return true;
    else 
      return false; 
  }
  
  /** a method that determines whether an order is valid through comparing buy and sell
    * order prices and stock symbols
    * @return boolean, which is true if the conditions for an order's validity are met 
    * @param order, which is any type of order whose validity is to be determined 
    */
  public boolean isValidOrder(Order order) {
    LLNode<BuyLimitOrder> nodeptr = buyOrders.getNext();
    if ((nodeptr != null) && (order.getStockSymbol() == this.stockSymbol)&& (order instanceof BuyLimitOrder) && !(order instanceof MarketBuyOrder)){
      while (nodeptr.getElement().getPrice() < sellOrders.getElement().getPrice()){ 
        if (order.getPrice() >= nodeptr.getElement().getPrice())
          return false;  
        else 
          nodeptr = nodeptr.getNext();   
      }
      return true; 
    }
    LLNode<SellLimitOrder> nodeptr1 = sellOrders.getNext();
    if ((nodeptr != null) && (order.getStockSymbol() == this.stockSymbol) && (order instanceof SellLimitOrder) && !(order instanceof MarketBuyOrder)){
      while (sellOrders.getElement().getPrice() > buyOrders.getElement().getPrice()) {
        if (order.getPrice() <= buyLimitOrder.getPrice())
          return false; 
        else 
          nodeptr1 = nodeptr1.getNext(); 
      }
      return true; 
    }
    return true; 
  }
  
  /** a method that adds an order to the market 
    * @param order, which is the order that is to be added to the list 
    */
  public void addOrder(Order order) { 
    
    if (order.getStockSymbol() != this.stockSymbol) 
      throw new IllegalArgumentException(); 
    LLNode<SellLimitOrder> nodeptr = sellOrders.getNext();
    if (order instanceof SellLimitOrder){
      while (nodeptr.getNext() != null && order.getPrice() <= nodeptr.getElement().getPrice()){
        nodeptr=nodeptr.getNext();}
      LLNode <SellLimitOrder> tempPointer = nodeptr.getNext();
      LLNode <SellLimitOrder> s = new LLNode<SellLimitOrder>((SellLimitOrder) order, tempPointer);
      nodeptr.setNext(s);
    }
    LLNode<BuyLimitOrder> nodeptr1 = buyOrders.getNext();
    if (order instanceof BuyLimitOrder){
      while (nodeptr1.getNext() != null && order.getPrice() >= nodeptr1.getElement().getPrice()){
        nodeptr1=nodeptr1.getNext();}
      LLNode <BuyLimitOrder> tempPointer = nodeptr1.getNext();
      LLNode <BuyLimitOrder> b = new LLNode<BuyLimitOrder>((BuyLimitOrder) order, tempPointer);
      nodeptr1.setNext(b);
    }
  }
  
  
  /** a method that removes an order from the market 
    * @param order, which is the order that needs to be removed from the list 
    */
  public void removeOrder(Order order) {
    LLNode<SellLimitOrder> nodeptr = sellOrders.getNext();
    LLNode<SellLimitOrder> nextptr = nodeptr.getNext(); 
    while (nodeptr.getNext() != null) {
      if (order instanceof SellLimitOrder &&
          order.getStockSymbol() == this.getStockSymbol() &&
          order.getPrice() == nodeptr.getElement().getPrice() &&
          order.getNumberShares() == nodeptr.getElement().getNumberShares() &&
          order.getTrader() == nodeptr.getElement().getTrader()) {
        LLNode <SellLimitOrder> tempPointer = nextptr.getNext();
        nodeptr.setNext(tempPointer); 
      }
      else {
        nodeptr = nodeptr.getNext(); 
      }
    }
    LLNode<BuyLimitOrder> nodeptr1 = buyOrders.getNext();
    LLNode<BuyLimitOrder> nextptr1 = nodeptr1.getNext(); 
    while (nodeptr1.getNext() != null) {
      if (order instanceof BuyLimitOrder &&
          order.getStockSymbol() == this.getStockSymbol() &&
          order.getPrice() == nodeptr1.getElement().getPrice() &&
          order.getNumberShares() == nodeptr1.getElement().getNumberShares() &&
          order.getTrader() == nodeptr1.getElement().getTrader()) {
        LLNode <BuyLimitOrder> tempPointer1 = nextptr1.getNext();
        nodeptr1.setNext(tempPointer1); 
      }
      else {
        nodeptr1 = nodeptr1.getNext(); 
      }
    }
  }
  
  /** a method that determines whether two orders match based on their price and number
    * of shares
    * @return boolean, which is true if orders match 
    * @param buyLimitOrder, which is the buy limit order to be matched to a sell limit order
    * @param sellLimitOrder, which is the sell limit order to be matched to a buy limit order 
    */
  public boolean matchingOrders(BuyLimitOrder buyLimitOrder, SellLimitOrder sellLimitOrder) {
    if ((buyLimitOrder.getPrice() >= sellLimitOrder.getPrice()) 
          && ((buyLimitOrder.isAllOrNone() == true) 
                &&(sellLimitOrder.getNumberShares() >= buyLimitOrder.getNumberShares())))
      return true; 
    if ((buyLimitOrder.getPrice() >= sellLimitOrder.getPrice()) 
          && ((sellLimitOrder.isAllOrNone() == true) 
                && (buyLimitOrder.getNumberShares() >= sellLimitOrder.getNumberShares())))
      return true; 
    if ((buyLimitOrder.getPrice() >= sellLimitOrder.getPrice()) 
          && ((buyLimitOrder.isAllOrNone() == true) 
                && sellLimitOrder.isAllOrNone()))
      return true; 
    else 
      return false; 
  }
  
  /** a method that removes market maker orders and day orders from the market 
    */
  public void closeMarket() {
    LLNode <SellLimitOrder> nodeptr = sellOrders.getNext();
    LLNode <SellLimitOrder> nextptr = nodeptr.getNext(); 
    while (nodeptr != null) {
      if (sellOrders.getElement().isDayOrder() == true) {
        LLNode <SellLimitOrder> newDirection = nextptr.getNext(); 
        nodeptr.setNext(newDirection); 
        nodeptr = nodeptr.getNext(); 
      }
      else 
        nodeptr = nodeptr.getNext(); 
    }
    LLNode <BuyLimitOrder> nodeptr1 = buyOrders.getNext();
    LLNode <BuyLimitOrder> nextptr1 = nodeptr1.getNext();
    while (nodeptr != null) {
      if (buyOrders.getElement().isDayOrder() == true) {
        LLNode <BuyLimitOrder> newDirection1 = nextptr1.getNext(); 
        nodeptr1.setNext(newDirection1); 
        nodeptr = nodeptr.getNext(); 
      }
      else 
        nodeptr1 = nodeptr1.getNext(); 
    }
  }
  
  /** a method that overrides the equals method for the Market class
    * @param o, which is the object to which another market instance will be compared to 
    * @return boolean, which will return true only when the value is equal 
    */
  public boolean equals(Object o) {
    if (o instanceof Market) {
      Market m = (Market) o; 
      return this.getStockSymbol() == m.getStockSymbol();
    }
    else 
      return false;
  }
  
  /** a method that overrides the toString method for the Market class
    * @return String, which tells the user what stock is being manipulated for this instance of Market  
    */
  public String toString(){
    return "The Market is for stock " + getStockSymbol() + ". "; 
  }
}



