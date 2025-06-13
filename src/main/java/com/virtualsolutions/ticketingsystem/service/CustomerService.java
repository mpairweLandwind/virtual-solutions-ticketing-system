package com.virtualsolutions.ticketingsystem.service;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Customer;

/**
 * Service interface for Customer-related operations.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public interface CustomerService {
    
    /**
     * Creates a new customer.
     * 
     * @param customer The customer to create
     * @return The created customer with generated ID
     */
    Customer createCustomer(Customer customer);
    
    /**
     * Updates an existing customer.
     * 
     * @param customer The customer to update
     * @return The updated customer
     * @throws IllegalArgumentException if the customer does not exist
     */
    Customer updateCustomer(Customer customer);
    
    /**
     * Gets a customer by their ID.
     * 
     * @param id The ID of the customer to get
     * @return An Optional containing the found customer or empty if not found
     */
    Optional<Customer> getCustomerById(Long id);
    
    /**
     * Gets all customers.
     * 
     * @return A list of all customers
     */
    List<Customer> getAllCustomers();
    
    /**
     * Deletes a customer by their ID.
     * 
     * @param id The ID of the customer to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteCustomer(Long id);
    
    /**
     * Searches for customers by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of customers matching the name
     */
    List<Customer> searchCustomersByName(String name);
    
    /**
     * Gets a customer by their email address.
     * 
     * @param email The email to search for
     * @return An Optional containing the found customer or empty if not found
     */
    Optional<Customer> getCustomerByEmail(String email);
    
    /**
     * Gets a customer by their phone number.
     * 
     * @param phone The phone number to search for
     * @return An Optional containing the found customer or empty if not found
     */
    Optional<Customer> getCustomerByPhone(String phone);
}
