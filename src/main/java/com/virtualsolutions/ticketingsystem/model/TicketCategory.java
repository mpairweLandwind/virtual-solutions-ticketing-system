package com.virtualsolutions.ticketingsystem.model;

import java.io.Serializable;

/**
 * Represents a category for classifying tickets in the call center system.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public class TicketCategory implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String description;
    
    /**
     * Default constructor for TicketCategory.
     */
    public TicketCategory() {
    }
    
    /**
     * Parameterized constructor for TicketCategory.
     * 
     * @param id The unique identifier for the category
     * @param name The name of the category
     * @param description A brief description of the category
     */
    public TicketCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    /**
     * Gets the category's unique identifier.
     * 
     * @return The category's ID
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the category's unique identifier.
     * 
     * @param id The category's ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the category's name.
     * 
     * @return The category's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the category's name.
     * 
     * @param name The category's name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the category's description.
     * 
     * @return The category's description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the category's description.
     * 
     * @param description The category's description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "TicketCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}