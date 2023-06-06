
import KitchenSimulation.Customer;
import KitchenSimulation.Food;
import KitchenSimulation.Kitchen;
import KitchenSimulation.Combo;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the DePauw Kitchenette!");
        System.out.println("Enter your Full Name and address");
        System.out.print("Customer Name: ");
        String customerName=scanner.nextLine();
        System.out.print("Customer Address: ");
        String customerAddress=scanner.next();
        Customer customer=new Customer(customerName,customerAddress);
        System.out.println("Successfully registered the customer!");

         Kitchen McDonalds = new Kitchen("McDonalds");
         Kitchen TacoBell = new Kitchen("TacoBell");
         Kitchen Dominos = new Kitchen("Dominos");

         //Creating Food List
         Food hamburger = new Food(1.99, "Hamburger");
         Food frenchFries = new Food(2.49, "FrenchFries");
         Food fountainDrink = new Food(1.19, "FountainDrink");
         Food dessert = new Food(2.99, "Dessert");
         Food cheeseburger = new Food(2.19, "Cheeseburger");
         Food chickenSandwich = new Food(3.99, "ChickenSandwich");
         Food taco = new Food(1.99, "Taco");
         Food tortillaChips = new Food(1.09, "Tortilla Chips");
         Food burrito = new Food(2.59, "Burrito");
         Food quesadilla = new Food(3.99, "Quesadilla");
         Food pizza = new Food(8.99, "Pizza");
         Food breadsticks = new Food(3.99, "Breadsticks");
         Food salad = new Food(5.99, "Salad");
         Combo hamburgerCombo = new Combo(cheeseburger, fountainDrink, frenchFries, "HamburgerCombo");



         McDonalds.addFoodToMenu(hamburger);
         McDonalds.addFoodToMenu(frenchFries);
         McDonalds.addFoodToMenu(fountainDrink);
         McDonalds.addFoodToMenu(dessert);
         McDonalds.addFoodToMenu(cheeseburger);
         McDonalds.addFoodToMenu(chickenSandwich);
         McDonalds.addFoodToMenu(hamburgerCombo);

         TacoBell.addFoodToMenu(fountainDrink);
         TacoBell.addFoodToMenu(taco);
         TacoBell.addFoodToMenu(tortillaChips);
         TacoBell.addFoodToMenu(burrito);
         TacoBell.addFoodToMenu(quesadilla);
         TacoBell.addFoodToMenu(dessert);

         Dominos.addFoodToMenu(fountainDrink);
         Dominos.addFoodToMenu(pizza);
         Dominos.addFoodToMenu(breadsticks);
         Dominos.addFoodToMenu(salad);
         Dominos.addFoodToMenu(dessert);

        String kitchenName;
        Kitchen currentKitchen = null;
        System.out.println("McDonalds"+"-------"+"Taco Bell"+"-------"+"Dominos");
        while(true){
            System.out.print("Please select one of the kitchen from the  given list:");
            kitchenName=scanner.next();
            kitchenName=kitchenName.toLowerCase();
            System.out.println(kitchenName);
            if(kitchenName.equals("mcdonalds")){
                    currentKitchen=McDonalds;
                    System.out.println(hamburgerCombo.toString());
                    break;
            } else if (kitchenName.equals("tacobell")) {
                        currentKitchen=TacoBell;
                        break;
            }else if(kitchenName.equals("dominos")){
                currentKitchen=Dominos;
                break;
            }else{
                System.out.print("Do you want to exit the terminal ?(Y|N):");
                String keyWord=scanner.next();
                if(keyWord.toLowerCase()=="n"){
                    kitchenName=null;
                    break;

                }
            }
        }

        if(kitchenName!=null){
           outerloop: while(true){
                System.out.println("*--------------------Menus--------------------*");
                for(int i=0;i<currentKitchen.getMenu().size();i++){
                    System.out.println(currentKitchen.getMenu().get(i).getFoodName()+" ------ $"+currentKitchen.getMenu().get(i).getPrice());
                }
                System.out.print("Select the food from the given menu:");
                String foodName=scanner.next();
                System.out.println();
                foodName=foodName.toLowerCase();
                for(int i=0;i<currentKitchen.getMenu().size();i++){
                    if(foodName.equals(currentKitchen.getMenu().get(i).getFoodName().toLowerCase())){
                        customer.addToCart(currentKitchen.getMenu().get(i));
                        break;
                    }
                }

              while(true){

                System.out.print("Press 1 for add, 2 for remove, and 3 for checkout");
                String response=scanner.next();
                response = response.toLowerCase();
                if(response.equals("1")){
                    continue outerloop;
                }
                else if(response.equals("2")){
                  System.out.println("What item would you like to remove from your cart?");
                  String toRemove = scanner.next();
                  customer.removeFromCart(toRemove);
                  }
                else{
                    break outerloop;
                }
            }
        }
        }else{
            System.out.println("Thank you checking out cloud kitchen");
        }
        System.out.print("Do you want to Checkout?(Y|N):");
        String response1=scanner.next();
        if(response1.equals("Y")){
            customer.checkOut();
        }else{
            System.out.println("----------------Thank you!-------------");
        }

        }






}