package com.acmelabs.SpringAPI.api.model;

import com.acmelabs.SpringAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Customer {


    private String customerID;
    private String name;
    private String surname;
    private List<Account> accounts;


    public Customer(String customerID, String name, String surname) {
        this.customerID = customerID;
        this.name = name;
        this.surname = surname;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
