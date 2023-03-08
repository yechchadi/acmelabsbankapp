package com.acmelabs.SpringAPI.service;

import com.acmelabs.SpringAPI.api.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {
    private List<Customer> customerList;


    public CustomerService() {
        customerList = new ArrayList<>();
        Customer customer1 = new Customer("4A55BT","Alan","Turing");
        Customer customer2 = new Customer("6A85ZA","Ada","Lovelace");
        Customer customer3 = new Customer("8B59EA","John","Neumann");

        customerList.addAll(Arrays.asList(customer1,customer2,customer3));

    }

    public Customer getCustomer(String customerID){

        for(Customer customer: customerList){
            if(customerID.equals(customer.getCustomerID())){

                return customer;
            }
        }
        return null;
    }

}
