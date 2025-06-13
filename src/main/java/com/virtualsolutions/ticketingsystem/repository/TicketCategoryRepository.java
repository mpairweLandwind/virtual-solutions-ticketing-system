package com.virtualsolutions.ticketingsystem.repository;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.TicketCategory;

/**
 * Repository interface for TicketCategory entity operations.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public interface TicketCategoryRepository {
    
    /**
     * Saves a ticket category to the repository.
     * 
     * @param category The ticket category to save
     * @return The saved ticket category with generated ID
     */
    TicketCategory save(TicketCategory category);
    
    /**
     * Updates an existing ticket category in the repository.
     * 
     * @param category The ticket category to update
     * @return The updated ticket category
     */
    TicketCategory update(TicketCategory category);
    
    /**
     * Finds a ticket category by its ID.
     * 
     * @param id The ID of the ticket category to find
     * @return An Optional containing the found ticket category or empty if not found
     */
    Optional<TicketCategory> findById(Long id);
    
    /**
     * Finds all ticket categories in the repository.
     * 
     * @return A list of all ticket categories
     */
    List<TicketCategory> findAll();
    
    /**
     * Deletes a ticket category from the repository.
     * 
     * @param id The ID of the ticket category to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean delete(Long id);
    
    /**
     * Finds ticket categories by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of ticket categories matching the name
     */
    List<TicketCategory> findByName(String name);
}
