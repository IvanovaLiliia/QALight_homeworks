package java_hw_4.task2;

public class Main {
    public static void main(String[] args) {

        BankAccount ClientAccount = new BankAccount("NB34568808", "Liliia", 5000 );

        System.out.println(ClientAccount.getAccountInfo());

        ClientAccount.deposit(1000);
        ClientAccount.withdraw(3000);
        ClientAccount.withdraw(6000);
        ClientAccount.deposit(-7);

        System.out.println(ClientAccount.getAccountInfo());
    }
}
