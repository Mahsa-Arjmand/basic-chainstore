package package1;

import java.io.*;
import java.util.*;

public class Admin implements Serializable{
    private String name;
    private String shift;
    private List<Category> categories;
    private Scanner scanner;

    public Admin(String name , String shift) {
        this.name = name;
        this.shift = shift;
        categories = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addProduct(){
        System.out.println("Enter product name :");
        String name = scanner.next();
        System.out.println("Enter product price :");
        double price = scanner.nextDouble();
        System.out.println("Enter product category");
        String categoryName = scanner.next();

        Category category = findCategory(categoryName);
        if (category == null){
            category = new Category(categoryName);
            categories.add(category);
        }
        category.addProduct(new Product(name , price));
        saveToFile();
    }

    public void editProduct(){
        System.out.println("Enter product name :");
        String name = scanner.next();
        System.out.println("Enter new price :");
        double price = scanner.nextDouble();
        Product product = findProduct(name);
        if(product == null) {
            System.out.println("Product not found.");
            return;
        }
        product.setPrice(price);
    }

    public void removeProduct(){
        System.out.println("Enter product name :");
        String name = scanner.next();
        Product product = findProduct(name);
        if(product == null){
            System.out.println("Product not  found");
            return;
        }
        Category category = findCategoryByProduct(product);
        if(category !=null){
            category.removeProduct(product);
        }
    }

    public void recharge(double amount){
        System.out.println("Recharging amount " + amount + "to" + name + "in" + shift + "shift");
        saveToFile();

    }

    public void sellProduct(){
        System.out.println("Enter product name :");
        String name = scanner.next();
        Product product = findProduct(name);
        if(product == null){
            System.out.println("Product not found");
            return;
        }
        System.out.println("Enter quantity");
        int quantity = scanner.nextInt();
        double amount = product.getPrice()*quantity;
        System.out.println("Selling" + quantity + "of" + name + "for a total of" + amount +".");
        Record record = new Record(product , quantity , amount);
        saveRecord(record);
    }

    public Double getDailyIncome(){
        double income= 0;
        for (Category category: categories ) {
            income +=category.getDailyIncome();
        }
        return income;
    }

    public Double getMonthlyIncome(){
        double income= 0;
        for (Category category: categories ) {
            income +=category.getMonthlyIncome();
        }
        return income;
    }

    public void makeFactor(){
        List<Record> records = loadRecords();
        if(records.isEmpty()){
            System.out.println("No sales records found");
            return;
        }
        System.out.println("Enter product name : ");
        String name = scanner.next();
        List<Record>filteredRecords = new ArrayList<>();
        for (Record record: records) {
            if(record.getProduct().getName().equalsIgnoreCase(name)){
                filteredRecords.add(record);
            }
        }
        if(filteredRecords.isEmpty()){
            System.out.println("No records found for" + name);
            return;
        }
        System.out.println("Sales records for" + name + ":");
        for (Record record: filteredRecords) {
            System.out.println(record.toString());
        }
        System.out.println();
        System.out.println("Total sales for" + name + ":" + getSalesTotal(filteredRecords));
    }

    public void saveToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream("admin.txt");
            ObjectOutputStream out= new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Data saved to admin.txt");
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public static Admin loadFromFile(){
        Admin admin = null;
        try {
            FileInputStream fileIn = new FileInputStream("admin.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            admin = (Admin) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data loaded from admin.txt");
        }catch (IOException i){
            i.printStackTrace();
        }catch (ClassNotFoundException c){
            System.out.println("Admin class not found");
            c.printStackTrace();
        }
        return admin;
    }

    private Category findCategory(String name) {
        for (Category category: categories) {
            if(category.getName().equalsIgnoreCase(name)){
                return category;
            }
        }
        return null;
    }

    private Category findCategoryByProduct(Product product) {
        for (Category category: categories) {
            if (category.hasProduct(product)) {
                return category;
            }
        }
        return null;
    }

    private Product findProduct(String name) {
        for (Category category: categories) {
            Product product = category.findProduct(name);
            if(product != null){
                return product;
            }
        }
        return null;
    }

    private void saveRecord(Record record) {
        try{
            FileOutputStream fileOut = new FileOutputStream("sales.ser ", true);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(record);
            out.close();
            fileOut.close();
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    private List<Record> loadRecords() {
        List<Record> records = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("sales.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (true){
                //read all records until EOFException
                Record record = (Record) in.readObject();
                records.add(record);
            }
        }catch (EOFException e){
            //end of file reached , do nothing
        }catch (IOException i){
            i.printStackTrace();
        }catch (ClassNotFoundException c){
            System.out.println("Record class not found.");
            c.printStackTrace();
        }
        return records;
    }

    private double getSalesTotal(List<Record> records) {
        double total = 0;
        for (Record record: records) {
            total += record.getAmount();
        }
        return total;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getName() {
        return name;
    }

    public String getShift() {
        return shift;
    }

    public void display(double amount) {
        Admin admin = new Admin("", "");
        boolean flag = true;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add product");
            System.out.println("2. Edit product ");
            System.out.println("3. Remove product ");
            System.out.println("4. Recharge product ");
            System.out.println("5. Sell product :");
            System.out.println("6. Get daily income");
            System.out.println("7. Get monthly income");
            System.out.println("8. Make factor");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    admin.addProduct();
                    break;
                case 2:
                    admin.editProduct();
                    break;
                case 3:
                    admin.removeProduct();
                    break;
                case 4:
                    admin.recharge(amount);
                    break;
                case 5:
                    admin.sellProduct();
                    break;
                case 6:
                    admin.getDailyIncome();
                    break;
                case 7:
                    admin.getMonthlyIncome();
                    break;
                case 8:
                    admin.makeFactor();
                    break;
                case 9:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid number");
            }
        } while (flag);
    }
}
