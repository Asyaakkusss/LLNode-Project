/** A class that represents a transaction of buyers and sellers 
  * trading a certain stock 
  * 
  * @author Asya Akkus 
  */
public class Transaction {
  
  /** a constructor that is used to set up an instance of trader
    * @param stockSymbol, which is the character symbol of the stock 
    * being traded
    * @param numberShares, which is the number of shares of the stock
    * being traded
    * @param price, which is the price of the stock being traded
    * @param buyer, which is the trader who is buying the stock
    * @param seller, which is the trader selling the stock 
    */
  public Transaction (char stockSymbol, int numberShares, double price, 
                      Trader buyer, Trader seller) {
    this.stockSymbol = stockSymbol; 
    this.numberShares = numberShares; 
    this.price = price; 
    this.buyer = buyer; 
    this.seller = seller; 
    transactionNumber = lastTransactionNumber++;
  }
  
  /** a field that stores the value of the stock's symbol
    */
  private char stockSymbol = ' '; 
  
  /** a field that stores the value of the number of shares
    * of stock 
    */
  private int numberShares = 0; 
  
  /** a field that stores the value of the price of the stock 
    */
  private double price = 0; 
  
  /** a field that stores the value of the trader buying the stock 
    */
  private Trader buyer; 
  
  /** a field that stores the value of the trader selling the stock 
    */
  private Trader seller; 
  
  /** a field that stores the transaction number
    */
  private final int transactionNumber; 
  
  /** a static field that acts as a counter to increment the transaction
    * number 
    */
  private static int lastTransactionNumber = -1;
  
  /** a method that gets the character representing the stock symbol
    * @return stockSymbol, which is the character symbol for the stock  
    */
  public char getStockSymbol() {
    return stockSymbol; 
  }
  
  /** a method that gets the integer representing the number of shares 
    * @return numberShares, which is the number of shares being traded 
    */
  public int getNumberShares() {
    return numberShares; 
  }
  
  /** a method that gets the double representing the price of the stock 
    * @return price, which is the price of the stock 
    */
  public double getPrice() {
    return price; 
  }
  
  /** a method that gets the trader who is buying the stock 
    * @return buyer, which is the trader buying the stock 
    */
  public Trader getBuyer() {
    return buyer; 
  }
  
  /** a method that gets the trader who is selling the stock 
    * @return seller, which is the trader selling the stock 
    */
  public Trader getSeller() {
    return seller; 
  }
  
  /** a method that gets the transaction number
    * @return transactionNumber, which is the number of transactions
    * that have taken place. It is incremented sequentially 
    */
  public int getTransactionNumber() {
    return transactionNumber; 
  }
  
  /** a method that returns the string value of the marker maker's name
    * @return String, which tells the user the name of the trader
    */
  public String toString() {
    return "The Transaction has been created. "; 
    
  }
  
  /** a method that ascertains whether or not two instances of market makers are equivalent 
    * @param o, which is the instance we are comparing the equality of relative to another instance
    * @return boolean, which is true or false depending on the instances' equality or lack thereof
    */
  public boolean equals(Object o) {
    if (o instanceof Transaction){
      Transaction m = (Transaction)o;
      return this.getTransactionNumber() == m.getTransactionNumber();
    }
    else
      return false;
  }
}

