public class Account {

    public int limit;
    public double balance;

    public Account() {
        this.limit = 1000;
        this.balance = 0.0;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if ((balance - amount) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative!");
            
        }
        balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }


    public static void main(String[] args) {

        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        System.out.println("Initial balance: " + account1.getBalance());

        account1.deposit(500);
        account3.deposit(34);

        System.out.println("Current balance: " + account1.getBalance());

        account1.withdraw(237.0);

        System.out.println("Remaining balance: " + account1.getBalance());


    }
}