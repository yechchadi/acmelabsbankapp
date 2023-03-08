package com.acmelabs.SpringAPI.api.controller;


import com.acmelabs.SpringAPI.api.model.Account;
import com.acmelabs.SpringAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    @GetMapping("/account")
    public Account getAccount(@RequestParam String accountID){
        Optional account = accountService.getAccount(accountID);
        if(account.isPresent()){
            return (Account) account.get();
        }
        return null;
    }

    @GetMapping("/accounts_by_customer")
    public List<Account> getAccountsbyCustomer(@RequestParam String customerID_ext){
        List<Account> accounts = accountService.getAccountsbyCustomer(customerID_ext);
        if(accounts.isEmpty()){
            return null;
        }
        return accounts;
    }

    //US6574 - API endpoint to create new account for existing customer using customerID & initialCredit
    @PostMapping("/account/create")
    public Account createAccount(@RequestParam String customerID, @RequestParam Integer initialCredit){
        return accountService.createAccount(customerID,initialCredit);
    }
}
