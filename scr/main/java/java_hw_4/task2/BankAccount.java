package java_hw_4.task2;

public class BankAccount {

    private String accountNumber;
    private String OwnerName;
    private double balance;

    public BankAccount(String accountNumber, String OwnerName, double balance) {
        this.accountNumber = accountNumber;
        this.OwnerName = OwnerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " to " + OwnerName);
        }
        else {
            System.out.println("The sum should be less than 0");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn " + amount + " from " + OwnerName);
            } else {
                System.out.println("There are insufficient funds in the account");
            }
        }
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountInfo() {
        return "Account Number: " + accountNumber + " Owner Name: " + OwnerName + " Balance: " + balance;
    }
}
