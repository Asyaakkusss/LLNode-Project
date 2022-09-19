/**A class that extends trader and represents an entity that physically 
  * trades stocks
  * 
  * @author Asya Akkus 
  */
public class MarketMaker extends Trader {
  
  /**a constructor for the MarketMaker class
    * @param makerName, which is the market maker's name
    * @param defaultOrderSize, which is the number of orders placed
    * @param priceOffset, which is the price offset of the shares 
    */
  public MarketMaker(String makerName, int defaultOrderSize, double priceOffset) {
    super(makerName);
    this.defaultOrderSize = defaultOrderSize; 
    this.priceOffset = priceOffset; 
  }
  
  /**a field that stores the value of the default order size
    */
  private int defaultOrderSize = 0; 
  
  /**a field that stores the value of the default order size
    */
  private double priceOffset = 0.0; 
  
  /**a method that gets the integer value representing the default order 
    * size
    * @return defaultOrderSize, which is the number of orders placed
    */
  public int getDefaultOrderSize() {
    return defaultOrderSize; 
  }
  
  /**a method that sets the integer value representing the default order
    * size
    * @param defaultOrderSize, which is the number of orders placed
    */
  public void setDefaultOrderSize(int defaultOrderSize) {
    this.defaultOrderSize = defaultOrderSize; 
  }
  
  /**a method that gets the double value representing the price offset
    * @return priceOffset, or the value of the price offset of the market 
    * maker's stock
    */
  public double getPriceOffset() {
    return priceOffset; 
  }
  
  /**a method that sets the double value representing the price offset
    * @param priceOffset, which lets you set the price offset of the market 
    * maker's stock
    */
  public void setPriceOffset(double priceOffset) {
    this.priceOffset = priceOffset; 
  }
  
  /**a method that returns the string value of the marker maker's name
    * @return String, which gives you the name of the market maker 
    **/
  public String toString() {
    return "The Market Maker is " + getName() + ". "; 
    
  }
  /**a method that ascertains whether or not two instances of market makers are equivalent
    * @param o, which is the instance we are comparing the equality of relative to another instance
    * @return boolean, which is true or false depending on the instances' equality or lack thereof 
    */
  
  public boolean equals(Object o) {
    if (o instanceof MarketMaker){
      MarketMaker m = (MarketMaker)o;
      return this.getName() == m.getName();
    }
    else
      return false;
    
  }
}
