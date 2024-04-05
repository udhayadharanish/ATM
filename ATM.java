import java.util.*;

class ATM {
    public static void main(String[] args) {
        List<Bank> banks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        Bank bank = new Bank();
        do {
            // System.out.println("1. Add Bank");
            System.out.println("1 . Balance Enquiry");
            System.out.println("2 . Add Customer");
            System.out.println("3 . Withdraw Money");
            System.out.println("4 . Deposit Money");
            System.out.println("5 . View Customers ");
            System.out.println("6 . Show Transactions");
            System.out.println("7 . Exit");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Enter Acc No : ");
                    long accNo = sc.nextLong();
                    boolean flag = false;
                    List<Customer> customers = bank.showCustomers();
                    for (int i = 0; i < customers.size(); i++) {
                        Customer temp = customers.get(i);

                        if (temp.getAccNo() == accNo) {
                            System.out.println("Hi " + temp.getName());
                            flag = true;
                            System.out.println("Pin : ");
                            int pin = sc.nextInt();
                            if (pin == temp.getPin()) {
                                System.out.println("Your Available balance is " + temp.getBalance());
                            } else {
                                System.out.println("Incorrect Pin");
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        System.out
                                .println("No User Found for this Account Number. please enter valid account number : ");
                    }
                    break;

                case 2:

                    System.out.println("Admin permission required");
                    System.out.print("Username : ");
                    String name = sc.next();
                    sc.nextLine();
                    System.out.print("Password : ");
                    String pass = sc.nextLine();

                    if (name.equals("udhay") && pass.equals("udhay123")) {
                        System.out.println(bank.showCustomers());
                        System.out.println("Enter Customer name : ");
                        String Customername = sc.next();
                        System.out.println("Account Number : ");
                        accNo = sc.nextLong();
                        System.out.println("Pin : ");
                        int pin = sc.nextInt();
                        System.out.println("Balance : ");
                        float balance = sc.nextFloat();
                        Customer cus = new Customer(Customername, accNo, pin, balance);
                        bank.addCustomer(cus);
                    } else {
                        System.out.println("Invalid credentials");
                    }
                    break;
                case 3:
                    System.out.println("Enter Acc No : ");
                    accNo = sc.nextLong();
                    flag = false;
                    customers = bank.showCustomers();
                    for (int i = 0; i < customers.size(); i++) {
                        Customer temp = customers.get(i);

                        if (temp.getAccNo() == accNo) {
                            System.out.println("Hi " + temp.getName());
                            flag = true;
                            System.out.println("Pin : ");
                            int pin = sc.nextInt();
                            if (pin == temp.getPin()) {
                                System.out.println("Enter amount to withdraw : ");
                                float amt = sc.nextFloat();
                                if (temp.getBalance() - amt < 0) {
                                    System.out.println("Insufficient balance !");
                                    System.out.println("Your available balance is " + temp.getBalance());
                                    break;
                                } else {
                                    System.out.println("Processing...");
                                    temp.withdraw(amt);
                                    bank.addTransaction(temp.getName() + " withdrawed " + amt);
                                    System.out.println("Please collect the money !");
                                    break;
                                }
                            } else {
                                System.out.println("Incorrect Pin");
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        System.out
                                .println("No User Found for this Account Number. please enter valid account number : ");
                    }
                    break;
                case 4:
                    System.out.println("Enter Acc No : ");
                    accNo = sc.nextLong();
                    flag = false;
                    customers = bank.showCustomers();
                    for (int i = 0; i < customers.size(); i++) {
                        Customer temp = customers.get(i);

                        if (temp.getAccNo() == accNo) {
                            System.out.println("Hi " + temp.getName());
                            flag = true;
                            System.out.println("Pin : ");
                            int pin = sc.nextInt();
                            if (pin == temp.getPin()) {
                                System.out.println("Enter amount to deposit : ");
                                float amt = sc.nextFloat();
                                temp.deposit(amt);
                                bank.addTransaction(temp.getName() + " deposited " + amt);
                                System.out.println("Your balance has been added !");
                            } else {
                                System.out.println("Incorrect Pin");
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        System.out
                                .println("No User Found for this Account Number. please enter valid account number : ");
                    }
                    break;
                case 5:
                    System.out.println("Admin permission required");
                    System.out.print("Username : ");
                    name = sc.next();
                    sc.nextLine();
                    System.out.print("Password : ");
                    pass = sc.nextLine();
                    if (name.equals("udhay") && pass.equals("udhay123")) {
                        List<Customer> customersList = bank.showCustomers();
                        for (int i = 0; i < customersList.size(); i++) {

                            System.out.println(customersList.get(i).getName());
                        }
                    } else {
                        System.out.println("Invalid credentials !");
                    }
                    break;
                case 6:
                    System.out.println("Admin permission required");
                    System.out.print("Username : ");
                    name = sc.next();
                    sc.nextLine();
                    System.out.print("Password : ");
                    pass = sc.nextLine();
                    if (name.equals("udhay") && pass.equals("udhay123")) {
                        List<String> transactionList = bank.showTransaction();
                        // System.out.println(transactionList);
                        for (int i = 0; i < transactionList.size(); i++) {

                            System.out.println(transactionList.get(i));
                        }
                    } else {
                        System.out.println("Invalid credentials !");
                    }
                    break;
                default:
                    break;
            }
        } while (op != 7);
    }
}
