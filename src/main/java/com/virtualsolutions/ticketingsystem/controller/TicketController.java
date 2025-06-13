package com.virtualsolutions.ticketingsystem.controller;

import com.virtualsolutions.ticketingsystem.model.Comment;
import com.virtualsolutions.ticketingsystem.model.Ticket;
import com.virtualsolutions.ticketingsystem.model.TicketPriority;
import com.virtualsolutions.ticketingsystem.model.TicketStatus;
import com.virtualsolutions.ticketingsystem.service.TicketService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling ticket-related operations.
 * This class provides methods for creating, reading, updating, and deleting tickets.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public class TicketController {
    
    private final TicketService ticketService;
    
    /**
     * Constructor for TicketController.
     * 
     * @param ticketService The service for ticket operations
     */
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    
    /**
     * Creates a new ticket.
     * 
     * @param ticket The ticket to create
     * @return The created ticket with generated ID and ticket number
     * @throws IllegalArgumentException if the ticket data is invalid
     */
    public Ticket createTicket(Ticket ticket) {
        try {
            return ticketService.createTicket(ticket);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ticket: " + e.getMessage(), e);
        }
    }
    
    /**
     * Updates an existing ticket.
     * 
     * @param ticket The ticket to update
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist or data is invalid
     */
    public Ticket updateTicket(Ticket ticket) {
        try {
            return ticketService.updateTicket(ticket);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update ticket: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets a ticket by its ID.
     * 
     * @param id The ID of the ticket to get
     * @return An Optional containing the found ticket or empty if not found
     * @throws IllegalArgumentException if the ID is null
     */
    public Optional<Ticket> getTicketById(Long id) {
        try {
            return ticketService.getTicketById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get ticket by ID: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets a ticket by its ticket number.
     * 
     * @param ticketNumber The ticket number to search for
     * @return An Optional containing the found ticket or empty if not found
     * @throws IllegalArgumentException if the ticket number is null or empty
     */
    public Optional<Ticket> getTicketByNumber(String ticketNumber) {
        try {
            return ticketService.getTicketByNumber(ticketNumber);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get ticket by number: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets all tickets.
     * 
     * @return A list of all tickets
     */
    public List<Ticket> getAllTickets() {
        try {
            return ticketService.getAllTickets();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get all tickets: " + e.getMessage(), e);
        }
    }
    
    /**
     * Deletes a ticket by its ID.
     * 
     * @param id The ID of the ticket to delete
     * @return true if deleted successfully, false otherwise
     * @throws IllegalArgumentException if the ID is null
     */
    public boolean deleteTicket(Long id) {
        try {
            return ticketService.deleteTicket(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete ticket: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets tickets by their status.
     * 
     * @param status The status to search for
     * @return A list of tickets with the specified status
     * @throws IllegalArgumentException if the status is null
     */
    public List<Ticket> getTicketsByStatus(TicketStatus status) {
        try {
            return ticketService.getTicketsByStatus(status);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get tickets by status: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets tickets by their priority.
     * 
     * @param priority The priority to search for
     * @return A list of tickets with the specified priority
     * @throws IllegalArgumentException if the priority is null
     */
    public List<Ticket> getTicketsByPriority(TicketPriority priority) {
        try {
            return ticketService.getTicketsByPriority(priority);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get tickets by priority: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets tickets assigned to a specific agent.
     * 
     * @param agentId The ID of the agent
     * @return A list of tickets assigned to the specified agent
     * @throws IllegalArgumentException if the agent ID is null
     */
    public List<Ticket> getTicketsByAgentId(Long agentId) {
        try {
            return ticketService.getTicketsByAgentId(agentId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get tickets by agent ID: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets tickets created by a specific customer.
     * 
     * @param customerId The ID of the customer
     * @return A list of tickets created by the specified customer
     * @throws IllegalArgumentException if the customer ID is null
     */
    public List<Ticket> getTicketsByCustomerId(Long customerId) {
        try {
            return ticketService.getTicketsByCustomerId(customerId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get tickets by customer ID: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets tickets in a specific category.
     * 
     * @param categoryId The ID of the category
     * @return A list of tickets in the specified category
     * @throws IllegalArgumentException if the category ID is null
     */
    public List<Ticket> getTicketsByCategoryId(Long categoryId) {
        try {
            return ticketService.getTicketsByCategoryId(categoryId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get tickets by category ID: " + e.getMessage(), e);
        }
    }
    
    /**
     * Gets tickets created within a date range.
     * 
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A list of tickets created within the specified date range
     * @throws IllegalArgumentException if the dates are null or invalid
     */
    public List<Ticket> getTicketsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        try {
            return ticketService.getTicketsByDateRange(startDate, endDate);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get tickets by date range: " + e.getMessage(), e);
        }
    }
    
    /**
     * Assigns a ticket to an agent.
     * 
     * @param ticketId The ID of the ticket to assign
     * @param agentId The ID of the agent to assign the ticket to
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket or agent does not exist
     */
    public Ticket assignTicket(Long ticketId, Long agentId) {
        try {
            return ticketService.assignTicket(ticketId, agentId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to assign ticket: " + e.getMessage(), e);
        }
    }
    
    /**
     * Updates the status of a ticket.
     * 
     * @param ticketId The ID of the ticket to update
     * @param status The new status to set
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    public Ticket updateTicketStatus(Long ticketId, TicketStatus status) {
        try {
            return ticketService.updateTicketStatus(ticketId, status);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update ticket status: " + e.getMessage(), e);
        }
    }
    
    /**
     * Updates the priority of a ticket.
     * 
     * @param ticketId The ID of the ticket to update
     * @param priority The new priority to set
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    public Ticket updateTicketPriority(Long ticketId, TicketPriority priority) {
        try {
            return ticketService.updateTicketPriority(ticketId, priority);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update ticket priority: " + e.getMessage(), e);
        }
    }
    
    /**
     * Adds a comment to a ticket.
     * 
     * @param ticketId The ID of the ticket to add the comment to
     * @param comment The comment to add
     * @return The updated ticket
     * @throws IllegalArgumentException if the ticket does not exist
     */
    public Ticket addComment(Long ticketId, Comment comment) {
        try {
            return ticketService.addComment(ticketId, comment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add comment to ticket: " + e.getMessage(), e);
        }
    }
    
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
    public List<Ticket> searchTickets(String keyword, TicketStatus status, TicketPriority priority, 
                                     Long categoryId, Long agentId, Long customerId) {
        try {
            return ticketService.searchTickets(keyword, status, priority, categoryId, agentId, customerId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to search tickets: " + e.getMessage(), e);
        }
    }
}
