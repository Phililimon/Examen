public class Account {
    private String FirstName;
    private String LastName;
    private Info selfInfo;
    Account(String userFirstName, String userLastName) {
        FirstName = userFirstName;
        LastName = userLastName;
        selfInfo = new Info();
    }
    String getName() {
        return (FirstName + " " + LastName);
    }
    int getNumberBankAcc() {
        return selfInfo.get_numberInfo();
    }
    Double balanceAcc() {
        return selfInfo.balance();
    }
    void setInfo(Double x) {
        selfInfo.setMoney(x);
    }

}