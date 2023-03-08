package com.acmelabs.SpringAPI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import com.acmelabs.SpringAPI.api.controller.CustomerController;
import com.acmelabs.SpringAPI.api.model.Account;
import com.acmelabs.SpringAPI.api.model.Customer;
import com.acmelabs.SpringAPI.api.model.Transaction;
import com.acmelabs.SpringAPI.service.AccountService;
import com.acmelabs.SpringAPI.service.CustomerService;
import com.acmelabs.SpringAPI.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @Mock
    private AccountService accountService;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void testGetCustomer() {
        // Create a mock customer
        String customerID = "123";
        Customer customer = new Customer(customerID, "John", "Doe");

        // Create a mock account and transaction
        String accountID = "456";
        Account account = new Account(customerID, 100);
        String transactionID = "789";
        Transaction transaction = new Transaction(50, accountID);

        // Configure mock service methods
        when(customerService.getCustomer(customerID)).thenReturn(customer);
        when(accountService.getAccountsbyCustomer(customerID)).thenReturn(Collections.singletonList(account));
        when(transactionService.getTransactionsByAccount(accountID)).thenReturn(Collections.singletonList(transaction));

        // Call the API endpoint
        Customer actualCustomer = customerController.getCustomer(customerID);

        // Verify the response
        assertNotNull(actualCustomer);
        assertEquals(customerID, actualCustomer.getCustomerID());
        assertEquals("John", actualCustomer.getName());
        assertEquals("Doe", actualCustomer.getSurname());
        List<Account> accounts = actualCustomer.getAccounts();
        assertEquals(1, accounts.size());
        Account actualAccount = accounts.get(0);
        assertNotNull(actualAccount);
        assertEquals(accountID, actualAccount.getAccountID());
        assertEquals(100, actualAccount.getInitialCredit());
        assertEquals(100, actualAccount.getBalance());
        List<Transaction> transactions = actualAccount.getTransactions();
        assertEquals(1, transactions.size());
        Transaction actualTransaction = transactions.get(0);
        assertNotNull(actualTransaction);
        assertEquals(transactionID, actualTransaction.getTransactionID());
        assertEquals(50, actualTransaction.getAmount());

    }
}

