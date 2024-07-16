package package1;

import java.io.*;
import  java.util.*;

public class Customer1 implements Serializable {
   /* private List<Store>followedStores;
    private List<Product> shopBox;
    private List<Product> purchaseProducts;

    public Customer1() {
        followedStores = new ArrayList<>();
        shopBox = new ArrayList<>();
        purchaseProducts = new ArrayList<>();
    }

    public void followStore(Store store){
        followedStores.add(store);
    }

    public void unfollowStore(Store store){
        followedStores.remove(store);
    }

    public void registerIdea(Store idea , Store store){
        store.addIdea(idea);
    }

    public void voteIdea(String idea , Store store){
        store.voteIdea(idea);
    }

    public void addToShopBox(Product product){
        shopBox.add(product);
    }

    public void removeFromShopBox(Product product){
        shopBox.remove(product);
    }

    public void buyFromShopBOx(Store store){
        double totalPrice = 0;
        for (Product product: shopBox) {
            if (store.hasProduct(product)){
                totalPrice += store.getProductPrice();
                purchaseProducts.add(product);
            }
        }
        store.updateIncome(totalPrice);
    }

    public  List<Store> getFollowedStores(){
        return followedStores;
    }

    public List<Product> getShopBox() {
        return shopBox;
    }

    public List<Product> getPurchaseProducts() {
        return purchaseProducts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();

        System.out.println("Enter store name : ");
        String storeName = scanner.nextLine();

        System.out.println("Enter store location  :");
        String storeLocation = scanner.nextLine();

        Store store = new Store(storeName , storeLocation);
        System.out.println("Store created successfully.");

        System.out.println("Would you like to follow the store ? (y/n) ");
        String followResponse = scanner.nextLine().toLowerCase();

        if(followResponse.equals("y")){
            customer.followStores(store);
            System.out.println("Store followed successfully!");
        }
        System.out.println("Enter product name to add to Shopping cart : ");
        String productToAdd = scanner.nextLine();

        Product product = new Product(productToAdd);
        customer.addToShopBox(product);
        System.out.println("Product added to shopping cart successfully.");

        System.out.println("Would you like to buy products from shopping card ? (y/n)");
        String buyResponse = scanner.nextLine().toLowerCase();

        if (buyResponse.equals("y")){
            customer.buyFromShopBOx(store);
            System.out.println("Products bought successfully");
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("customer.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(customer);
            out.close();
            fileOut.close();
            System.out.println("Data saved to customer.ser");
        }
        catch (IOException i){
            i.printStackTrace();
        }
        }*/
    }
