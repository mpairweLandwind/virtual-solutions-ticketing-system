package com.virtualsolutions.ticketingsystem.controller;
import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Customer;
import com.virtualsolutions.ticketingsystem.service.CustomerService;

/**
 * Controller class for handling customer-related operations.
 * This class provides methods for creating, reading, updating, and deleting customers.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public class CustomerController {
    
    private final CustomerService customerService;
    
    /**
     * Constructor for CustomerController.
     * 
     * @param customerService The service for customer operations
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    /**
     * Creates a new customer.
     * 
     * @param customer The customer to create
     * @return The created customer with generated ID
     * @throws RuntimeException if the customer creation fails
     */
    public Customer createCustomer(Customer customer) {
        try {
            return customerService.createCustomer(customer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create customer: " + e.getMessage(), e);
        }
    }
    
    /**
     * Updates an existing customer.
     * 
     * @param customer The customer to update
     * @return The updated customer
     * @throws RuntimeException if the customer update fails
     */
    public Customer updateCustomer(Customer customer) {
        try {
            return customerService.updateCustomer(customer);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update customer: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets a customer by their ID.
     * 
     * @param id The ID of the customer to get
     * @return An Optional containing the found customer or empty if not found
     * @throws RuntimeException if the operation fails
     */
    public Optional<Customer> getCustomerById(Long id) {
        try {
            return customerService.getCustomerById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get customer by ID: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets all customers.
     * 
     * @return A list of all customers
     * @throws RuntimeException if the operation fails
     */
    public List<Customer> getAllCustomers() {
        try {
            return customerService.getAllCustomers();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all customers: " + e.getMessage(), e);
        }
    }
    
    /**
     * Deletes a customer by their ID.
     * 
     * @param id The ID of the customer to delete
     * @return true if deleted successfully, false otherwise
     * @throws RuntimeException if the operation fails
     */
    public boolean deleteCustomer(Long id) {
        try {
            return customerService.deleteCustomer(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete customer: " + e.getMessage(), e);
        }
    }
    
    /**
     * Searches for customers by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of customers matching the name
     * @throws RuntimeException if the operation fails
     */
    public List<Customer> searchCustomersByName(String name) {
        try {
            return customerService.searchCustomersByName(name);
        } catch (Exception e) {
            throw new RuntimeException("Failed to search customers by name: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets a customer by their email address.
     * 
     * @param email The email to search for
     * @return An Optional containing the found customer or empty if not found
     * @throws RuntimeException if the operation fails
     */
    public Optional<Customer> getCustomerByEmail(String email) {
        try {
            return customerService.getCustomerByEmail(email);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get customer by email: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets a customer by their phone number.
     * 
     * @param phone The phone number to search for
     * @return An Optional containing the found customer or empty if not found
     * @throws RuntimeException if the operation fails
     */
    public Optional<Customer> getCustomerByPhone(String phone) {
        try {
            return customerService.getCustomerByPhone(phone);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get customer by phone: " + e.getMessage(), e);
        }
    }
}
