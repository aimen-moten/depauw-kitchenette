package KitchenSimulation;
import java.util.ArrayList;
import java.util.Random;

public class Kitchen {
    private int kitchenID;
    private String kitchenName;
    private ArrayList<Food> menu;
    private double kitchenRating;
    private int ratings;//tracks number of ratings kitchen has to determine average

    public Kitchen(String kitchenName){
        Random rand=new Random();
        this.kitchenID=rand.nextInt(100000);
        this.kitchenName = kitchenName;
        menu=new ArrayList<Food>();
    }

    int getKitchenID(){
        return kitchenID;
    }

    String getName(){
        return kitchenName;
    }

    double getKitchenRating(){
        return kitchenRating;
    }

    public ArrayList<Food> getMenu(){
        return menu;
    }

    public void addFoodToMenu(Food food){
        menu.add(food);
    }

    void rateKitchen(int rating){
        if(ratings == 0){
            ratings++;
            kitchenRating = rating;
        }
        else{
            double temp = ratings*kitchenRating;
            temp = temp + rating;
            ratings++;
            kitchenRating = temp/ratings;
        }

    }
}
