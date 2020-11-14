import java.sql.SQLOutput;
import java.util.Scanner;

public class Display {
    Scanner scanner = new Scanner(System.in);

    public static void printMenuOptions() {
        System.out.println("1:Login 2:Create User");
    }
    public static void loggedInMenu(){
        System.out.println("1:Withdraw 2:Deposit 3:transfer 4:Get Balance 5:Logout 6:Close Account");
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

}
