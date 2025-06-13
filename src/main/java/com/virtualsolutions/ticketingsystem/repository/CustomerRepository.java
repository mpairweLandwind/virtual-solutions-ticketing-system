package com.virtualsolutions.ticketingsystem.repository;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Customer;

/**
 * Repository interface for Customer entity operations.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public interface CustomerRepository {
    
    /**
     * Saves a customer to the repository.
     * 
     * @param customer The customer to save
     * @return The saved customer with generated ID
     */
    Customer save(Customer customer);
    
    /**
     * Updates an existing customer in the repository.
     * 
     * @param customer The customer to update
     * @return The updated customer
     */
    Customer update(Customer customer);
    
    /**
     * Finds a customer by their ID.
     * 
     * @param id The ID of the customer to find
     * @return An Optional containing the found customer or empty if not found
     */
    Optional<Customer> findById(Long id);
    
    /**
     * Finds all customers in the repository.
     * 
     * @return A list of all customers
     */
    List<Customer> findAll();
    
    /**
     * Deletes a customer from the repository.
     * 
     * @param id The ID of the customer to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean delete(Long id);
    
    /**
     * Finds customers by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of customers matching the name
     */
    List<Customer> findByName(String name);
    
    /**
     * Finds a customer by their email address.
     * 
     * @param email The email to search for
     * @return An Optional containing the found customer or empty if not found
     */
    Optional<Customer> findByEmail(String email);
    
    /**
     * Finds a customer by their phone number.
     * 
     * @param phone The phone number to search for
     * @return An Optional containing the found customer or empty if not found
     */
    Optional<Customer> findByPhone(String phone);
}
