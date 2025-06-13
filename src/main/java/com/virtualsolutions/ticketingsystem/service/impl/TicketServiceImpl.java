package com.virtualsolutions.ticketingsystem.service.impl;

import com.virtualsolutions.ticketingsystem.model.Agent;
import com.virtualsolutions.ticketingsystem.model.Comment;
import com.virtualsolutions.ticketingsystem.model.Ticket;
import com.virtualsolutions.ticketingsystem.model.TicketPriority;
import com.virtualsolutions.ticketingsystem.model.TicketStatus;
import com.virtualsolutions.ticketingsystem.repository.AgentRepository;
import com.virtualsolutions.ticketingsystem.repository.TicketRepository;
import com.virtualsolutions.ticketingsystem.service.TicketService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the TicketService interface.
 * 
 * @author Pahappa Limited
 * @version 1.0
 */
public class TicketServiceImpl implements TicketService {
    
    private final TicketRepository ticketRepository;
    private final AgentRepository agentRepository;
    
    /**
     * Constructor for TicketServiceImpl.
     * 
     * @param ticketRepository The repository for ticket operations
     * @param agentRepository The repository for agent operations
     */
    public TicketServiceImpl(TicketRepository ticketRepository, AgentRepository agentRepository) {
        this.ticketRepository = ticketRepository;
        this.agentRepository = agentRepository;
    }
    
    @Override
    public Ticket createTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
        
        // Validate ticket data
        validateTicket(ticket);
        
        // Generate ticket number if not provided
        if (ticket.getTicketNumber() == null || ticket.getTicketNumber().isEmpty()) {
            ticket.setTicketNumber(generateTicketNumber());
        }
        
        // Set default values
        if (ticket.getStatus() == null) {
            ticket.setStatus(TicketStatus.NEW);
        }
        
        if (ticket.getPriority() == null) {
            ticket.setPriority(TicketPriority.MEDIUM);
        }
        
        if (ticket.getCreatedAt() == null) {
            ticket.setCreatedAt(LocalDateTime.now());
        }
        
        return ticketRepository.save(ticket);
    }
    
    @Override
    public Ticket updateTicket(Ticket ticket) {
        if (ticket == null || ticket.getId() == null) {
            throw new IllegalArgumentException("Ticket and ticket ID cannot be null");
        }
        
        // Check if ticket exists
        Optional<Ticket> existingTicket = ticketRepository.findById(ticket.getId());
        if (!existingTicket.isPresent()) {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticket.getId());
        }
        
        // Validate ticket data
        validateTicket(ticket);
        
        // Update timestamp
        ticket.setUpdatedAt(LocalDateTime.now());
        
        return ticketRepository.update(ticket);
    }
    
    @Override
    public Optional<Ticket> getTicketById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Ticket ID cannot be null");
        }
        return ticketRepository.findById(id);
    }
    
    @Override
    public Optional<Ticket> getTicketByNumber(String ticketNumber) {
        if (ticketNumber == null || ticketNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket number cannot be null or empty");
        }
        return ticketRepository.findByTicketNumber(ticketNumber);
    }
    
    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    
    @Override
    public boolean deleteTicket(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Ticket ID cannot be null");
        }
        return ticketRepository.delete(id);
    }
    
    @Override
    public List<Ticket> getTicketsByStatus(TicketStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        return ticketRepository.findByStatus(status);
    }
    
    @Override
    public List<Ticket> getTicketsByPriority(TicketPriority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("Priority cannot be null");
        }
        return ticketRepository.findByPriority(priority);
    }
    
    @Override
    public List<Ticket> getTicketsByAgentId(Long agentId) {
        if (agentId == null) {
            throw new IllegalArgumentException("Agent ID cannot be null");
        }
        return ticketRepository.findByAssignedAgentId(agentId);
    }
    
    @Override
    public List<Ticket> getTicketsByCustomerId(Long customerId) {
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        return ticketRepository.findByCustomerId(customerId);
    }
    
    @Override
    public List<Ticket> getTicketsByCategoryId(Long categoryId) {
        if (categoryId == null) {
            throw new IllegalArgumentException("Category ID cannot be null");
        }
        return ticketRepository.findByCategoryId(categoryId);
    }
    
    @Override
    public List<Ticket> getTicketsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        return ticketRepository.findByCreatedAtBetween(startDate, endDate);
    }
    
    @Override
    public Ticket assignTicket(Long ticketId, Long agentId) {
        if (ticketId == null || agentId == null) {
            throw new IllegalArgumentException("Ticket ID and Agent ID cannot be null");
        }
        
        // Check if ticket exists
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
        if (!ticketOpt.isPresent()) {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
        }
        
        // Check if agent exists
        Optional<Agent> agentOpt = agentRepository.findById(agentId);
        if (!agentOpt.isPresent()) {
            throw new IllegalArgumentException("Agent not found with ID: " + agentId);
        }
        
        Ticket ticket = ticketOpt.get();
        ticket.setAssignedAgent(agentOpt.get());
        ticket.setUpdatedAt(LocalDateTime.now());
        
        // Update status to IN_PROGRESS if it's NEW
        if (ticket.getStatus() == TicketStatus.NEW) {
            ticket.setStatus(TicketStatus.IN_PROGRESS);
        }
        
        return ticketRepository.update(ticket);
    }
    
    @Override
    public Ticket updateTicketStatus(Long ticketId, TicketStatus status) {
        if (ticketId == null || status == null) {
            throw new IllegalArgumentException("Ticket ID and status cannot be null");
        }
        
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
        if (!ticketOpt.isPresent()) {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
        }
        
        Ticket ticket = ticketOpt.get();
        ticket.setStatus(status);
        
        return ticketRepository.update(ticket);
    }
    
    @Override
    public Ticket updateTicketPriority(Long ticketId, TicketPriority priority) {
        if (ticketId == null || priority == null) {
            throw new IllegalArgumentException("Ticket ID and priority cannot be null");
        }
        
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
        if (!ticketOpt.isPresent()) {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
        }
        
        Ticket ticket = ticketOpt.get();
        ticket.setPriority(priority);
        
        return ticketRepository.update(ticket);
    }
    
    @Override
    public Ticket addComment(Long ticketId, Comment comment) {
        if (ticketId == null || comment == null) {
            throw new IllegalArgumentException("Ticket ID and comment cannot be null");
        }
        
        Optional<Ticket> ticketOpt = ticketRepository.findById(ticketId);
        if (!ticketOpt.isPresent()) {
            throw new IllegalArgumentException("Ticket not found with ID: " + ticketId);
        }
        
        Ticket ticket = ticketOpt.get();
        comment.setTicketId(ticketId);
        comment.setCreatedAt(LocalDateTime.now());
        ticket.addComment(comment);
        
        return ticketRepository.update(ticket);
    }
    
    @Override
    public List<Ticket> searchTickets(String keyword, TicketStatus status, TicketPriority priority, 
                                     Long categoryId, Long agentId, Long customerId) {
        return ticketRepository.search(keyword, status, priority, categoryId, agentId, customerId);
    }
    
    /**
     * Validates ticket data.
     * 
     * @param ticket The ticket to validate
     * @throws IllegalArgumentException if validation fails
     */
    private void validateTicket(Ticket ticket) {
        if (ticket.getTitle() == null || ticket.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket title cannot be null or empty");
        }
        
        if (ticket.getDescription() == null || ticket.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket description cannot be null or empty");
        }
        
        if (ticket.getCustomer() == null) {
            throw new IllegalArgumentException("Ticket must have a customer");
        }
        
        if (ticket.getCategory() == null) {
            throw new IllegalArgumentException("Ticket must have a category");
        }
    }
    
    /**
     * Generates a unique ticket number.
     * 
     * @return A unique ticket number
     */
    private String generateTicketNumber() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TKT-" + timestamp;
    }
}
