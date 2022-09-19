/** A class that represents the basic properties of a market sell order
  * for a given instance of a specific stock in the market 
  * 
  * @author Asya Akkus 
  * 
  */
public class MarketSellOrder extends SellLimitOrder {
  
   /** a constructor that is used to set up an instance of market sell order
    * @param stockSymbol, which is the symbol used to differentiate varying stocks 
    * @param numberShares, which is indicative of the number of shares sold or bought
    * @param price, which is indicative of the price of the stock at hand 
    * @param trader, which is indicative of the Market Maker that places the buy or sell order
    * @param allOrNone, which is indicative of whether we buy all or none of the shares
    * @param dayOrderStatus, which determines whether or not an order is a day order 
    */
  public MarketSellOrder(char stockSymbol, int numberShares, double price, MarketMaker trader,
                         boolean allOrNone, boolean dayOrderStatus) {
    super(stockSymbol, numberShares, price, trader, allOrNone, dayOrderStatus);
    this.allOrNone = allOrNone; 
    this.dayOrderStatus = dayOrderStatus; 
  }
  
  /** a field that stores the determines whether we sell all or none
    * of the shares in question 
    */
  private boolean allOrNone = false; 
  
  /** a field that determines whether or not an order is a day order  
    */
  private boolean dayOrderStatus = true; 
  
  /** a method that returns a boolean that is true if all shares have to be sold  
    * and false if not all shares have to be sold 
    * @return boolean, which determines the status of the order 
    */
  public boolean isAllOrNone() {
    if (allOrNone == true)
      return false; 
    else 
      return false; 
  }
  
  /** a method that returns a boolean that is true if the order is a day order and 
    * false if it is not a day order 
    * @return boolean, which determines whether it is a day order or not
    */
  public boolean isDayOrder() {
    if (dayOrderStatus == true)
      return true; 
    else 
      return true; 
  }
  
  /** a method that overrides toString in order to communicate the components of an instance
    * of Market Sell Order in a readable format
    * @return String, which includes the name, price, number of shares, and day order/all or none
    * status of a stock
    */
  public String toString() {
    return "The Market Sell Order is for stock " + getStockSymbol() + " , " 
      + getTrader() + "It is priced at " + getPrice() + " for " + getNumberShares() + " shares." +
      " The all or none status is " + isAllOrNone() + " and the day order status is " + isDayOrder(); 
  }
  
  /** a method that overrides the equals method in order to establish whether two Market Sell Orders
    * are the same
    * @return boolean, which is true if the instances are the same and false if the instances are different 
    */
  public boolean equals(Object o) {
    if (o instanceof SellLimitOrder) {
      SellLimitOrder m = (SellLimitOrder)o;
      return (this.getStockSymbol() == m.getStockSymbol() &&
              this.getPrice() == m.getPrice() &&
              this.getNumberShares() == m.getNumberShares() &&
              getTrader().equals(m.getTrader())) &&
        this.isAllOrNone() == m.isAllOrNone() &&
        this.isDayOrder() == m.isDayOrder();
    }
    else
      return false;
  }
}