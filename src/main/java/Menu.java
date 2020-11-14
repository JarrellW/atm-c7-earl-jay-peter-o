public class Menu {
    public static void runMenu() {
        boolean running = true;
        Display display = new Display();
//        User currentUser = null;

        while (running == true) {
            System.out.println("ATM Main Menu:");
            Display.printMenuOptions();
            System.out.println("Enter Option Number: ");
            Integer userInput = display.getIntegerInput();

            switch (userInput) {
                case 1:
                    System.out.println("Enter User ID: ");
                    String iD = display.getStringInput();
                    System.out.println("Enter Pin: ");
                    Integer pin = display.getIntegerInput();
//                   currentUser = memory.findUser(iD, pin);
                    Display.loggedInMenu();
                    break;
                case 2:
                    System.out.println("Enter First Name: ");
                    String firstName = display.getStringInput();
                    System.out.println("Enter Last Name: ");
                    String lastName = display.getStringInput();
                    System.out.println("Create ID: ");
                    String iD = display.getStringInput();
                    System.out.println("Create Pin: ");
                    Integer pin = display.getIntegerInput();
                    break;
                default:
                    System.out.println("Not an Option, choose again");
                    break;
            }
        }
    }
}
