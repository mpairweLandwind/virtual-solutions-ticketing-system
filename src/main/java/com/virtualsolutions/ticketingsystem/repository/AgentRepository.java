package com.virtualsolutions.ticketingsystem.repository;

import java.util.List;
import java.util.Optional;

import com.virtualsolutions.ticketingsystem.model.Agent;

/**
 * Repository interface for Agent entity operations.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public interface AgentRepository {
    
    /**
     * Saves an agent to the repository.
     * 
     * @param agent The agent to save
     * @return The saved agent with generated ID
     */
    Agent save(Agent agent);
    
    /**
     * Updates an existing agent in the repository.
     * 
     * @param agent The agent to update
     * @return The updated agent
     */
    Agent update(Agent agent);
    
    /**
     * Finds an agent by their ID.
     * 
     * @param id The ID of the agent to find
     * @return An Optional containing the found agent or empty if not found
     */
    Optional<Agent> findById(Long id);
    
    /**
     * Finds all agents in the repository.
     * 
     * @return A list of all agents
     */
    List<Agent> findAll();
    
    /**
     * Deletes an agent from the repository.
     * 
     * @param id The ID of the agent to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean delete(Long id);
    
    /**
     * Finds agents by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of agents matching the name
     */
    List<Agent> findByName(String name);
    
    /**
     * Finds an agent by their email address.
     * 
     * @param email The email to search for
     * @return An Optional containing the found agent or empty if not found
     */
    Optional<Agent> findByEmail(String email);
    
    /**
     * Finds an agent by their employee ID.
     * 
     * @param employeeId The employee ID to search for
     * @return An Optional containing the found agent or empty if not found
     */
    Optional<Agent> findByEmployeeId(String employeeId);
    
    /**
     * Finds agents by their department.
     * 
     * @param department The department to search for
     * @return A list of agents in the specified department
     */
    List<Agent> findByDepartment(String department);
}
