import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AccountWarehouse {

    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    public String getNewAccountNumber() {
        //inits
        String accountNumber;
        Random rand = new Random();
        int length = 9;
        boolean nonUnique;

        //continue looping until a unique account number is generated
        do {
            //generate account number
            accountNumber = "";
            for(int i = 0; i < length; i++) {
                accountNumber += ((Integer)rand.nextInt(10));
            }

            //make sure uuid is actually unique
            nonUnique = false;
            for(Account a : this.accounts) {
                if(accountNumber.compareTo(a.getAccountNumber()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return accountNumber;
    }

}
