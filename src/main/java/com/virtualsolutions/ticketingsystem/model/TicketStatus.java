package com.virtualsolutions.ticketingsystem.model;

/**
 * Enum representing the possible statuses of a ticket in the call center system.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public enum TicketStatus {
    /**
     * Ticket has been created but not yet assigned to an agent.
     */
    NEW,
    
    /**
     * Ticket has been assigned to an agent and is being worked on.
     */
    IN_PROGRESS,
    
    /**
     * Ticket is waiting for customer response or additional information.
     */
    PENDING,
    
    /**
     * Ticket has been resolved successfully.
     */
    RESOLVED,
    
    /**
     * Ticket has been closed without resolution or merged with another ticket.
     */
    CLOSED
}
