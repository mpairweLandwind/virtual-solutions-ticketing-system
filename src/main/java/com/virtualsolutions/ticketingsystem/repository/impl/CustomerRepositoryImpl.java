package com.virtualsolutions.ticketingsystem.repository.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.virtualsolutions.ticketingsystem.model.Customer;
import com.virtualsolutions.ticketingsystem.repository.CustomerRepository;

/**
 * In-memory implementation of the CustomerRepository interface.
 * This implementation uses a HashMap to store customers.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    
    private final Map<Long, Customer> customers = new HashMap<>();
    private Long nextId = 1L;
    
    @Override
    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(nextId++);
        }
        customers.put(customer.getId(), customer);
        return customer;
    }
    
    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == null || !customers.containsKey(customer.getId())) {
            throw new IllegalArgumentException("Cannot update non-existent customer");
        }
        customers.put(customer.getId(), customer);
        return customer;
    }
    
    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }
    
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
    
    @Override
    public boolean delete(Long id) {
        return customers.remove(id) != null;
    }
    
    @Override
    public List<Customer> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return new ArrayList<>();
        }
        
        String nameLower = name.toLowerCase();
        return customers.values().stream()
                .filter(customer -> customer.getName() != null && 
                        customer.getName().toLowerCase().contains(nameLower))
                .collect(Collectors.toList());
    }
    
    @Override
    public Optional<Customer> findByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return Optional.empty();
        }
        
        String emailLower = email.toLowerCase();
        return customers.values().stream()
                .filter(customer -> customer.getEmail() != null && 
                        customer.getEmail().toLowerCase().equals(emailLower))
                .findFirst();
    }
    
    @Override
    public Optional<Customer> findByPhone(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            return Optional.empty();
        }
        
        return customers.values().stream()
                .filter(customer -> customer.getPhone() != null && 
                        customer.getPhone().equals(phone))
                .findFirst();
    }
}