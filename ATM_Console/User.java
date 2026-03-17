import java.util.*;

public class User {

    static int[] id = {1,2,3};
    static int[] pin = {111,222,333};
    static int[] balance = {500,1000,2000};

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String>[] transactions = new ArrayList[3];
    static {
        for(int i = 0; i < transactions.length; i++){
            transactions[i] = new ArrayList<>();
        }
    }

    public static void userLogin(){

        System.out.print("Enter ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter PIN: ");
        int userPin = sc.nextInt();

        int index = -1;

        for(int i=0;i<id.length;i++){
            if(id[i]==userId && pin[i]==userPin){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("Invalid login");
            return;
        }

        userMenu(index);
    }

    public static void userMenu(int index){

        int choice;

        do {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Account Transfer");
            System.out.println("6. Mini Statement");
            System.out.println("7. Exit");

            choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.println("Balance: " + balance[index]);
                    break;

                case 2:
                    withdraw(index);
                    break;

                case 3:
                    deposit(index);
                    break;

                case 4:
                    changePin(index);
                    break;

                case 5:
                    transfer(index);
                    break;

                case 6:
                    miniStatement(index);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Wrong choice");
            }

        } while(choice != 7);
    }

    public static void withdraw(int i){

        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        if(amt <= balance[i] && amt % 100 == 0){
            balance[i] -= amt;
            System.out.println("Withdraw successful");

            addTransaction(i, "Withdraw: " + amt);
        }
        else{
            System.out.println("Invalid/Insufficient balance");
        }
    }

    public static void deposit(int i){

        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        if(amt % 100 == 0){
            balance[i] += amt;
            System.out.println("Deposit successful");

            addTransaction(i, "Deposit: " + amt); 
        }
        else{
            System.out.println("Invalid amount");
        }
    }

    public static void changePin(int i){

        System.out.print("Enter current pin: ");
        int cp = sc.nextInt();

        if(cp == pin[i]){
            System.out.print("Enter new pin: ");
            pin[i] = sc.nextInt();
            System.out.println("PIN changed");

            addTransaction(i, "PIN changed");
        }
        else{
            System.out.println("Wrong PIN");
        }
    }

    public static void transfer(int senderIndex){

        System.out.print("Enter receiver ID: ");
        int receiverId = sc.nextInt();

        int receiverIndex = -1;

        for(int i = 0; i < id.length; i++){
            if(id[i] == receiverId){
                receiverIndex = i;
                break;
            }
        }

        if(receiverIndex == -1){
            System.out.println("Receiver not found");
            return;
        }

        if(receiverIndex == senderIndex){ 
            System.out.println("Cannot transfer to same account");
            return;
        }

        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        if(amt <= balance[senderIndex] && amt > 0){

            balance[senderIndex] -= amt;
            balance[receiverIndex] += amt;

            System.out.println("Transfer successful");

            addTransaction(senderIndex, "Transferred " + amt + " to ID " + receiverId);
            addTransaction(receiverIndex, "Received " + amt + " from ID " + id[senderIndex]);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }

    public static void addTransaction(int index, String msg){
        transactions[index].add(msg);
    }

    public static void miniStatement(int index){

        System.out.println("\n--- MINI STATEMENT ---");

        if(transactions[index].isEmpty()){
            System.out.println("No transactions yet");
            return;
        }

        for(String t : transactions[index]){
            System.out.println(t);
        }
    }
}
