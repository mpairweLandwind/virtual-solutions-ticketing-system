package com.virtualsolutions.ticketingsystem.service;

import com.virtualsolutions.ticketingsystem.model.Agent;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for Agent-related operations.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public interface AgentService {
    
    /**
     * Creates a new agent.
     * 
     * @param agent The agent to create
     * @return The created agent with generated ID
     */
    Agent createAgent(Agent agent);
    
    /**
     * Updates an existing agent.
     * 
     * @param agent The agent to update
     * @return The updated agent
     * @throws IllegalArgumentException if the agent does not exist
     */
    Agent updateAgent(Agent agent);
    
    /**
     * Gets an agent by their ID.
     * 
     * @param id The ID of the agent to get
     * @return An Optional containing the found agent or empty if not found
     */
    Optional<Agent> getAgentById(Long id);
    
    /**
     * Gets all agents.
     * 
     * @return A list of all agents
     */
    List<Agent> getAllAgents();
    
    /**
     * Deletes an agent by their ID.
     * 
     * @param id The ID of the agent to delete
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteAgent(Long id);
    
    /**
     * Searches for agents by their name (partial match).
     * 
     * @param name The name to search for
     * @return A list of agents matching the name
     */
    List<Agent> searchAgentsByName(String name);
    
    /**
     * Gets an agent by their email address.
     * 
     * @param email The email to search for
     * @return An Optional containing the found agent or empty if not found
     */
    Optional<Agent> getAgentByEmail(String email);
    
    /**
     * Gets an agent by their employee ID.
     * 
     * @param employeeId The employee ID to search for
     * @return An Optional containing the found agent or empty if not found
     */
    Optional<Agent> getAgentByEmployeeId(String employeeId);
    
    /**
     * Gets agents by their department.
     * 
     * @param department The department to search for
     * @return A list of agents in the specified department
     */
    List<Agent> getAgentsByDepartment(String department);
}