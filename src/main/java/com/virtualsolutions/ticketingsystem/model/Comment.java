package com.virtualsolutions.ticketingsystem.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Represents a comment added to a ticket in the call center system.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public class Comment implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Agent createdBy;
    private Long ticketId;
    
    /**
     * Default constructor for Comment.
     */
    public Comment() {
    }
    
    /**
     * Parameterized constructor for Comment.
     * 
     * @param id The unique identifier for the comment
     * @param content The content of the comment
     * @param createdAt The date and time when the comment was created
     * @param createdBy The agent who created the comment
     * @param ticketId The ID of the ticket this comment belongs to
     */
    public Comment(Long id, String content, LocalDateTime createdAt, Agent createdBy, Long ticketId) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.ticketId = ticketId;
    }
    
    /**
     * Gets the comment's unique identifier.
     * 
     * @return The comment's ID
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the comment's unique identifier.
     * 
     * @param id The comment's ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the content of the comment.
     * 
     * @return The comment's content
     */
    public String getContent() {
        return content;
    }
    
    /**
     * Sets the content of the comment.
     * 
     * @param content The comment's content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    
    /**
     * Gets the date and time when the comment was created.
     * 
     * @return The comment's creation date and time
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    /**
     * Sets the date and time when the comment was created.
     * 
     * @param createdAt The comment's creation date and time to set
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    /**
     * Gets the agent who created the comment.
     * 
     * @return The agent who created the comment
     */
    public Agent getCreatedBy() {
        return createdBy;
    }
    
    /**
     * Sets the agent who created the comment.
     * 
     * @param createdBy The agent who created the comment to set
     */
    public void setCreatedBy(Agent createdBy) {
        this.createdBy = createdBy;
    }
    
    /**
     * Gets the ID of the ticket this comment belongs to.
     * 
     * @return The ticket ID
     */
    public Long getTicketId() {
        return ticketId;
    }
    
    /**
     * Sets the ID of the ticket this comment belongs to.
     * 
     * @param ticketId The ticket ID to set
     */
    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
    
    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", ticketId=" + ticketId +
                '}';
    }
}
