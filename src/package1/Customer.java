package package1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer implements java.io.Serializable {
    private List<Store> followedStores;
    private List<Product> shopBox;
    private List<Product> purchaseProducts;

    public Customer() {
        followedStores = new ArrayList<>();
        shopBox = new ArrayList<>();
        purchaseProducts = new ArrayList<>();
    }

    public void followStore(Store store) {
        followedStores.add(store);
    }

    public void unfollowStore(Store store) {
        followedStores.remove(store);
    }

    public void registerIdea(Store idea, Store store) {
        store.addIdea(idea);
    }

    public void voteIdea(String idea, Store store) {
        store.voteIdea(idea);
    }

    public void addToShopBox(Product product) {
        shopBox.add(product);
    }

    public void removeFromShopBox(Product product) {
        shopBox.remove(product);
    }

    public void buyFromShopBox(Store store) {
        double totalPrice = 0;
        for (Product product : shopBox) {
            if (store.hasProduct(product)) {
                totalPrice += store.getProductPrice();
                purchaseProducts.add(product);
            }
        }
        store.updateIncome(totalPrice);
    }

    public List<Store> getFollowedStores() {
        return followedStores;
    }

    public List<Product> getShopBox() {
        return shopBox;
    }

    public List<Product> getPurchaseProducts() {
        return purchaseProducts;
    }

    public void readFromScanner(Scanner input) {
        Store store = new Store("" , "");
        System.out.print("Enter the number of stores you want to follow: ");
        int numStores = input.nextInt();
        input.nextLine(); // consume the newline character

        for (int i = 0; i < numStores; i++) {
            System.out.print("Enter the name of store " + (i+1) + " you want to follow: ");
            String storeName = input.nextLine();
            followedStores.add(new Store(storeName , store.getLocation() ));
        }

        // read and add other information as needed
    }

    public void saveToFile(String fileName) {
        try (PrintWriter output = new PrintWriter(new File(fileName))) {
            output.println(this.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
    }

    // override the toString method to convert the object to a String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Followed stores: ");
        for (Store store : followedStores) {
            sb.append(store.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\nShop box: ");
        for (Product product : shopBox) {
            sb.append(product.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("\nPurchased products: ");
        for (Product product : purchaseProducts) {
            sb.append(product.getName()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
