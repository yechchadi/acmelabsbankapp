package com.acmelabs.SpringAPI.api.model;

import com.acmelabs.SpringAPI.service.TransactionService;
import com.acmelabs.SpringAPI.util.UniqueId;

import java.util.List;

public class Account {


    private String accountID;
    private String customerID_ext;
    private int initialCredit;
    private int balance;
    private List<Transaction> transactions;

    public Account(String customerID_ext, int initialCredit) {
        this.accountID = UniqueId.generate(8);
        this.customerID_ext = customerID_ext;
        this.initialCredit = initialCredit;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        accountID = accountID;
    }

    public String getCustomerID_ext() {
        return customerID_ext;
    }

    public void setCustomerID_ext(String customerID_ext) {
        this.customerID_ext = customerID_ext;
    }

    public int getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(int initialCredit) {
        this.initialCredit = initialCredit;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
