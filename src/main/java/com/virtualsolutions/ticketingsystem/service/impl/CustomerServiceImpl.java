package com.virtualsolutions.ticketingsystem.service.impl;

import com.virtualsolutions.ticketingsystem.model.Customer;
import com.virtualsolutions.ticketingsystem.repository.CustomerRepository;
import com.virtualsolutions.ticketingsystem.service.CustomerService;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the CustomerService interface.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public class CustomerServiceImpl implements CustomerService {
    
    private final CustomerRepository customerRepository;
    
    /**
     * Constructor for CustomerServiceImpl.
     * 
     * @param customerRepository The repository for customer operations
     */
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    @Override
    public Customer createCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        
        // Validate customer data
        validateCustomer(customer);
        
        // Check if email is already in use
        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
            if (existingCustomer.isPresent()) {
                throw new IllegalArgumentException("Email is already in use");
            }
        }
        
        return customerRepository.save(customer);
    }
    
    @Override
    public Customer updateCustomer(Customer customer) {
        if (customer == null || customer.getId() == null) {
            throw new IllegalArgumentException("Customer and customer ID cannot be null");
        }
        
        // Check if customer exists
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());
        if (!existingCustomer.isPresent()) {
            throw new IllegalArgumentException("Customer not found with ID: " + customer.getId());
        }
        
        // Validate customer data
        validateCustomer(customer);
        
        // Check if email is already in use by another customer
        if (customer.getEmail() != null && !customer.getEmail().isEmpty()) {
            Optional<Customer> customerWithEmail = customerRepository.findByEmail(customer.getEmail());
            if (customerWithEmail.isPresent() && !customerWithEmail.get().getId().equals(customer.getId())) {
                throw new IllegalArgumentException("Email is already in use by another customer");
            }
        }
        
        return customerRepository.update(customer);
    }
    
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        return customerRepository.findById(id);
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @Override
    public boolean deleteCustomer(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        return customerRepository.delete(id);
    }
    
    @Override
    public List<Customer> searchCustomersByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        return customerRepository.findByName(name);
    }
    
    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return customerRepository.findByEmail(email);
    }
    
    @Override
    public Optional<Customer> getCustomerByPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be null or empty");
        }
        return customerRepository.findByPhone(phone);
    }
    
    /**
     * Validates customer data.
     * 
     * @param customer The customer to validate
     * @throws IllegalArgumentException if validation fails
     */
    private void validateCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        
        // Additional validation can be added here
    }
}
