package KitchenSimulation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Customer {
    private String name;
    private int id;
    private int totalQuantity;
    private double totalPrice;
    private String customerAddress;
    private ArrayList<Food> cart;

    public Customer(String name,String customerAddress){
        Random rand=new Random();
        this.name=name;
        this.customerAddress=customerAddress;
        this.id=rand.nextInt(100000);
        this.totalQuantity=0;
        this.totalPrice=0;
        cart=new ArrayList<Food>();
    }

   public void addToCart(Food food){
        System.out.println("adding.....");
        this.cart.add(food);
        this.totalQuantity++;
        this.totalPrice = totalPrice + food.getPrice();
    }

  
    public void removeFromCart(String food){
        food = food.toLowerCase();
        System.out.println(cart.size());
        for(int i = 0; i < cart.size(); i++){
          if(food.equals(cart.get(i).getFoodName().toLowerCase())){
            this.totalQuantity--;
            this.totalPrice = this.totalPrice-cart.get(i).getPrice();
            cart.remove(i);
            System.out.println("Successfully Removed from the cart!");
            break;
          }
        }

    }

    String getName(){
        return this.name;
    }

    int getCustomerId(){
        return this.id;
    }


   public int getTotalQuantity(){
        return this.totalQuantity;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    public void checkOut(){
        this.printReceipt();
        System.out.println("Your food will be delivered in approximately 15 minutes");
        System.out.println("*************** Thank you ***************");
    }

    public void watchCart(){

        System.out.println(cart.size());
    }


    public void printReceipt(){
        int length=cart.size();
        for(int i=0;i<length;i++){
            System.out.println("Food: "+cart.get(i).getFoodName()+"--------"+"$"+cart.get(i).getPrice());
        }
        System.out.println("-------------------------------");
        System.out.println("TotalPrice"+"-----------$"+this.totalPrice);
    }
}
