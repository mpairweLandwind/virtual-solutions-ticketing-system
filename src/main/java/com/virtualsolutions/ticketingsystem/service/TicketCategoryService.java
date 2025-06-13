package com.virtualsolutions.ticketingsystem.service;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.TicketCategory;

/**
 * Service interface for TicketCategory-related operations.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public interface TicketCategoryService {
    
    /**
     * Creates a new ticket category.
     * 
     * @param category The ticket category to create
     * @return The created ticket category with generated ID
     */
    TicketCategory createCategory(TicketCategory category);
    
    /**
     * Updates an existing ticket category.
     * 
     * @param category The ticket category to update
     * @return The updated ticket category
     * @throws IllegalArgumentException if the category does not exist
     */
    TicketCategory updateCategory(TicketCategory category);
    
    /**
     * Gets a ticket category by its ID.
     * 
     * @param id The ID of the ticket category to get
     * @return An Optional containing the found ticket category or empty if not found
     */
    Optional<TicketCategory> getCategoryById(Long id);
    
    /**
     * Gets all ticket categories.
     * 
     * @return A list of all ticket categories
     */
    List<TicketCategory> getAllCategories();
    
    /**
     * Deletes a ticket category by its ID.
     * 
     * @param id The ID of the ticket category to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteCategory(Long id);
    
    /**
     * Searches for ticket categories by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of ticket categories matching the name
     */
    List<TicketCategory> searchCategoriesByName(String name);
}
