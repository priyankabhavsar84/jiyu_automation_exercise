package account;

import java.util.ArrayList;
import java.util.List;


public class Account {
    private String accountNumber;
    private String accountName;
    static int balance;
    private static List<String> transactions;

    public Account(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 0 ;
        this.transactions = new ArrayList<>();
    }

    public static void deposit(String account, double amount) {
        transactions.add(account);
        balance += amount;
    }

    public void withdraw(String transactionId, double amount) {
        transactions.add(transactionId);
        balance -= amount;
    }

    public String generateStatement() {
        StringBuilder statement = new StringBuilder();
        statement.append("Name: ").append(accountName).append("\n");
        statement.append("Account: ").append(accountNumber).append("\n");
        statement.append("Balance: ").append(String.format("%.2f", balance)).append("\n");
        statement.append("Transactions: ").append("\n");
        for (String transaction : transactions) {
            statement.append(transaction).append("\n");
        }
        return statement.toString();
    }
}


