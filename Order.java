/** A class that represents the basic properties of every kind
  * of buy and sell order for a given instance of a specific stock 
  * in the market 
  * 
  * @author Asya Akkus 
  * 
  */
public class Order {
  
  /** a constructor that is used to set up an instance of order
    * @param stockSymbol, which is the symbol used to differentiate varying stocks 
    * @param numberShares, which is indicative of the number of shares sold or bought
    * @param price, which is indicative of the price of the stock at hand 
    * @param trader, which is indicative of the trader that places the buy or sell order
    */
  public Order(char stockSymbol, int numberShares, double price, Trader trader) {
    this.trader = trader; 
    this.stockSymbol = stockSymbol; 
    this.numberShares = numberShares; 
    this.price = price; 
  }
  
  /** a field that stores the stock's alphabetical symbol 
    */
  private char stockSymbol = ' '; 
  
  /** a field that stores the value of the number of shares 
    */
  private int numberShares = 0; 
  
  /** a field that stores the value of the stock's price
    */
  private double price = 0.0; 
  
  /** a field that stores the value of the trader who makes 
    * the order
    */
  private Trader trader; 
  
  /** a method that returns the characters of the stock's alphabetical symbol
    * @return stockSymbol, which tells the user the stock's symbol
    */
  public char getStockSymbol() {
    return stockSymbol;
  }
  
  /** a method that returns the number of shares
    * @return numberShares, which is the number of shares of stock requested
    */
  public int getNumberShares() {
    return numberShares;
  }
  
  /** a method that sets the number of shares
    * @param numberShares, which is the number of shares we want 
    */
  public void setNumberShares(int numberShares) {
    this.numberShares = numberShares; 
  }
  
  /** a method that returns the price of the stock 
    * @return price, which is the price of each share we ordered
    */
  public double getPrice() {
    return price; 
  }
  
  /** a method that returns the information on the trader placing the order 
    * @return trader, which is the trader who places the order 
    */
  public Trader getTrader() {
    return trader; 
  }
  
  /** a method that returns the string value of the marker maker's name
    * @return String, which is information on the order in readable terms 
    */
  public String toString() {
    return "The Order is for stock " + getStockSymbol() + " , " 
      + getTrader() + "It is priced at " + getPrice() + " for " + getNumberShares() + " shares."; 
  }
  
  /** a method that returns the string value of the marker maker's name
    * @param o, which is the instance we are comparing the equality of relative to another instance
    * @return boolean, which is true or false depending on the instances' equality or lack thereof
    */
  public boolean equals(Object o) { 
    if (o instanceof Order) {
      Order m = (Order)o;
      return (this.getStockSymbol() == m.getStockSymbol() &&
              this.getPrice() == m.getPrice() &&
              this.getNumberShares() == m.getNumberShares() &&
              getTrader().equals(m.getTrader()));
    }
    else
      return false;
  }
}