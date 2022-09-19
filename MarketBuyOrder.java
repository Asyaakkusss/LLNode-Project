/** A class that represents the basic properties of a market buy order
  * for a given instance of a specific stock in the market 
  * 
  * @author Asya Akkus 
  * 
  */
public class MarketBuyOrder extends BuyLimitOrder {
  
  /** a constructor that is used to set up an instance of order
    * @param stockSymbol, which is the symbol used to differentiate varying stocks 
    * @param numberShares, which is indicative of the number of shares sold or bought
    * @param price, which is indicative of the price of the stock at hand 
    * @param trader, which is indicative of the trader that places the buy or sell order
    * @param allOrNone, which determines whether the order is an all or none order
    * @param dayOrderStatus, which determines whether the order is a day order 
    */
  public MarketBuyOrder(char stockSymbol, int numberShares, double price, 
                        MarketMaker trader, boolean allOrNone, boolean dayOrderStatus) {
    super(stockSymbol, numberShares, price, 
          trader, allOrNone, dayOrderStatus);
    this.allOrNone = allOrNone; 
    this.dayOrderStatus = dayOrderStatus; 
  }
  
  /**a field that stores whether the order is an all or none order 
    */
  private boolean allOrNone = false; 
  
  /**a field that stores whether the order is a day order status
    */
  private boolean dayOrderStatus = true; 
  
  /** a method that establishes that a market buy order is never an all or none order
    * @return boolean, which tells the user whether or not the stock is an all 
    * or none order
    */
  public boolean isAllOrNone() {
    if (allOrNone == true)
      return false; 
    else 
      return false; 
  }
  
  /** a method that establishes that a market buy order is always a day order 
    * @return boolean, which tells the user whether or not the stock is a day order
    */
  public boolean isDayOrder() {
    if (dayOrderStatus == true)
      return true; 
    else 
      return true; 
  }
  
  /** a method that overrides toString in order to communicate the components of an instance
    * of Market Buy Order in a readable format
    * @return String, which includes the name, price, number of shares, and day order/all or none
    * status of a stock
    */
  public String toString() {
    return "The Market Buy Order is for stock " + getStockSymbol() + " , " 
      + getTrader() + "It is priced at " + getPrice() + " for " + getNumberShares() + " shares." +
      " The all or none status is " + isAllOrNone() + " and the day order status is " + isDayOrder(); 
  }
  
  /** a method that overrides the equals method in order to establish whether two Market Buy Orders
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