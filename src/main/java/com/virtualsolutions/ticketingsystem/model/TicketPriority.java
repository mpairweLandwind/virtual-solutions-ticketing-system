package com.virtualsolutions.ticketingsystem.model;

/**
 * Enum representing the priority levels for tickets in the call center system.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public enum TicketPriority {
    /**
     * Low priority ticket - can be addressed when time permits.
     */
    LOW,
    
    /**
     * Medium priority ticket - should be addressed in a reasonable timeframe.
     */
    MEDIUM,
    
    /**
     * High priority ticket - requires prompt attention.
     */
    HIGH,
    
    /**
     * Critical priority ticket - requires immediate attention.
     */
    CRITICAL
}
