import java.sql.SQLOutput;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);

    public static void printMenuOptions() {
        System.out.println("1:Login 2:Create User");
    }
    public static void loggedInDisplay(){
        System.out.println("1:Withdraw 2:Deposit 3:transfer 4:Get Balance 5:Logout 6:Close Account 7: Add Account");

    }
    public static void logOutMenu(){
        System.out.println("1: Yes, 2: No");
    }
    public static void closedAccountMenu(){
        System.out.println("1: Yes, 2: No");
    }
    public static void addAccountsMenu(){
        System.out.println("1: Checking, 2: Savings, 3: Investment");
    }

    public String getStringInput() {
        String userInput = scanner.nextLine();
        System.out.println(userInput);
        return userInput;
    }

    public Integer getIntegerInput(){
        Integer userInput = scanner.nextInt();
        return userInput;
    }
    public Double getDoubleInput(){
        Double userInput = scanner.nextDouble();
        return userInput;
    }

}
