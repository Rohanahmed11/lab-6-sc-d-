package Task1;
public class JointAccountExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(50000);

        Thread userA = new Thread(() -> account.withdraw(45000, "User A"));
        Thread userB = new Thread(() -> account.withdraw(20000, "User B"));

        userA.start();
        userB.start();

        try {
            userA.join();
            userB.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Final balance in the account: " + account.getBalance());
    }
}
