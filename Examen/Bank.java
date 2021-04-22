import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<Transaction> transactionsList = new ArrayList();

    Bank(String newBankName) {
        bankName = newBankName;
    }

    public void pushBackTransaction(Transaction x) {
        transactionsList.add(x);
    }

    public void printTransactionList() {
        for (int i = 0; i < transactionsList.size(); ++i) {
            transactionsList.get(i).printFullInformation();
        }
    }

    public void makeTransaction(Account sender, Account recipient, Double amount) {
        for (int i = 0; i < 4; ++i) {
            Transaction x = new Transaction(sender, recipient, amount);
            pushBackTransaction(x);
        }
    }
}