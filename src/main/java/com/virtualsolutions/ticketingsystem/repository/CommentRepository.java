package com.virtualsolutions.ticketingsystem.repository;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Comment;

/**
 * Repository interface for Comment entity operations.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public interface CommentRepository {
    
    /**
     * Saves a comment to the repository.
     * 
     * @param comment The comment to save
     * @return The saved comment with generated ID
     */
    Comment save(Comment comment);
    
    /**
     * Updates an existing comment in the repository.
     * 
     * @param comment The comment to update
     * @return The updated comment
     */
    Comment update(Comment comment);
    
    /**
     * Finds a comment by its ID.
     * 
     * @param id The ID of the comment to find
     * @return An Optional containing the found comment or empty if not found
     */
    Optional<Comment> findById(Long id);
    
    /**
     * Finds all comments in the repository.
     * 
     * @return A list of all comments
     */
    List<Comment> findAll();
    
    /**
     * Deletes a comment from the repository.
     * 
     * @param id The ID of the comment to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean delete(Long id);
    
    /**
     * Finds all comments for a specific ticket.
     * 
     * @param ticketId The ID of the ticket
     * @return A list of comments for the specified ticket
     */
    List<Comment> findByTicketId(Long ticketId);
    
    /**
     * Finds all comments created by a specific agent.
     * 
     * @param agentId The ID of the agent
     * @return A list of comments created by the specified agent
     */
    List<Comment> findByAgentId(Long agentId);
}
