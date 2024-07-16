package package1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Scanner;

public class Custom {
    /*private String name;
    private ArrayList<String> subscribedStores;
    private ArrayList<String> shoppBox;
    private ArrayList<String> stores;
    private HashMap <String , String> prices;

    public Customer(String name) {
        this.name = name;
        this.subscribedStores = new ArrayList<>();
        this.shoppBox = new ArrayList<>();
        this.stores = new ArrayList<>();
    }

    public void subscribeStores(String storeName){
        subscribedStores.add(storeName);
    }

    public void viewStores(Store store){
        System.out.println("List of available stores :");
        // code to display all available stores
        for (Store store: stores) {
            System.out.println(store);
        }
    }

    public void searchProduct(String productName){
        System.out.println("Searching for product : "+ productName);
        //code to search for product in subscribed store
        for (String store : subscribedStores) {
            ArrayList<String> products = store.searchProduct(productName);
            //display the search result
            if(!products.isEmpty()){
                System.out.println("Results found in store: " + store);
                for (String product: products) {
                    System.out.println(product);
                }
            }
        }
    }

    public void addToShoppBox(String itemName){
        shoppBox.add(itemName);
        System.out.println(itemName + "added to your shop box");
    }

    public void viewShopBox(){
        System.out.println(name + "'s shop box");
        for(String item : shoppBox) {
            System.out.println(item);
        }
    }

    public void registerShopBox(){
        try {
            File shopBoxFile = new File(name + "_shop_box.txt");
            FileWriter writer = new FileWriter(shopBoxFile);

            for (String item : shoppBox) {
                writer.write(item + "\n");
            }
            writer.close();
            System.out.println("Shop box registered successfully");
        }catch (IOException e){
            System.out.println("Error registering shop box :" + e.getMessage());
        }
    }

    public void buyFromShopBox(){
        //code to process shopping box
        double totalPrice = 0.0;
        for (String item: shoppBox) {
            double itemPrice= getItemPrice(item);
            totalPrice += itemPrice;
        }

        System.out.println("Receipt:");
        System.out.println("-------------");
        for (String item : shoppBox) {
            System.out.println(item + "$" + getItemPrice(item));
        }
        System.out.println("----------------");
        System.out.println("Total : $" + totalPrice);

        System.out.println("Thanks for Shopping with us");
    }

    public void voteProduct(String productName , String feedback){
        try {
            File voteFile= new File(name + "_votes.txt");
            FileWriter writer = new FileWriter(voteFile , true);
            writer.write(productName +"-" + feedback + "\n");

            writer.close();
            System.out.println("Thank you for your feedback");

        }catch (IOException e){
            System.out.println("Error registering vote " + e.getMessage());
        }
    }

    public void registerIdea(String idea){
        try {
            File ideasFile = new File(name + "_ideas.txt");
            FileWriter writer = new FileWriter(ideasFile , true);
            writer.write(idea + "\n");
            writer.close();
            System.out.println("Thanks for your suggestion");
        }catch (IOException e){
            System.out.println("Error registering idea :" + e.getMessage());

        }
    }

    private double getItemPrice(String itemName) {
        return prices.get(itemName);
    }

    public void runCustomerMenu(){
        Scanner inputScanner = new Scanner(System.in);

        while (true){
            System.out.println("\n welcome ," +  name);
            System.out.println("Please choose one of following options:");
            System.out.println("1. view available stores");
            System.out.println("2. subscribe to a store");
            System.out.println("3. Search for a product");
            System.out.println("4. Add ab item to your shop box");
            System.out.println("6. register your shop box");
            System.out.println("7. Buy");
            System.out.println("8. Vote for a product");
            System.out.println("9. register an idea");
            System.out.println("0. Exit the menu");

            int choice = inputScanner.nextInt();

            switch (choice){
                case 1 :
                    viewStores();
                    break;
                case 2:
                    System.out.println("Enter the name of store you want to subscribe");
                    String storeName = inputScanner.nextLine();
                    subscribeStores(storeName);
                    break;
                case 3:
                    System.out.println("Enter the name of product to search for :");
                    String productName = inputScanner.nextLine();
                    searchProduct(productName);
                    break;
                case 4:
                    System.out.println("Enter the name of the item to add to shop box");
                    String itemName = inputScanner.nextLine();
                    addToShoppBox(itemName);
                    break;
                case 5:
                    viewShopBox();
                    break;
                case 6:
                    registerShopBox();
                    break;
                case 7:
                    buyFromShopBox();
                    break;
                case 8:
                    System.out.println("Enter name of product you want to vote for :");
                    String voteProductName = inputScanner.nextLine();
                    System.out.println("Enter your feedback");
                    String voteFeedback = inputScanner.nextLine();
                    voteProduct(voteProductName , voteFeedback);
                    break;
                case 9 :
                    System.out.println("Enter your idea :");
                    String idea = inputScanner.next();
                    registerIdea(idea);
                    break;
                case 0 :
                    inputScanner.close();
                    return;
                default:
                    System.out.println("Invalid option selected");
                    break;
            }
        }
    }*/
}
