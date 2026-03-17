import java.util.Scanner;

public class Admin {

    static int adminPin = 1234;
    static int atmBalance = 10000;

    static Scanner sc = new Scanner(System.in);

    public static void adminMenu(){

        System.out.print("Enter admin pin: ");
        int pin = sc.nextInt();

        if(pin != adminPin){
            System.out.println("Wrong pin");
            return;
        }

        int choice;

        do {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Deposit to ATM");
            System.out.println("2. Check ATM Balance");
            System.out.println("3. Exit");

            choice = sc.nextInt();

            switch(choice){
                case 1:
                    deposit();
                    break;

                case 2:
                    viewBalance();
                    break;
            }

        } while(choice != 3);
    }

    public static void deposit(){

        System.out.println("Current ATM Balance: " + atmBalance);
        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        if(amt > 0 && amt % 100 == 0){ // ⭐ validation
            atmBalance += amt;
            System.out.println("Deposit successful");
        }
        else{
            System.out.println("Invalid amount");
        }

        System.out.println("Updated ATM Balance: " + atmBalance);
    }

    public static void viewBalance(){
        System.out.println("ATM Balance: " + atmBalance);
    }
}
