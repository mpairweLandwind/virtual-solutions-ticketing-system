package com.virtualsolutions.ticketingsystem.model;

import java.io.Serializable;

/**
 * Represents a customer in the call center ticket system.
 * Contains customer identification and contact information.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public class Customer implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    
    /**
     * Default constructor for Customer.
     */
    public Customer() {
    }
    
    /**
     * Parameterized constructor for Customer.
     * 
     * @param id The unique identifier for the customer
     * @param name The full name of the customer
     * @param email The email address of the customer
     * @param phone The phone number of the customer
     * @param address The physical address of the customer
     */
    public Customer(Long id, String name, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }
    
    /**
     * Gets the customer's unique identifier.
     * 
     * @return The customer's ID
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the customer's unique identifier.
     * 
     * @param id The customer's ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the customer's full name.
     * 
     * @return The customer's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the customer's full name.
     * 
     * @param name The customer's name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the customer's email address.
     * 
     * @return The customer's email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the customer's email address.
     * 
     * @param email The customer's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the customer's phone number.
     * 
     * @return The customer's phone number
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * Sets the customer's phone number.
     * 
     * @param phone The customer's phone number to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * Gets the customer's physical address.
     * 
     * @return The customer's address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Sets the customer's physical address.
     * 
     * @param address The customer's address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}