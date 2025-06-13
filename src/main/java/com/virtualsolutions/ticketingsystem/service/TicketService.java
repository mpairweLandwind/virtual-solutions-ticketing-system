package com.virtualsolutions.ticketingsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Comment;
import com.virtualsolutions.ticketingsystem.model.Ticket;
import com.virtualsolutions.ticketingsystem.model.TicketPriority;
import com.virtualsolutions.ticketingsystem.model.TicketStatus;

/**
 * Service interface for Ticket-related operations.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public interface TicketService {
    
    /**
     * Creates a new ticket.
     * 
     * @param ticket The ticket to create
     * @return The created ticket with generated ID and ticket number
     */
    Ticket createTicket(Ticket ticket);
    
    /**
     * Updates an existing ticket.
     * 
     * @param ticket The ticket to update
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    Ticket updateTicket(Ticket ticket);
    
    /**
     * Gets a ticket by its ID.
     * 
     * @param id The ID of the ticket to get
     * @return An Optional containing the found ticket or empty if not found
     */
    Optional<Ticket> getTicketById(Long id);
    
    /**
     * Gets a ticket by its ticket number.
     * 
     * @param ticketNumber The ticket number to search for
     * @return An Optional containing the found ticket or empty if not found
     */
    Optional<Ticket> getTicketByNumber(String ticketNumber);
    
    /**
     * Gets all tickets.
     * 
     * @return A list of all tickets
     */
    List<Ticket> getAllTickets();
    
    /**
     * Deletes a ticket by its ID.
     * 
     * @param id The ID of the ticket to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteTicket(Long id);
    
    /**
     * Gets tickets by their status.
     * 
     * @param status The status to search for
     * @return A list of tickets with the specified status
     */
    List<Ticket> getTicketsByStatus(TicketStatus status);
    
    /**
     * Gets tickets by their priority.
     * 
     * @param priority The priority to search for
     * @return A list of tickets with the specified priority
     */
    List<Ticket> getTicketsByPriority(TicketPriority priority);
    
    /**
     * Gets tickets assigned to a specific agent.
     * 
     * @param agentId The ID of the agent
     * @return A list of tickets assigned to the specified agent
     */
    List<Ticket> getTicketsByAgentId(Long agentId);
    
    /**
     * Gets tickets created by a specific customer.
     * 
     * @param customerId The ID of the customer
     * @return A list of tickets created by the specified customer
     */
    List<Ticket> getTicketsByCustomerId(Long customerId);
    
    /**
     * Gets tickets in a specific category.
     * 
     * @param categoryId The ID of the category
     * @return A list of tickets in the specified category
     */
    List<Ticket> getTicketsByCategoryId(Long categoryId);
    
    /**
     * Gets tickets created within a date range.
     * 
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A list of tickets created within the specified date range
     */
    List<Ticket> getTicketsByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    /**
     * Assigns a ticket to an agent.
     * 
     * @param ticketId The ID of the ticket to assign
     * @param agentId The ID of the agent to assign the ticket to
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket or agent does not exist
     */
    Ticket assignTicket(Long ticketId, Long agentId);
    
    /**
     * Updates the status of a ticket.
     * 
     * @param ticketId The ID of the ticket to update
     * @param status The new status to set
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    Ticket updateTicketStatus(Long ticketId, TicketStatus status);
    
    /**
     * Updates the priority of a ticket.
     * 
     * @param ticketId The ID of the ticket to update
     * @param priority The new priority to set
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    Ticket updateTicketPriority(Long ticketId, TicketPriority priority);
    
    /**
     * Adds a comment to a ticket.
     * 
     * @param ticketId The ID of the ticket to add the comment to
     * @param comment The comment to add
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    Ticket addComment(Long ticketId, Comment comment);
    
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
    List<Ticket> searchTickets(String keyword, TicketStatus status, TicketPriority priority, 
                              Long categoryId, Long agentId, Long customerId);
}
