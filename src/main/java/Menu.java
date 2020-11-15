
import java.util.ArrayList;
import java.util.Random;

public class Menu {
    Display display = new Display();
    UserWarehouse warehouse = new UserWarehouse();
    User currentUser;
    AccountWarehouse accountWarehouse = new AccountWarehouse();

    public void runMenu() {
        boolean running = true;

        while (running == true) {
            System.out.println("ATM Main Menu:");
            Display.printMenuOptions();
            System.out.println("Enter Option Number: ");
            Integer userInput = display.getIntegerInput();

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
        }
    }

    public void loggedInMenu() {
        Display.loggedInDisplay();
        System.out.println("Enter Option Number: ");
        Integer userInput = display.getIntegerInput();

        switch (userInput) {
            case 1:
                addAccountMenu();
                break;
            case 2:
                getBalance();
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
//        String firstName = Console.;
        System.out.println("Enter Last Name: ");
        String lastName = display.getStringInput();
        System.out.println("Create Password: ");
//        Console console = System.console();
//        char[] newPin = console.readPassword();
//        String password = new String(newPin);
        String password = display.getStringInput();
        User user = warehouse.addNewUser(firstName,lastName,password);
        System.out.println(" \n User " + firstName + " " + lastName + " successfully created, here is your ID: " + user.getUUID() + "\n");
        currentUser = user;

        loggedInMenu();
    }

    public void withdrawMenu() {
        System.out.println("Which account would you like to withdraw from? \n0. Back");
        displayUserAccounts();
        Integer accountSelection = display.getIntegerInput() - 1;
        if (accountSelection == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to withdraw? (In dollars and cents)");
        Double amount = display.getDoubleInput();
        Account account = currentUser.getAccounts().get(accountSelection);
        account.withdraw(amount);
        account.addTransaction(amount * -1);
        System.out.println("\n Your current balance for " + account.getClass().getSimpleName() + " is "+ account.getBalance()+ "\n");
        loggedInMenu();
    }

    public void depositMenu() {
        System.out.println("Which account would you like to deposit into? \n0. Back");
        displayUserAccounts();
        Integer accountSelection1 = display.getIntegerInput() - 1;
        if (accountSelection1 == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to deposit? (In dollars and cents)");
        Double amount1 = display.getDoubleInput();
        Account account = currentUser.getAccounts().get(accountSelection1);
        account.deposit(amount1);
        account.addTransaction(amount1);
          System.out.println("\n Your current balance for " + account.getClass().getSimpleName() + " is "+ account.getBalance()+ "\n");
          loggedInMenu();
    }

    public void transferMenu() {
        System.out.println("Which account would you like to transfer from? \n0. Back");
        displayUserAccounts();
        Integer accountSelection2 = display.getIntegerInput() - 1;
        if (accountSelection2 == -1) {
            loggedInMenu();
        }
        System.out.println("Which Account would you like to transfer to? \n0. Back");
        displayUserAccounts();
        Integer accountSelection3 = display.getIntegerInput() - 1;
        if (accountSelection3 == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to transfer? (In dollars and cents)");
        Double amount3 = display.getDoubleInput();
        Account fromAccount = currentUser.getAccounts().get(accountSelection2);
        Account toAccount = currentUser.getAccounts().get(accountSelection3);
        fromAccount.transfer(amount3, toAccount);
        fromAccount.addTransaction(amount3 * -1);
        toAccount.addTransaction(amount3);
        System.out.println("\n Your current balance for " + fromAccount.getClass().getSimpleName() + " is " + fromAccount.getBalance() + "\n");
        System.out.println("\n Your current balance for " + toAccount.getClass().getSimpleName() + " is " + toAccount.getBalance() + "\n");
        loggedInMenu();

    }

    public void getBalance() {
        System.out.println("Which account balance would you like to check? \n0. Back");
         displayUserAccounts();
        Integer accountSelection4 = display.getIntegerInput() - 1;
        if (accountSelection4 == -1) {
            loggedInMenu();
        }
        Account account = currentUser.getAccounts().get(accountSelection4);
        System.out.println("\n Your current balance for " + account.getClass().getSimpleName() + " is "+ account.getBalance()+ "\n");
        loggedInMenu();
    }

    public void logoutMenu() {
        System.out.println("Would you like to logout?");
        display.logOutMenu();
        Integer logoutSelection = display.getIntegerInput();
        if (logoutSelection == 1) {
                currentUser = null;
            runMenu();
        } else {
            loggedInMenu();
        }
    }

    public void closeAccountMenu() {
        System.out.println("Select the account you wish to close \n0. Back");
            displayUserAccounts();
        Integer closeAccountSelection2 = display.getIntegerInput() - 1;
        if (closeAccountSelection2 == -1) {
            loggedInMenu();
        }
            Account selectedAccount = currentUser.getAccounts().get(closeAccountSelection2);
            if (selectedAccount.getBalance() == 0) {
                System.out.println("Are you sure you want to close this account?");
                display.closedAccountMenu();
                Integer closeAccountSelection = display.getIntegerInput();
                if (closeAccountSelection == 1){
                    System.out.println("Are you sure?");
                    display.closedAccountMenu();
                    if (closeAccountSelection == 1){
                        System.out.println("Thank you for your business");
//                        currentUser.removeAccount(closeAccountSelection);
                        loggedInMenu();
                    }
                }else{
                    loggedInMenu();
                }

            }
            if (selectedAccount.getBalance() > 0){
                System.out.println("Please empty account before closing");
                loggedInMenu();
            }

        }
        public void addAccountMenu(){
            System.out.println("What type of Account would you like to make?");
            Display.addAccountsMenu();
            Integer accountSelection6 = display.getIntegerInput();
            System.out.println("How much would you like to deposit into your new Account?");
            Double amount2 = display.getDoubleInput();
            Random ran = new Random();
            Integer num = ran.nextInt(90000000) + 10000000;
            String accountNum = Integer.toString(num);
            if (accountSelection6 == 1){
                accountWarehouse.createCheckingAccount(currentUser,amount2);
//                Checking checking = new Checking(amount2,currentUser,accountNum);
//                currentUser.getAccounts().add(checking);
                System.out.println("\n Your Checking account was successfully created, with balance of " + amount2 + "\n");
                loggedInMenu();
            }
            if (accountSelection6 == 2){
                accountWarehouse.createSavingsAccount(currentUser,amount2);
//                Savings savings = new Savings(amount2,currentUser,accountNum);
//                currentUser.getAccounts().add(savings);
                System.out.println("\n You Savings account was successfully created, with balance of " + amount2 + "\n");
                loggedInMenu();

            }
            if (accountSelection6 == 3){
                accountWarehouse.createInvestmentAccount(currentUser,amount2);
//                Investment investment = new Investment(amount2,currentUser,accountNum);
//                currentUser.getAccounts().add(investment);
                System.out.println("\n You Investment account was successfully created, with balance of " + amount2 + "\n");
                loggedInMenu();

            }


    }
    public void transactionHistoryMenu(){
        System.out.println("Which account transaction history would you like to view? \n0. Back");
        displayUserAccounts();
        Integer accountSelection4 = display.getIntegerInput() - 1;
        if (accountSelection4 == -1) {
            loggedInMenu();
        }
        Account account = currentUser.getAccounts().get(accountSelection4);
        System.out.println("\n Here is your transaction history for " + account.getClass().getSimpleName());
        account.printTransactionHistory();
        loggedInMenu();
    }
    public void displayUserAccounts(){
        ArrayList<Account> accounts = currentUser.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i+1 + ". " + accounts.get(i).getClass().getSimpleName());

        }
    }
}

