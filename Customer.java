import java.util.*;

public class Customer {

    private String name;
    private long accno;
    private int pin;
    private float balance;

    public Customer(String name, long accno, int pin, float balance) {
        this.name = name;
        this.accno = accno;
        this.pin = pin;
        this.balance = balance;
    }

    public long getAccNo() {
        return this.accno;
    }

    public String getName() {
        return this.name;
    }

    public int getPin() {
        return this.pin;
    }

    public float getBalance() {
        return this.balance;
    }

    public void deposit(float amt) {
        this.balance += amt;
    }

    public void withdraw(float amt) {
        this.balance -= amt;
    }

}
