package com.virtualsolutions.ticketingsystem.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Ticket;
import com.virtualsolutions.ticketingsystem.model.TicketPriority;
import com.virtualsolutions.ticketingsystem.model.TicketStatus;

/**
 * Repository interface for Ticket entity operations.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public interface TicketRepository {
    
    /**
     * Saves a ticket to the repository.
     * 
     * @param ticket The ticket to save
     * @return The saved ticket with generated ID
     */
    Ticket save(Ticket ticket);
    
    /**
     * Updates an existing ticket in the repository.
     * 
     * @param ticket The ticket to update
     * @return The updated ticket
     */
    Ticket update(Ticket ticket);
    
    /**
     * Finds a ticket by its ID.
     * 
     * @param id The ID of the ticket to find
     * @return An Optional containing the found ticket or empty if not found
     */
    Optional<Ticket> findById(Long id);
    
    /**
     * Finds a ticket by its ticket number.
     * 
     * @param ticketNumber The ticket number to search for
     * @return An Optional containing the found ticket or empty if not found
     */
    Optional<Ticket> findByTicketNumber(String ticketNumber);
    
    /**
     * Finds all tickets in the repository.
     * 
     * @return A list of all tickets
     */
    List<Ticket> findAll();
    
    /**
     * Deletes a ticket from the repository.
     * 
     * @param id The ID of the ticket to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean delete(Long id);
    
    /**
     * Finds tickets by their status.
     * 
     * @param status The status to search for
     * @return A list of tickets with the specified status
     */
    List<Ticket> findByStatus(TicketStatus status);
    
    /**
     * Finds tickets by their priority.
     * 
     * @param priority The priority to search for
     * @return A list of tickets with the specified priority
     */
    List<Ticket> findByPriority(TicketPriority priority);
    
    /**
     * Finds tickets assigned to a specific agent.
     * 
     * @param agentId The ID of the agent
     * @return A list of tickets assigned to the specified agent
     */
    List<Ticket> findByAssignedAgentId(Long agentId);
    
    /**
     * Finds tickets created by a specific customer.
     * 
     * @param customerId The ID of the customer
     * @return A list of tickets created by the specified customer
     */
    List<Ticket> findByCustomerId(Long customerId);
    
    /**
     * Finds tickets in a specific category.
     * 
     * @param categoryId The ID of the category
     * @return A list of tickets in the specified category
     */
    List<Ticket> findByCategoryId(Long categoryId);
    
    /**
     * Finds tickets created within a date range.
     * 
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A list of tickets created within the specified date range
     */
    List<Ticket> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Searches for tickets based on various criteria.
     * 
     * @param keyword The keyword to search for in title and description
     * @param status The status to filter by (optional)
     * @param priority The priority to filter by (optional)
     * @param categoryId The category ID to filter by (optional)
     * @param agentId The agent ID to filter by (optional)
     * @param customerId The customer ID to filter by (optional)
     * @return A list of tickets matching the search criteria
     */
    List<Ticket> search(String keyword, TicketStatus status, TicketPriority priority, 
                        Long categoryId, Long agentId, Long customerId);
}
