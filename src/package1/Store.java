package package1;

import java.io.Serializable;
import java.util.*;

public class Store implements Serializable {
    private String name;
    private String location;
    private List<Admin> admins;
    private double income;
    private List<String> products;

    public Store(String name , String location) {
        this.name = name;
        this.location = location;
        admins = new ArrayList<>();
        income = 0;
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public double getIncome() {
        return income;
    }

    public List<String> getProducts() {
        return products;
    }

    public void addAdmin(Admin admin){
        admins.add(admin);
    }

    public void removeAdmin(Admin admin){
        admins.remove(admin);
    }

    public void removeAdmin(String name){
        Admin admin = findAdmin(name);
        if(admin != null){
            admins.remove(admin);
        }
    }

    public Admin findAdmin(String name) {
        for (Admin admin: admins) {
            if (admin.getName().equalsIgnoreCase(name)){
                return admin;
            }

        }
        return null;
    }

    public void updateIncome(double amount){
        income += amount;
    }

    public void addProduct(String product){
        products.add(product);
    }

    public void removeProduct(String product){
        products.remove(product);
    }

    public void addIdea(Store idea) {
    }

    public void voteIdea(String idea) {
    }

    //public void registerCustomer(Customer customer) {
    //}

    public double getProductPrice() {
        return 0;
    }

    public boolean hasProduct(Product product) {
        return false;
    }

    public void searchProducts() {
        //for (Product product: products) {
          //  System.out.println(product);
        }
    }
