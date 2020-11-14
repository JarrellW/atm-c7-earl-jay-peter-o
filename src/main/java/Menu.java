

public class Menu {
    Display display = new Display();

    public void runMenu() {
        boolean running = true;

//        User currentUser = null;

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
                    createAccountMenu();
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

        }

    }

    public void logInMenu() {
        System.out.println("Enter User ID: ");
        String iD = display.getStringInput();
        System.out.println("Enter Pin: ");
        Integer pin = display.getIntegerInput();
//          currentUser = memory.findUser(iD, pin);
    }

    public void createAccountMenu() {
        System.out.println("Enter First Name: ");
        String firstName = display.getStringInput();
        System.out.println("Enter Last Name: ");
        String lastName = display.getStringInput();
        System.out.println("Create ID: ");
        String newID = display.getStringInput();
        System.out.println("Create Pin: ");
        Integer newPin = display.getIntegerInput();
    }

    public void withdrawMenu() {
        System.out.println("Which account would you like to withdraw from? \n 0. Back");
//                      currentUser.displayAccounts();
        Integer accountSelection = display.getIntegerInput() - 1;
        if (accountSelection == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to withdraw? (In dollars and cents)");
        Double amount = display.getDoubleInput();
//                      System.out.println("Your current balance is " + currentUser.getAccounts.get(accountSelection).getBalance());
    }

    public void depositMenu() {
        System.out.println("Which account would you like to deposit into? \n 0. Back");
//          currentUser.displayAccounts();
        Integer accountSelection1 = display.getIntegerInput() - 1;
        if (accountSelection1 == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to deposit? (In dollars and cents)");
        Double amount1 = display.getDoubleInput();
//          System.out.println("Your current balance is " + currentUser.getAccounts.get(accountSelection1).getBalance());
    }

    public void transferMenu() {
        System.out.println("Which account would you like to transfer from? \n 0. Back");
//          currentUser.displayAccounts();
        Integer accountSelection2 = display.getIntegerInput() - 1;
        if (accountSelection2 == -1) {
            loggedInMenu();
        }
        System.out.println("Which Account would you like to transfer to? \n 0. Back");
//                      currentUser.displayAccounts();
        Integer accountSelection3 = display.getIntegerInput() - 1;
        if (accountSelection3 == -1) {
            loggedInMenu();
        }
        System.out.println("How much would you like to transfer? (In dollars and cents");
        Double amount3 = display.getDoubleInput();
//          System.out.println("Your current balance is " + currentUser.getAccounts.get(accountSelection2).getBalance());

    }

    public void getBalance() {
        System.out.println("Which account balance would you like to check? \n 0. Back");
//            currentUser.displayAccounts();
        Integer accountSelection4 = display.getIntegerInput() - 1;
        if (accountSelection4 == -1) {
            loggedInMenu();
        }
//            System.out.println("Your current balance is " + currentUser.getAccounts.get(accountSelection4).getBalance());

    }

    public void logoutMenu() {
        System.out.println("Would you like to logout?");
        display.logOutMenu();
        Integer logoutSelection = display.getIntegerInput();
        if (logoutSelection == 1) {
//                currentUser = null;
            runMenu();
        } else {
            loggedInMenu();
        }
    }

    public void closeAccountMenu() {
        System.out.println("Select the account you wish to close \n 0. Back");
//            currentUser.displayAccounts();
        Integer closeAccountSelection2 = display.getIntegerInput() - 1;
        if (closeAccountSelection2 == -1) {
            loggedInMenu();
        }
//            Account selectedAccount = currentUser.getAccounts.get(closeAccountSelection2);
//            if (selectedAccount.getBalance() == 0) {
//                System.out.println("Are you sure you want to close this account?");
//                display.closedAccountMenu();
//                Integer closeAccountSelection = display.getIntegerInput();
//                if (closeAccountSelection == 1){
//                    System.out.println("Are you sure?");
//                    display.closedAccountMenu();
//                    if (closeAccountSelection == 1){
//                        System.out.println("Thank you for your business");
//                        currentUser.removeAccount(closeAccountSelection);
//                        loggedInMenu();
//                    }
//                }else{
//                    loggedInMenu();
//                }
//
//            }
//            if (selectedAccount.getBalance() > 0){
//                System.out.println("Please empty account before closing");
//                loggedInMenu();
//            }
//
//        }
    }
}

