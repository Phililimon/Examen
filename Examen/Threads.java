class Threads extends Thread {
    private Bank bank;
    private Account sender;
    private Account recipient;
    Double amount;
    public void run() {
        bank.makeTransaction(sender, recipient, amount);
    }
    public void setResources(Bank newBank, Account newSender, Account newRecipient, Double newAmount) {
        bank = newBank;
        sender = newSender;
        recipient = newRecipient;
        amount = newAmount;
    }
}