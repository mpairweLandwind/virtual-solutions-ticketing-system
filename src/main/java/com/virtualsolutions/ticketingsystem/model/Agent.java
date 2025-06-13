package com.virtualsolutions.ticketingsystem.model;

import java.io.Serializable;

/**
 * Represents a call center agent who handles customer tickets.
 * 
 * @author  Mpairwe  Lauben
 * @version 1.0
 */
public class Agent implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private String department;
    
    /**
     * Default constructor for Agent.
     */
    public Agent() {
    }
    
    /**
     * Parameterized constructor for Agent.
     * 
     * @param id The unique identifier for the agent
     * @param name The full name of the agent
     * @param email The email address of the agent
     * @param employeeId The employee ID of the agent
     * @param department The department the agent belongs to
     */
    public Agent(Long id, String name, String email, String employeeId, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
        this.department = department;
    }
    
    /**
     * Gets the agent's unique identifier.
     * 
     * @return The agent's ID
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the agent's unique identifier.
     * 
     * @param id The agent's ID to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Gets the agent's full name.
     * 
     * @return The agent's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the agent's full name.
     * 
     * @param name The agent's name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Gets the agent's email address.
     * 
     * @return The agent's email
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Sets the agent's email address.
     * 
     * @param email The agent's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Gets the agent's employee ID.
     * 
     * @return The agent's employee ID
     */
    public String getEmployeeId() {
        return employeeId;
    }
    
    /**
     * Sets the agent's employee ID.
     * 
     * @param employeeId The agent's employee ID to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    /**
     * Gets the department the agent belongs to.
     * 
     * @return The agent's department
     */
    public String getDepartment() {
        return department;
    }
    
    /**
     * Sets the department the agent belongs to.
     * 
     * @param department The agent's department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
