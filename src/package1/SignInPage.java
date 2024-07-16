package package1;

import java.util.Scanner;

public class SignInPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager =new Manager();
        Admin admin = new Admin("" , "");

        System.out.println("choose your roll");
        int n = scanner.nextInt();
        switch (n){
            case 1:
                manager.display();
                break;
            case 2:
               // admin.display();
                break;
        }
    }
}
