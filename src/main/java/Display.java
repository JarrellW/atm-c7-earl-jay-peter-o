import java.sql.SQLOutput;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);

    public static void printMenuOptions() {
        System.out.println("1:Login 2:Create User");
    }
    public static void loggedInDisplay(){
        System.out.println("1: Add Account \n" +
                "2: Get Balance \n" +
                "3: Deposit \n" +
                "4: Withdraw \n" +
                "5: Transfer \n" +
                "6: Transaction History \n" +
                "7: Logout \n" +
                "8: Close Account");

    }
    public static void logOutMenu(){
        System.out.println("1: Yes \n" +
                "2: No");
    }
    public static void closedAccountMenu(){
        System.out.println("1: Yes\n" +
                "2: No");
    }
    public static void addAccountsMenu(){
        System.out.println("1: Checking \n" +
                "2: Savings \n" +
                "3: Investments \n");
    }

    public Integer getIntInput() {
        Scanner scanner = new Scanner(System.in);
        Integer userInput = scanner.nextInt();
        System.out.println(userInput);
        return userInput;
    }

    public String getStringInput(){
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    }
    public Double getDoubleInput(){
        Scanner scanner = new Scanner(System.in);
        Double userInput = scanner.nextDouble();
        return userInput;
    }
    }

