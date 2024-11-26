package Task2;
class Printer {
    private int pagesInTray;

    public Printer(int initialPages) {
        this.pagesInTray = initialPages;
    }

    public synchronized void addPages(int pages) {
        System.out.println("Adding " + pages + " pages to the tray.");
        pagesInTray += pages;
        System.out.println("Total pages in tray: " + pagesInTray);
        notify();
    }

    public synchronized void printPages(int pages) {
        System.out.println("Print job requested for " + pages + " pages.");
        while (pages > pagesInTray) {
            System.out.println("Not enough pages in the tray. Waiting for more pages...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Print thread interrupted.");
            }
        }
        pagesInTray -= pages;
        System.out.println("Printed " + pages + " pages. Remaining pages in tray: " + pagesInTray);
    }
}

