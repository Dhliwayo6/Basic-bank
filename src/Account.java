class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(String message) {
        // super keyword calls RuntimeException constructor
        super(message);
    }
}

public class Account {

    public double balance;
    public String accountId;

    // Constructor to initialize initial account balance
    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
    }

    // method to deposit money into accounts
    public void deposit(double amount) {

        // Throw an exception if deposit is negative
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit cannot be negative amount");
        }
        balance += amount;
    }

    //method to withdraw money from account
    public void withdraw(double amount) {

        // throw an exception if withdrawal amount is negative
        if (amount < 0) {
            throw new IllegalArgumentException("Withdrawal amount cannot be negative");
        }

        // throw custom InsufficientFundsException if withdrawal amount is greater than balance
        if ((balance - amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds!");
        }
        balance -= amount;
    }

    // getter method
    public double getBalance() {
        return this.balance;
    }


    //main method
    public static void main(String[] args) {

        Account account1 = new Account("ACC001");
//        Account account2 = new Account();
//        Account account3 = new Account();

        System.out.println("Initial balance: " + account1.getBalance() + " for account " + account1.accountId);

        account1.deposit(500);
//        account3.deposit(34);

        System.out.println("Current balance: " + account1.getBalance() + " for account " + account1.accountId);

        account1.withdraw(200);

        System.out.println("Remaining balance: " +  account1.getBalance() + " for account " + account1.accountId);
    }
}