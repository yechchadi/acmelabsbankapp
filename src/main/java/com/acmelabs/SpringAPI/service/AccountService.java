package com.acmelabs.SpringAPI.service;

import com.acmelabs.SpringAPI.api.model.Account;
import com.acmelabs.SpringAPI.api.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private List<Account> accountList;

    @Autowired
    private TransactionService transactionService = new TransactionService();

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public AccountService() {
        accountList = new ArrayList<>();
        this.createAccount("4A55BT",4500);
        this.createAccount("4A55BT",0);
        this.createAccount("4A55BT", 6000);
        this.createAccount("6A85ZA", 0);


    }

    public Optional<Account> getAccount(String accountID){
        Optional optional = Optional.empty();
        for(Account account: accountList){
            if(accountID.equals(account.getAccountID())){
                optional = Optional.of(account);
                return optional;
            }
        }
        return optional;
    }
    //US6574 - Service layer method to create new account for existing customer using customerID & initialCredit, add to balance if initialCredit is not 0
    public Account createAccount(String customerID, Integer initialCredit){

        Account account = new Account(customerID,initialCredit);

        if(initialCredit!=0){
            int amount = initialCredit;
            transactionService.createTransaction(amount, account.getAccountID(), account);
        }
        accountList.add(account);
        return account;
    }
    public List<Account> getAccountsbyCustomer(String customerID_ext){
        List<Account> foundAccounts = new ArrayList<>();

        for(Account account: accountList){
            if(customerID_ext.equals(account.getCustomerID_ext())){
                foundAccounts.add(account);
            }
        }
        return foundAccounts;
    }
}
