package Task1;
class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(int amount, String user) {
        if (balance >= amount) {
            System.out.println(user + " is withdrawing " + amount);
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
            balance -= amount;
            System.out.println(user + " has withdrawn " + amount + ". New balance: " + balance);
        } else {
            System.out.println(user + " tried to withdraw " + amount + ", but insufficient funds. Current balance: " + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

