package package1;

import java.io.*;
import java.util.*;

public class Manager {
    private List<Store> stores;
    private Scanner scanner;

    public Manager(){
        stores = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStore(){
        System.out.println("Enter store name :");
        String name = scanner.next();
        System.out.println("Enter store location : ");
        String location = scanner.next();
        stores.add(new Store(name , location));
        saveToFile();
    }

    public void addAdmin(){
        System.out.println("Enter store name :");
        String storeName = scanner.next();
        Store store = findStore(storeName);
        if(store == null){
            System.out.println("Store not found");
            return;
        }
        System.out.println("Enter admin name :");
        String name = scanner.next();
        System.out.println("Enter admin shift (Morning / Noon / Night) : ");
        String shift = scanner.next();
        store.addAdmin(new Admin(name , shift));
    }
    public void editAdmin(){
        System.out.println("Enter store name: ");
        String storeName = scanner.next();
        Store store = findStore(storeName);
        if (store == null){
            System.out.println("Store not found.");
            return;
        }
        System.out.println("Enter admin name :");
        String name = scanner.next();
        Admin admin = store.findAdmin(name);
        if (admin == null){
            System.out.println("Admin not found.");
            return;
        }
        System.out.println("Enter new shift (Morning / Noon / Night) : ");
        String shift = scanner.next();
        admin.setShift(shift);
    }

    public void removeAdmin(){
        System.out.println("Enter store name :");
        String storeName = scanner.next();
        Store store = findStore(storeName);
        if (store == null){
            System.out.println("Store not found.");
            return;
        }
        System.out.println("Enter admin name :");
        String name = scanner.next();
        store.removeAdmin(name);
    }

    public void viewStoreInfo(){
        for (Store store: stores) {
            System.out.println("Store Name :" + store.getName());
            System.out.println("Store Location :" + store.getLocation());
            System.out.println("Store income :" + store.getIncome());
            System.out.println("Present products :");
            List<String> products = store.getProducts();
            for (String product: products) {
                System.out.println("-" + product);
            }
            System.out.println();
        }

    }

    public void viewStoreAdmins(){
        System.out.println("Enter store name: ");
        String storeName = scanner.next();
        Store store = findStore(storeName);
        if (store == null){
            System.out.println("Store not found.");
            return;
        }
        System.out.println("Store name :" + store.getName());
        System.out.println("Store Location :" + store.getLocation());
        System.out.println("Admins :");
        List<Admin> admins = store.getAdmins();
        for (Admin admin: admins) {
            System.out.println("-" + admin.getName() + "(" + admin.getShift() + "Shift )");

        }
    }

    private Store findStore(String name) {
        for (Store store: stores) {
            if(store.getName().equalsIgnoreCase(name)){
                return store;
            }
        }

        return null;
    }

    public void saveToFile(){
        try {
            FileOutputStream fileOut = new FileOutputStream("chainstore.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(stores);
            out.close();
            fileOut.close();
            System.out.println("Data saved to chainstore.txt");
        }
        catch (IOException i){
            i.printStackTrace();
        }
    }

    public void loadFromFile(){
        try {
            FileInputStream fileIn = new FileInputStream("chainstore.txt");
            ObjectInputStream In = new ObjectInputStream(fileIn);
            stores = (List<Store>) In.readObject();
            In.close();
            fileIn.close();
            System.out.println("Date loaded from chainstore.txt");
        }catch (IOException i){
            i.printStackTrace();
        }
        catch (ClassNotFoundException c ){
            System.out.println("ChainStoreManager class not found");
            c.printStackTrace();
        }
    }

    public void display(){
        Manager manager = new Manager();
        boolean flag= true;
        do{
            System.out.println("Enter your choice:");
            System.out.println("1. Add store");
            System.out.println("2. Add admin");
            System.out.println("3. Edit admin");
            System.out.println("4. Remove admin");
            System.out.println("5. View store informations :");
            System.out.println("6. View admins");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    manager.addStore();
                    break;
                case 2:
                    manager.addAdmin();
                    break;
                case 3:
                    manager.editAdmin();
                    break;
                case 4:
                    manager.removeAdmin();
                    break;
                case 5:
                    manager.viewStoreInfo();
                    break;
                case 6:
                    manager.viewStoreAdmins();
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid number");
            }
        }while (flag);
    }
}
