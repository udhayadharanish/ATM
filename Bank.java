import java.util.*;

public class Bank {
    private List<Customer> customers = new ArrayList();
    private List<String> transactions = new ArrayList();

    public void addCustomer(Customer cus) {
        this.customers.add(cus);
    }

    public List<Customer> showCustomers() {
        return this.customers;
    }

    public void addTransaction(String transaction) {
        this.transactions.add(transaction);
    }

    public List<String> showTransaction() {
        return this.transactions;
    }

}
