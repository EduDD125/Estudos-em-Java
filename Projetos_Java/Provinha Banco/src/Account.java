import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Account {
    private long number;
    private long agency;
    private double balance;
    private int password;
    private LocalDateTime creantionTime;

    private Client client;
    private Bank bank;
    private double avaliableCredit;

    public Account (long number, int agency, Client client, Bank bank, int password) {
        this.number = number;
        this.client = client;
        this.bank = bank;
        this.agency = agency;
        this.password = password;
        this.creantionTime = LocalDateTime.now();
    }
    private double increseLimit (double amount, int password) {
        if(passwordIsCorrect(password)) this.bank.askBankToIncreseLimit(this, amount);
        else System.out.println("Wrong password!");
        return 0;
    }

    private double balance(int password){
        if (passwordIsCorrect(password)){
            return this.getBalance();
        }
        System.out.println("Wrong password! Operation is not allowed");
        return 0;
    }
    private void deposit(double amount) {
        this.balance += amount;
    }
    private void withdraw (double amount, int password) {
        if (passwordIsCorrect(password)) {
            if (hasMoneyAvaleible(amount)) {
                this.balance -= amount;
                System.out.println("\nWithdraw completed!!");
            }
            else askIfClienWantsCredit(amount);
        }
        System.out.println("Wrong password! Operantion is not allowed");
    }
    private boolean hasMoneyAvaleible(double amount) {
        return this.balance - amount >= 0;
    }
    private void askIfClienWantsCredit(double amount) {
        System.out.println("You don´t have enought balance. Do you want to get credit from our bank? [y/n] ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if(isPostiveAnswer(answer) && isAllowedToTakeCredit(amount)) {
            giveCredit(amount);
            System.out.println("\nCredit reciving completed!!");
            withdraw(amount, password);
        }
    }
    private boolean isPostiveAnswer(String answer) {
        String positive = "y";
        return answer.equalsIgnoreCase(positive);
    }
    private boolean isAllowedToTakeCredit(double amount) {
        return avaliableCredit >= amount - this.balance;
    }
    private void giveCredit(double amount) {
        double credit = amount - this.balance;
        this.balance += credit;
        avaliableCredit -= credit;
    }
    private boolean passwordIsCorrect (int password){
        return this.password == password;
    }
    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getAgency() {
        return agency;
    }
    public double getBalance() {
        return balance;
    }

    public void setAgency(long agency) {
        this.agency = agency;
    }

    public long getAccountTime() {
        Duration durantion = Duration.between(LocalDateTime.now(), creantionTime);
        return durantion.toDays() % 365;
    }
    public double getAvaliableCredit(){
        return avaliableCredit;
    }

    public void setAvaliableCredit(double amount){
        this.avaliableCredit = amount;
    }
    public int getBankNumber(){
        return bank.getNumber();
    }
}
