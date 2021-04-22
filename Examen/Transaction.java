import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

   public class Transaction {
    static private int count = 0;
    private int ID;
    static Lock lock = new ReentrantLock();
    Date date;
    private boolean result_transaction;
    private String nameAccountSender;
    private String nameAccountRecipient;
    private int senderBankAccNumber;
    private int recipientBankAccNumber;
    private Double transferAmount;
    private Double senderInitialBalanceValue;
    private Double recipientInitialBalanceValue;
    private Double senderSubsequentBalanceValue;
    private Double recipientSubsequentBalanceValue;
    Transaction(Account sender, Account recipient, Double amount) {
            nameAccountSender = sender.getName();
            nameAccountRecipient = recipient.getName();
            senderBankAccNumber = sender.getNumberBankAcc();
            recipientBankAccNumber = recipient.getNumberBankAcc();
            transferAmount = amount;
            lock.lock();
            if (sender.balanceAcc() >= amount) {
                senderInitialBalanceValue = sender.balanceAcc();
                sender.setInfo(-amount);
                senderSubsequentBalanceValue = sender.balanceAcc();
                recipientInitialBalanceValue = recipient.balanceAcc();
                recipient.setInfo(amount);
                recipientSubsequentBalanceValue = recipient.balanceAcc();
                ID = ++count;
                date = new Date();

                lock.unlock();
                result_transaction = true;
            }

             else {
                date = new Date();
                result_transaction = false;
            }


    }

    void printShortInformation() {
        if (result_transaction) {
            System.out.println(ID + " " + date + " " + nameAccountSender + " перевод " + transferAmount + " Рублей  " + nameAccountRecipient);
        } else {
            System.out.println("Транзакция № " + ID + " Недостаточно средств.");
        }
    }
    void printFullInformation() {
        System.out.println("Транзакция №: " + ID + "   |   " + date);
        System.out.println("Отрправитель: " + "№ " + senderBankAccNumber + " " + nameAccountSender);
        System.out.println("Получатель: " + "№ " + recipientBankAccNumber + " " + nameAccountRecipient);
        String str = String.format("%.2f", transferAmount);
        System.out.println("Сумма перевода: ₽" + str);
        if (result_transaction) {
            String str2 = String.format("%.2f", senderInitialBalanceValue);
            String str3 = String.format("%.2f", senderSubsequentBalanceValue);
            System.out.println("Начальная сумма на счёте: ₽" + str2 + "   Конечная сумма: ₽" + str3);
            String str4 = String.format("%.2f", recipientInitialBalanceValue);
            String str5 = String.format("%.2f", recipientSubsequentBalanceValue);
            System.out.println("Начальная сумма на счёте: ₽" + str4 + "   Конечная сумма: ₽" + str5);
        } else {
            System.out.println("Отказ в переводе. Недостаточно средств.");
        }
        System.out.println("______________________________________________");
    }

}