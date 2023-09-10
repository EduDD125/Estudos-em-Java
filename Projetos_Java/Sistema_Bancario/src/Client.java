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
        System.out.println(sb);
    }

    private void addAccount(Account newAccount) {
        this.accountList[accountNumber++] = newAccount;
    }

    private void deleteAccount(long number) {
        for (int position = 0; position < accountNumber - 1; position++) {
            if (number == accountList[position].getNumber()) {
                for (int i = position; i < accountNumber - 2; i++) {
                    accountList[i] = accountList[i + 1];
                }
                accountList[--accountNumber] = null;
                break;
            }
        }
    }
}