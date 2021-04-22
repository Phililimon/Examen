public class Main {

    public static void main(String[] args) {

        Bank SberBank = new Bank("SberBank");
        Account profile_1 = new Account("Lev", "Morozov");
        Account profile_2 = new Account("Masha", "Marinina");
        Account profile_3 = new Account("Barry", "Allen");
        Threads thread_1 = new Threads();
        Threads thread_2 = new Threads();
        Threads thread_3 = new Threads();
        thread_1.setResources(SberBank, profile_1, profile_2, 123.0);
        thread_2.setResources(SberBank, profile_2, profile_3, 456.0);
        thread_3.setResources(SberBank, profile_3, profile_1, 142.0);
        thread_1.start();
        thread_2.start();
        thread_3.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SberBank.printTransactionList();
    }
}
