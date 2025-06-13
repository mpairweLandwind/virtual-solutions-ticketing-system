package com.virtualsolutions.ticketingsystem.service;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Comment;

/**
 * Service interface for Comment-related operations.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public interface CommentService {
    
    /**
     * Creates a new comment.
     * 
     * @param comment The comment to create
     * @return The created comment with generated ID
     */
    Comment createComment(Comment comment);
    
    /**
     * Updates an existing comment.
     * 
     * @param comment The comment to update
     * @return The updated comment
     * @throws IllegalArgumentException if the comment does not exist
     */
    Comment updateComment(Comment comment);
    
    /**
     * Gets a comment by its ID.
     * 
     * @param id The ID of the comment to get
     * @return An Optional containing the found comment or empty if not found
     */
    Optional<Comment> getCommentById(Long id);
    
    /**
     * Gets all comments.
     * 
     * @return A list of all comments
     */
    List<Comment> getAllComments();
    
    /**
     * Deletes a comment by its ID.
     * 
     * @param id The ID of the comment to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteComment(Long id);
    
    /**
     * Gets all comments for a specific ticket.
     * 
     * @param ticketId The ID of the ticket
     * @return A list of comments for the specified ticket
     */
    List<Comment> getCommentsByTicketId(Long ticketId);
    
    /**
     * Gets all comments created by a specific agent.
     * 
     * @param agentId The ID of the agent
     * @return A list of comments created by the specified agent
     */
    List<Comment> getCommentsByAgentId(Long agentId);
}
