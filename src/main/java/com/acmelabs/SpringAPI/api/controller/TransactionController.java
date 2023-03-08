package com.acmelabs.SpringAPI.api.controller;


import com.acmelabs.SpringAPI.api.model.Account;
import com.acmelabs.SpringAPI.api.model.Transaction;
import com.acmelabs.SpringAPI.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {

    private TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @GetMapping("/transaction")
    public Transaction getTransaction(@RequestParam String transactionID){
        Optional transaction = transactionService.getTransaction(transactionID);
        if(transaction.isPresent()){
            return (Transaction) transaction.get();
        }
        return null;
    }

    @GetMapping("/transactions_by_account")
    public List<Transaction> getTransactionsByCustomer(@RequestParam String accountID_ext){
        List<Transaction> transactions = transactionService.getTransactionsByAccount(accountID_ext);
        if(transactions.isEmpty()){
            return null;
        }
        return transactions;
    }

}
