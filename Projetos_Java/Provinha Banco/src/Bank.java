import java.util.AbstractCollection;

public class Bank {
    private int number;
    private Account[] accountList = new Account[100];
    private int accountNumber;



    public Bank(int number) {
        this.number = number;
    }



    public double approveLimit(double amount, int accountTime)  {
        return Math.min(amount, 200 + 300 * accountTime);
    }
    private void addAccount (Account newAccount){
        this.accountList[accountNumber++] = newAccount;
    }
    private void deleteAccount (long number){
        for (int position = 0; position < accountNumber-1; position++) {
            if(number == accountList[position].getNumber()){
                for (int i = position; i < accountNumber-2; i++) {
                    accountList[i] = accountList[i+1];
                }
                accountList[--accountNumber] = null;
                break;
            }
        }
    }
    private void listAccounts() { listAccounts(-1);
    }
    private void listAccounts(long agency) {
        if(agency == -1)
            for (int i = 0; i < accountNumber; i++) accountList[i].show();
        for (int i = 0; i < accountNumber; i++) {
            if(agency == accountList[i].getAgency()) accountList[i].show();
            break;
        }
    }
    public int getNumber (){
        return number;
    }
}
