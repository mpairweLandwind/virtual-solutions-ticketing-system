package com.virtualsolutions.ticketingsystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a ticket in the call center system.
 * This is the core entity that tracks customer issues and their resolution.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public class Ticket implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String ticketNumber;
    private String title;
    private String description;
    private Customer customer;
    private Agent assignedAgent;
    private TicketCategory category;
    private TicketStatus status;
    private TicketPriority priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime resolvedAt;
    private List<Comment> comments;
    
    /**
     * Default constructor for Ticket.
     */
    public Ticket() {
        this.comments = new ArrayList<>();
        this.status = TicketStatus.NEW;
        this.priority = TicketPriority.MEDIUM;
        this.createdAt = LocalDateTime.now();
    }
    
    /**
     * Parameterized constructor for Ticket.
     * 
     * @param id The unique identifier for the ticket
     * @param ticketNumber The ticket number (usually a formatted string)
     * @param title The title of the ticket
     * @param description A detailed description of the issue
     * @param customer The customer who reported the issue
     * @param category The category of the ticket
     */
    public Ticket(Long id, String ticketNumber, String title, String description, Customer customer, TicketCategory category) {
        this();
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.title = title;
        this.description = description;
        this.customer = customer;
        this.category = category;
    }
    
    /**
     * Gets the ticket's unique identifier.
     * 
     * @return The ticket's ID
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the ticket's unique identifier.
     * 
     * @param id The ticket's ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the ticket number.
     * 
     * @return The ticket number
     */
    public String getTicketNumber() {
        return ticketNumber;
    }
    
    /**
     * Sets the ticket number.
     * 
     * @param ticketNumber The ticket number to set
     */
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    /**
     * Gets the title of the ticket.
     * 
     * @return The ticket's title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Sets the title of the ticket.
     * 
     * @param title The ticket's title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Gets the detailed description of the issue.
     * 
     * @return The ticket's description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Sets the detailed description of the issue.
     * 
     * @param description The ticket's description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Gets the customer who reported the issue.
     * 
     * @return The customer
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Sets the customer who reported the issue.
     * 
     * @param customer The customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    /**
     * Gets the agent assigned to the ticket.
     * 
     * @return The assigned agent
     */
    public Agent getAssignedAgent() {
        return assignedAgent;
    }
    
    /**
     * Sets the agent assigned to the ticket.
     * 
     * @param assignedAgent The agent to assign
     */
    public void setAssignedAgent(Agent assignedAgent) {
        this.assignedAgent = assignedAgent;
    }
    
    /**
     * Gets the category of the ticket.
     * 
     * @return The ticket's category
     */
    public TicketCategory getCategory() {
        return category;
    }
    
    /**
     * Sets the category of the ticket.
     * 
     * @param category The ticket's category to set
     */
    public void setCategory(TicketCategory category) {
        this.category = category;
    }
    
    /**
     * Gets the current status of the ticket.
     * 
     * @return The ticket's status
     */
    public TicketStatus getStatus() {
        return status;
    }
    
    /**
     * Sets the status of the ticket.
     * 
     * @param status The ticket's status to set
     */
    public void setStatus(TicketStatus status) {
        this.status = status;
        if (status == TicketStatus.RESOLVED && this.resolvedAt == null) {
            this.resolvedAt = LocalDateTime.now();
        }
        this.updatedAt = LocalDateTime.now();
    }
    
    /**
     * Gets the priority level of the ticket.
     * 
     * @return The ticket's priority
     */
    public TicketPriority getPriority() {
        return priority;
    }
    
    /**
     * Sets the priority level of the ticket.
     * 
     * @param priority The ticket's priority to set
     */
    public void setPriority(TicketPriority priority) {
        this.priority = priority;
        this.updatedAt = LocalDateTime.now();
    }
    
    /**
     * Gets the date and time when the ticket was created.
     * 
     * @return The ticket's creation date and time
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Sets the date and time when the ticket was created.
     * 
     * @param createdAt The ticket's creation date and time to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the date and time when the ticket was last updated.
     * 
     * @return The ticket's last update date and time
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    /**
     * Sets the date and time when the ticket was last updated.
     * 
     * @param updatedAt The ticket's last update date and time to set
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    
    /**
     * Gets the date and time when the ticket was resolved.
     * 
     * @return The ticket's resolution date and time
     */
    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }
    
    /**
     * Sets the date and time when the ticket was resolved.
     * 
     * @param resolvedAt The ticket's resolution date and time to set
     */
    public void setResolvedAt(LocalDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
    
    /**
     * Gets the list of comments associated with the ticket.
     * 
     * @return The list of comments
     */
    public List<Comment> getComments() {
        return comments;
    }
    
    /**
     * Sets the list of comments associated with the ticket.
     * 
     * @param comments The list of comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    /**
     * Adds a comment to the ticket.
     * 
     * @param comment The comment to add
     */
    public void addComment(Comment comment) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(comment);
        this.updatedAt = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", customer=" + customer +
                ", assignedAgent=" + assignedAgent +
                ", category=" + category +
                ", status=" + status +
                ", priority=" + priority +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", resolvedAt=" + resolvedAt +
                ", comments=" + comments +
                '}';
    }
}
