
//import java.io.Console;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Menu {
    Display display = new Display();
    UserWarehouse warehouse = new UserWarehouse();
    User currentUser;
    AccountWarehouse accountWarehouse = new AccountWarehouse();
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    public void runMenu() {
        boolean running = true;

        while (running == true) {
            try {
                System.out.println("ATM Main Menu:");
                Display.printMenuOptions();
                System.out.println("Enter Option Number: ");
                Integer userInput = display.getIntInput();

                switch (userInput) {
                    case 1:
                        logInMenu();
                        break;
                    case 2:
                        createUserMenu();
                        break;
                    default:
                        System.out.println("Not an Option, choose again");
                        runMenu();
                }
            } catch(Exception e) {
                System.out.println("Invalid Input");
                runMenu();
            }
        }
    }

    public void loggedInMenu() {
        Display.loggedInDisplay();
        System.out.println("Enter Option Number: ");
        Integer userInput = display.getIntInput();
        if (userInput > 9 || userInput < 1) {
            System.out.println("Invalid selection");
            loggedInMenu();
        }

        switch (userInput) {
            case 1:
                addAccountMenu();
                break;
            case 2:
                getBalanceMenu();
                break;
            case 3:
                depositMenu();
                break;
            case 4:
                withdrawMenu();
                break;
            case 5:
                transferMenu();
                break;
            case 6:
                transactionHistoryMenu();
                break;
            case 7:
                logoutMenu();
                break;
            case 8:
                closeAccountMenu();
                break;
            default:
                System.out.println("Not an Option, choose again");
                loggedInMenu();




        }

    }

    public void logInMenu() {

            System.out.println("Enter User ID: ");
            String iD = display.getStringInput();
            System.out.println("Enter Password: ");
            String pin = display.getStringInput();
            currentUser = warehouse.userLogin(iD, pin);
            if (currentUser != null) {
                loggedInMenu();
            }

    }

    public void createUserMenu() {
            System.out.println("Enter First Name: ");
            String firstName = display.getStringInput();
            System.out.println("Enter Last Name: ");
            String lastName = display.getStringInput();
            System.out.println("Create Password: ");
//           System.out.println("Please Enter Password: ");
////         char[] password = console.readPassword("Please Enter Password: ");
////         String pass = new String(password);
            String password = display.getStringInput();
            User user = warehouse.addNewUser(firstName, lastName, password);
            System.out.println(" \n User " + firstName + " " + lastName + " successfully created, here is your ID: " + user.getUUID() + "\n");
            currentUser = user;
            loggedInMenu();
    }

    public void withdrawMenu() {
        try {
            System.out.println(" \n Which account would you like to withdraw from? \n0. Back");
            displayUserAccounts();
            Integer accountSelection = display.getIntInput() - 1;
            if (accountSelection == -1) {
                loggedInMenu();
            }
            System.out.println("\n How much would you like to withdraw? (In dollars and cents)");
            Double amount = display.getDoubleInput();
            Account account = currentUser.getAccounts().get(accountSelection);
            account.withdraw(amount);
            account.addTransaction(amount * -1);
            System.out.println("\n Your current balance for " + account.getClass().getSimpleName() + " is " + formatter.format(account.getBalance()) + "\n");
            loggedInMenu();
        } catch (Exception e){
            System.out.println("Invalid Input");
            withdrawMenu();
        }
    }

    public void depositMenu() {
        try {
            System.out.println("\n Which account would you like to deposit into? \n0. Back" );
            displayUserAccounts();
            Integer accountSelection1 = display.getIntInput() - 1;
            if (accountSelection1 == -1) {
                loggedInMenu();
            }
            System.out.println("\n How much would you like to deposit? (In dollars and cents)");
            Double amount1 = display.getDoubleInput();
            Account account = currentUser.getAccounts().get(accountSelection1);
            account.deposit(amount1);
            account.addTransaction(amount1);

            System.out.println("\n Your current balance for " + account.getClass().getSimpleName() + " is " +formatter.format( account.getBalance()) + "\n");
            loggedInMenu();
        } catch (Exception e){
            System.out.println("Invalid Input");
            depositMenu();
        }
    }

    public void transferMenu() {
        try {
            System.out.println("\n Which account would you like to transfer from? \n0. Back");
            displayUserAccounts();
            Integer accountSelection2 = display.getIntInput() - 1;
            if (accountSelection2 == -1) {
                loggedInMenu();
            }
            System.out.println("\n Which Account would you like to transfer to? \n0. Back");
            displayUserAccounts();
            Integer accountSelection3 = display.getIntInput() - 1;
            if (accountSelection3 == -1) {
                loggedInMenu();
            }
            System.out.println("\n How much would you like to transfer? (In dollars and cents)");
            Double amount3 = display.getDoubleInput();
            Account fromAccount = currentUser.getAccounts().get(accountSelection2);
            Account toAccount = currentUser.getAccounts().get(accountSelection3);
            fromAccount.transfer(amount3, toAccount);
            fromAccount.addTransaction(amount3 * -1);
            toAccount.addTransaction(amount3);
            System.out.println("\n Your current balance for " + fromAccount.getClass().getSimpleName() + " is " +  formatter.format(fromAccount.getBalance()) + "\n");
            System.out.println("\n Your current balance for " + toAccount.getClass().getSimpleName() + " is " + formatter.format(toAccount.getBalance()) + "\n");
            loggedInMenu();

        } catch (Exception e){
            System.out.println("Invalid Input");
            transferMenu();
        }
    }

    public void getBalanceMenu() {
        try {
            System.out.println("\n Which account balance would you like to check? \n0. Back");
            displayUserAccounts();
            Integer accountSelection4 = display.getIntInput() - 1;
            if (accountSelection4 == -1) {
                loggedInMenu();
            }

            Account account = currentUser.getAccounts().get(accountSelection4);
            if (account.type.equals("checking")) {
                System.out.println("\n\nYour current balance for " + account.getClass().getSimpleName() + " is " + formatter.format(account.getBalance()) + "\n\n\n");
            }
            else if (account.type.equals("savings")) {

                System.out.println(String.format("\n\n%s\n%s\n%.2f\nCurrent interest rate is: %1.1f\n" +
                                "With current balance as principal,\ncompounded monthly," +
                                "\nthis account will accrue: $%.2f in 1 year.\n\n\n",
                         "Savings", account.getAccountNumber(), account.getBalance(), account.interestPercent, account.accrued));
            }
            else if (account.type.equals("investment")) {

                System.out.println(String.format("\n\n%s\n%s\n%.2f\nCurrent interest rate is: %1.1f\n" +
                                "With current balance as principal,\ncompounded daily," +
                                "\nthis account will accrue: $%.2f in 1 year.\n\n\n",
                         "investment",
                        account.getAccountNumber(), account.getBalance(), account.interestPercent, account.accrued));
            }
            loggedInMenu();
        } catch (Exception e){
            System.out.println("Invalid Input");
            getBalanceMenu();
        }
    }

    public void logoutMenu() {
        try {
            System.out.println("\n Would you like to logout? \n0: Back");
            display.logOutMenu();
            Integer logoutSelection = display.getIntInput();
            if(logoutSelection < 0 || logoutSelection > 2){
                System.out.println("\n Invalid Input");
                logoutMenu();
            }
            if (logoutSelection == 1) {
                currentUser = null;
                runMenu();
            } else {
                loggedInMenu();
            }
        } catch (Exception e){
            System.out.println("\n Invalid Input");
            logoutMenu();
        }
    }

    public void closeAccountMenu() {
        try {
            System.out.println("\n Select the account you wish to close \n0. Back");
            displayUserAccounts();
            Integer closeAccountSelection2 = display.getIntInput() - 1;
            if (closeAccountSelection2 == -1) {
                loggedInMenu();
            }
            Account selectedAccount = currentUser.getAccounts().get(closeAccountSelection2);
            if (selectedAccount.getBalance() == 0) {
                System.out.println(" \n Are you sure you want to close this account?");
                display.closedAccountMenu();
                Integer closeAccountSelection = display.getIntInput();
                if (closeAccountSelection == 1) {
                    System.out.println("\n Are you sure?");
                    display.closedAccountMenu();
                    if (closeAccountSelection == 1) {
                        System.out.println("\n Thank you for your business");
                        accountWarehouse.removeAccount(currentUser, selectedAccount.getAccountNumber());
                        loggedInMenu();
                    }
                } else {
                    loggedInMenu();
                }

            }
            if (selectedAccount.getBalance() > 0) {
                System.out.println("\n Please empty account before closing");
                loggedInMenu();
            }
        }catch (Exception e){
            System.out.println("Invalid Input");
            closeAccountMenu();
        }

        }

    public void addAccountMenu() {
        try {
            System.out.println("\n What type of Account would you like to make? \n0: Back");
            Display.addAccountsMenu();
            Integer accountSelection6 = display.getIntInput();
            if (accountSelection6 < 0 || accountSelection6 > 3){
                System.out.println("Invalid Input");
                addAccountMenu();
            }if (accountSelection6 == 0){
                loggedInMenu();
            }
            System.out.println("\n How much would you like to deposit into your new Account? \n:0 Back");
            Double amount2 = display.getDoubleInput();
            if (amount2 == 0 || amount2 < 0){
                System.out.println("\n Invalid input new accounts must have a positive balance.");
                addAccountMenu();
            }
            Random ran = new Random();
            Integer num = ran.nextInt(90000000) + 10000000;
            String accountNum = Integer.toString(num);
            if (accountSelection6 == 1) {
                accountWarehouse.createCheckingAccount(currentUser, amount2);
                System.out.println("\n Your Checking account was successfully created, with balance of " + formatter.format(amount2) + "\n");
                loggedInMenu();
            }
            if (accountSelection6 == 2) {
                accountWarehouse.createSavingsAccount(currentUser, amount2);
                System.out.println("\n You Savings account was successfully created, with balance of " + formatter.format(amount2)+ "\n");
                loggedInMenu();

            }
            if (accountSelection6 == 3) {
                accountWarehouse.createInvestmentAccount(currentUser, amount2);
                System.out.println("\n You Investment account was successfully created, with balance of " + formatter.format(amount2)+ "\n");
                loggedInMenu();

            }


        } catch (Exception e){
            System.out.println("Invalid Input");
            addAccountMenu();
        }
    }

    public void transactionHistoryMenu() {
        try {
            System.out.println("\n Which account transaction history would you like to view? \n0. Back");
            displayUserAccounts();
            Integer accountSelection4 = display.getIntInput() - 1;
            if (accountSelection4 == -1) {
                loggedInMenu();
            }
            Account account = currentUser.getAccounts().get(accountSelection4);
            System.out.println("\n Here is your transaction history for " + account.getClass().getSimpleName());
            account.printTransactionHistory();
            loggedInMenu();
        } catch (Exception e){
            System.out.println("Invalid Input");
            transactionHistoryMenu();
        }
    }

    public void displayUserAccounts(){
    ArrayList<Account> accounts = currentUser.getAccounts();
    for (int i = 0; i < accounts.size(); i++) {
        System.out.println(i+1 + ". " + accounts.get(i).getClass().getSimpleName());

    }
}
}

