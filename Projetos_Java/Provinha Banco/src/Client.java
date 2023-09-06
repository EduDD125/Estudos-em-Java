public class Client {
    private String name;
    private String cpf;
    private Account[] accountList = new Account[100];
    private int accountNumber;

    public Client(String name, String cpf) {
        this.cpf = cpf;
        this.name = name;
    }
    private void listAccounts() {
        StringBuilder sb = new StringBuilder();
        System.out.println("\n\n#####       Listing Accounts      #####");
        for (int i = 0; i < accountNumber; i++) {
            sb.append("Number: ").append(accountList[i].getNumber())
              .append(" | Agency: ").append(accountList[i].getAgency())
              .append(" |  Bank Number: ").append(accountList[i].getBankNumber())
              .append("\n");
        }
    }
    private void addAccount (Account newAccount){
        this.accountList[accountNumber] = newAccount;
    }
    private void deleteAccount (long number){
        if (accountNumber == 0) {
            System.out.println("\n\n ##########################");
            System.out.println("You only have one account last and you can´t deleted all account of a bank." +
                    " You need to add a new account first, than you are allowed to delete the account you want.");
            return;
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
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
