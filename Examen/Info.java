public class Info {
    private int numberInfo;
    private Double money;

    Info() {
        numberInfo = (int) (Math.random() * 10000000);
        money = Math.random() * 10000;

    }

    int get_numberInfo() {
        return numberInfo;
    }

    Double balance() {
        return money;
    }

    void setMoney(Double x) {
        money += x;
    }
}