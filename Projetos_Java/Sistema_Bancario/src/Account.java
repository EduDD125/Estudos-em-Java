import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Account {
    private long number;
    private long agency;
    private double balance;
    private int password;
    private int accontTime;

    private Client client;
    private Bank bank;
    private double avaliableCredit;

    public Account (long number, int agency, Client client, Bank bank, int password, int accontTime) {
        this.number = number;
        this.client = client;
        this.bank = bank;
        this.agency = agency;
        this.password = password;
        this.accontTime = accontTime;
    }

    public void show(){
        StringBuilder sb = new StringBuilder();
        sb.append("Number:  ").append(this.number).append("||  Agency:   ").append(this.agency).append("||  Balance:  ")
                .append(this.balance).append("||  AccountTime:  ").append(this.accontTime).append("||  Credit Limit:  ")
                .append(this.avaliableCredit);
        System.out.println(sb);
    }
    private double increseLimit (double amount, int password) {
        if(passwordIsCorrect(password)) this.bank.approveLimit(amount, this.accontTime);
        else System.out.println("Wrong password!");
        return 0;
    }

    private double balance(int password){
        if (passwordIsCorrect(password)){
            return this.balance;
        }
        System.out.println("Wrong password! Operation is not allowed");
        return 0;
    }
    private void deposit(double amount) {
        this.balance += amount;
    }
    private boolean withdraw (double amount, int password) {
        if (!passwordIsCorrect(password) || !hasMoneyAvaleible(amount) || amount > balance + avaliableCredit) {
            return false;
        }
        this.balance -= amount;
        System.out.println("\nWithdraw completed!!");
        return true;
    }
    private boolean hasMoneyAvaleible(double amount) {
        return this.balance - amount >= 0;
    }
    private boolean passwordIsCorrect (int password){
        return this.password == password;
    }
    public long getNumber() {
        return number;
    }

    public long getAgency() {
        return agency;
    }
    public int getBankNumber(){
        return bank.getNumber();
    }
}
