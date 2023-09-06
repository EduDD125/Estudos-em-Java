import java.util.AbstractCollection;

public class Bank {
    private int number;
    private Account[] accountList = new Account[100];
    private int accountNumber;



    public Bank(int number) {
        this.number = number;
    }



    public void askBankToIncreseLimit(Account client, double amount) {
        if (isAllowedToIncreseLimit(client, amount))
            client.setAvaliableCredit(acceptLimit(amount));
    }
    private boolean isAllowedToIncreseLimit(Account client, double amount) {
        if (amount + client.getAvaliableCredit() <= 200 + (300 * client.getAccountTime()))
            return true;
        System.out.println("Request for new credit limit denied");
        return false;
    }

    public double acceptLimit(double amount) {
            return amount;
    }
    private void addAccount (Account newAccount){
        this.accountList[accountNumber] = newAccount;
    }
    private void deleteAccount (long number){
        if (accountNumber == 0) {
            System.out.println("\n\n ##########################");
            System.out.println("You only have one account last and you can´t deleted all account of a bank." +
                    " You need to add a new account first, than you are allowed to delete the account you want.");
        }
        else
            for (int position = 0; position < accountNumber-1; position++) {
                 if(accountList[position].getNumber() == number){
                     for (int i = position; i < accountNumber-2; i++) {
                          accountList[i] = accountList[i+1];
                     }
                     accountList[--accountNumber] = null;
                     break;
                 }
        }

    }
    private void listAccounts() {
        StringBuilder sb = new StringBuilder();
        System.out.println("\n\n###          Listing Account       ###");
        for (int i = 0; i < accountNumber; i++) {
            sb.append("number: ").append(accountList[i].getNumber()).append(" | ")
                    .append("agency: ").append(accountList[i].getAgency()).append("\n");
            System.out.println(sb);
        }
    }
    private void listAccounts(long agency) {
        StringBuilder sb = new StringBuilder();
        System.out.println("\n\n###          Listing Account       ###");
        for (int i = 0; i < accountNumber; i++) {
            if(accountList[i].getAgency() == agency) {
                sb.append("number: ").append(accountList[i].getNumber()).append(" | ")
                        .append("agency: ").append(accountList[i].getAgency()).append("\n");
                System.out.println(sb);
            }
        }
    }
    public int getNumber (){
        return number;
    }
}
