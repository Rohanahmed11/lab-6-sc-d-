package Task2;
public class PrinterJob {
    public static void main(String[] args) {
        Printer printer = new Printer(10);

        Thread printThread = new Thread(() -> {
            printer.printPages(15);
        });

        Thread addPagesThread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                printer.addPages(10);
            } catch (InterruptedException e) {
                System.out.println("Add pages thread interrupted.");
            }
        });

        printThread.start();
        addPagesThread.start();

        try {
            printThread.join();
            addPagesThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("All printer jobs completed.");
    }
}
