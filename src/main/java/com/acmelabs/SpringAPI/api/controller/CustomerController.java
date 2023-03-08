package com.acmelabs.SpringAPI.api.controller;

import com.acmelabs.SpringAPI.api.model.Account;
import com.acmelabs.SpringAPI.api.model.Customer;
import com.acmelabs.SpringAPI.api.model.Transaction;
import com.acmelabs.SpringAPI.service.AccountService;
import com.acmelabs.SpringAPI.service.CustomerService;
import com.acmelabs.SpringAPI.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    private CustomerService customerService;
    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    //US6523 - API endpoint to get customer information with accounts and transactions
    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam String customerID){
        Customer customer = customerService.getCustomer(customerID);
        if(customer!=null){
            List<Account> accounts = accountService.getAccountsbyCustomer(customerID);

            for (Account account : accounts){
                List<Transaction> transactions = transactionService.getTransactionsByAccount(account.getAccountID());
                account.setTransactions(transactions);
            }

            customer.setAccounts(accounts);
            return customer;

        }
        throw new RuntimeException("Customer Not Found");


    }

}
