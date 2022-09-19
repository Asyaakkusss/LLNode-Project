/** A class that represents an entity that trades the stocks
  * 
  * @author Asya Akkus 
  */
public class Trader {
  
  /** a constructor that is used to set up an instance of trader
    * @param traderName, the value of the trader's name 
    */
  public Trader (String traderName) {
    this.traderName = traderName; 
  }
  
  /** a field that stores the value of the trader's name 
    */
  private String traderName = " "; 
  
  /** a method that gets the string representing the trader's name 
    * @return traderName, which is the name of the trader 
    */
  public String getName() {
    return traderName;  
  }
  
  /** a method that sets the string representing the trader's name 
    * @param traderName, which is the name of the trader
    */
  public void setName(String traderName) {
    this.traderName = traderName; 
  }
  
  /** a method that returns the string value of the trader's name
    * @return String, which tells the user the name of the trader
    */
  public String toString() {
    return "The Trader is " + getName() + ". "; 
    
  }
  
  /** a method that ascertains whether or not two instances of trader are equivalent 
    * @param o, which is the instance we are comparing the equality of relative to another instance
    * @return boolean, which is true or false depending on the instances' equality or lack thereof
    */
  public boolean equals(Object o) {
    if (o instanceof Trader){
      Trader m = (Trader)o;
      return this.getName() == m.getName();
    }
    else
      return false;
  }
}
