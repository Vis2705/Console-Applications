import java.util.Scanner;

public class ATM {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        int choice;

        do {
            System.out.println("\n--- ATM SYSTEM ---");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if(choice == 1){
                Admin.adminMenu();
            }
            else if(choice == 2){
                User.userLogin();
            }

        } while(choice != 3);

        System.out.println("Thank you for using ATM");
    }
}
