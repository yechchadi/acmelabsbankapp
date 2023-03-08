package com.acmelabs.SpringAPI.service;

import com.acmelabs.SpringAPI.api.model.Account;
import com.acmelabs.SpringAPI.api.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private List<Transaction> transactionList;


    public TransactionService() {
        transactionList = new ArrayList<>();


    }

    public Optional<Transaction> getTransaction(String transactionID){
        Optional optional = Optional.empty();
        for(Transaction transaction: transactionList){
            if(transactionID.equals(transaction.getTransactionID())){
                optional = Optional.of(transaction);
                return optional;
            }
        }
        return optional;
    }
    public Transaction createTransaction(Integer amount, String accountID_ext, Account account){
        Transaction transaction = new Transaction(amount, accountID_ext);
        account.setBalance(account.getBalance()+amount);
        transactionList.add(transaction);
        return transaction;
    }
    public List<Transaction> getTransactionsByAccount(String accountID_ext){
        List<Transaction> foundTransactions = new ArrayList<>();


        for(Transaction transaction: transactionList){
            if(accountID_ext.equals(transaction.getAccountID_ext())){
                foundTransactions.add(transaction);
            }
        }
        return foundTransactions;
    }


}
