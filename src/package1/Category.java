package package1;

import java.io.Serializable;
import java.util.*;

public class Category implements Serializable {
    private String name;
    private List<Product>products;
    private double dailyIncome;
    private double monthlyIncome;

    public Category(String name) {
        this.name = name;
        products = new ArrayList<>();
        dailyIncome = 0;
        monthlyIncome = 0;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public  boolean hasProduct(Product product){
        return products.contains(product);
    }

    public Product findProduct(String name){
        for (Product product: products) {

            if (product.getName().equalsIgnoreCase(name)){
                return product;
            }
        }
       return null;
    }

    public void updateDailyIncome(double amount){
        dailyIncome += amount;
    }

    public void updateMonthlyIncome(double amount){
        monthlyIncome += amount;
    }
}
