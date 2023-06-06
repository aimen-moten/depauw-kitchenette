package KitchenSimulation;
import java.util.Random;

public class Food {
    private int foodID;

    @Override
    public String toString() {
        return "Food{" +
                "foodID=" + foodID +
                ", price=" + price +
                ", foodName='" + foodName + '\'' +
                '}';
    }

    private double price;
    private String foodName;

    public Food(double price, String foodName){
        Random rand = new Random();
        this.price = price;
        this.foodID = rand.nextInt(100000);
        this.foodName = foodName;
    }

    public int getFoodID(){
        return foodID;
    }

    public double getPrice(){
        return price;
    }

    public String getFoodName(){
        return foodName;
    }


    public void setPrice(double price){
        this.price = price;
    }
}
