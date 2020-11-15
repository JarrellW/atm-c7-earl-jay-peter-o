import java.util.ArrayList;
import java.util.Random;

public class Menu {
    Display display = new Display();
    UserWarehouse warehouse = new UserWarehouse();
    User currentUser;

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
                withdrawMenu();
                break;
            case 2:
                depositMenu();
                break;
            case 3:
                transferMenu();
                break;
            case 4:
                getBalance();
                break;
            case 5:
                logoutMenu();
                break;
            case 6:
                closeAccountMenu();
                break;
            case 7:
                addAccountMenu();
                break;


        }

    }

    public void logInMenu() {
        System.out.println("Enter User ID: ");
        String iD = display.getStringInput();
        System.out.println("Enter Pin: ");
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
        System.out.println("Create Pin: ");
        String newPin = display.getStringInput();
        User user = new User(firstName,lastName,newPin,warehouse);
        System.out.println("User " + firstName + " " + lastName + " successfully created" );
        currentUser = user;
        loggedInMenu();
    }

    public void withdrawMenu() {
        System.out.println("Which account would you like to withdraw from? \n 0. Back");
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
        System.out.println("Your current balance is " + currentUser.getAccounts().get(accountSelection).getBalance());
    }

    public void depositMenu() {
        System.out.println("Which account would you like to deposit into? \n 0. Back");
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
          System.out.println("Your current balance is " + currentUser.getAccounts().get(accountSelection1).getBalance());
    }

    public void transferMenu() {
        System.out.println("Which account would you like to transfer from? \n 0. Back");
        displayUserAccounts();
        Integer accountSelection2 = display.getIntegerInput() - 1;
        if (accountSelection2 == -1) {
            loggedInMenu();
        }
        System.out.println("Which Account would you like to transfer to? \n 0. Back");
        displayUserAccounts();
        Integer accountSelection3 = display.getIntegerInput() - 1;
        if (accountSelection3 == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to transfer? (In dollars and cents");
        Double amount3 = display.getDoubleInput();
        Account fromAccount = currentUser.getAccounts().get(accountSelection2);
        Account toAccount = currentUser.getAccounts().get(accountSelection3);
        fromAccount.transfer(amount3, toAccount);
        fromAccount.addTransaction(amount3 * -1);
        toAccount.addTransaction(amount3);
        System.out.println("Your current balance is " + currentUser.getAccounts().get(accountSelection3).getBalance());

    }

    public void getBalance() {
        System.out.println("Which account balance would you like to check? \n 0. Back");
         displayUserAccounts();
        Integer accountSelection4 = display.getIntegerInput() - 1;
        if (accountSelection4 == -1) {
            loggedInMenu();
        }
        currentUser.getAccounts().get(accountSelection4).getSummaryLine();
//        System.out.println("Your current balance is " + currentUser.getAccounts().get(accountSelection4).getBalance());

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
        System.out.println("Select the account you wish to close \n 0. Back");
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
                Checking checking = new Checking(amount2,new ArrayList<Transaction>(),currentUser,accountNum);
                System.out.println("You checking account was successfully created, with balance of " + checking.getBalance());
                loggedInMenu();
            }
            if (accountSelection6 == 2){
                Savings savings = new Savings(amount2,new ArrayList<Transaction>(),currentUser,accountNum);
                System.out.println("You checking account was successfully created, with balance of " + savings.getBalance());
                loggedInMenu();

            }
            if (accountSelection6 == 3){
                Investment investment = new Investment(amount2,new ArrayList<Transaction>(),currentUser,accountNum);
                System.out.println("You checking account was successfully created, with balance of " + investment.getBalance());
                loggedInMenu();

            }


    }
    public void displayUserAccounts(){
        ArrayList<Account> accounts = currentUser.getAccounts();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(i + ". " + accounts.get(i).getClass());

        }
    }
}

