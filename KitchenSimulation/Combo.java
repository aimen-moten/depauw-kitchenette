package KitchenSimulation;

public class Combo extends Food{
  private Food item1;
  private Food item2;
  private Food item3;
  private String name;
  
  public Combo(Food item1, Food item2, Food item3, String name ) {
    super((item1.getPrice() + item2.getPrice() + item3.getPrice()), name);
    this.item1 = item1;
    this.item2 = item2;
    this.item3 = item3;
  }

  
  public String toString(){
    return "Food{" +
                "foodID=" + this.getFoodID() +
                ", price=" + this.getPrice() + ", foodName=" + this.getFoodName() + " (" + this.item1.getFoodName() + ", " + this.item2.getFoodName() + ", " + this.item3.getFoodName() + ")}";
  }
}