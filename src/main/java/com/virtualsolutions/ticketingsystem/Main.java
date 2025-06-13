package com.virtualsolutions.ticketingsystem;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.virtualsolutions.ticketingsystem.controller.CustomerController;
import com.virtualsolutions.ticketingsystem.model.Customer;
import com.virtualsolutions.ticketingsystem.repository.impl.CustomerRepositoryImpl;
import com.virtualsolutions.ticketingsystem.service.impl.CustomerServiceImpl;

/**
 * Main application class for the Call Center Ticket System.
 * This class provides a console-based interface for managing tickets, customers, and agents.
 * 
 * @author Mpairwe Lauben
 * @version 1.0
 */
public class  Main {
    
    private final CustomerController customerController;
    private final Scanner scanner;
    
    /**
     * Constructor forMain.
     * Initializes the controllers and scanner for user input.
     */
    public Main() {
        // Initialize repositories
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        
        // Initialize services
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerRepository);
        
        // Initialize controllers
        this.customerController = new CustomerController(customerService);
        this.scanner = new Scanner(System.in);
        
        // Initialize sample data
        initializeSampleData();
    }
    
    /**
     * Main method to start the application.
     * 
     * @param args Command line arguments
     */
    public static void main(String[] args) {
       Main app = new Main();
        app.run();
    }
    
    /**
     * Runs the main application loop.
     * Displays the menu and handles user input.
     */
    public void run() {
        System.out.println("=== Virtual Solutions Call Center Ticket System ===");
        System.out.println("Welcome to the Call Center Management System!");
        
        while (true) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1 -> manageCustomers();
                case 2 -> manageTickets();
                case 3 -> searchTickets();
                case 4 -> displayReports();
                case 0 -> {
                    System.out.println("Thank you for using the Call Center Ticket System!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Displays the main menu options.
     */
    private void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage Tickets");
        System.out.println("3. Search Tickets");
        System.out.println("4. View Reports");
        System.out.println("0. Exit");
        System.out.println("==================");
    }
    
    /**
     * Handles customer management operations.
     */
    private void manageCustomers() {
        while (true) {
            System.out.println("\n=== Customer Management ===");
            System.out.println("1. Create Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Search Customer by Name");
            System.out.println("4. Find Customer by Email");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("0. Back to Main Menu");
            
            int choice = getIntInput("Enter your choice: ");
            
            switch (choice) {
                case 1 -> createCustomer();
                case 2 -> viewAllCustomers();
                case 3 -> searchCustomerByName();
                case 4 -> findCustomerByEmail();
                case 5 -> updateCustomer();
                case 6 -> deleteCustomer();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    /**
     * Creates a new customer.
     */
    private void createCustomer() {
        System.out.println("\n=== Create Customer ===");
        
        String name = getStringInput("Enter customer name: ");
        String email = getStringInput("Enter customer email: ");
        String phone = getStringInput("Enter customer phone: ");
        String address = getStringInput("Enter customer address: ");
        
        Customer customer = new Customer(null, name, email, phone, address);
        
        try {
            Customer createdCustomer = customerController.createCustomer(customer);
            System.out.println("Customer created successfully!");
            System.out.println("Customer ID: " + createdCustomer.getId());
            System.out.println("Customer Details: " + createdCustomer);
        } catch (Exception e) {
            System.out.println("Error creating customer: " + e.getMessage());
        }
    }
    
    /**
     * Displays all customers.
     */
    private void viewAllCustomers() {
        System.out.println("\n=== All Customers ===");
        
        try {
            List<Customer> customers = customerController.getAllCustomers();
            
            if (customers.isEmpty()) {
                System.out.println("No customers found.");
            } else {
                System.out.printf("%-5s %-20s %-25s %-15s %-30s%n", 
                    "ID", "Name", "Email", "Phone", "Address");
                System.out.println("=".repeat(95));
                
                for (Customer customer : customers) {
                    System.out.printf("%-5d %-20s %-25s %-15s %-30s%n",
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhone(),
                        customer.getAddress());
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving customers: " + e.getMessage());
        }
    }
    
    /**
     * Searches for customers by name.
     */
    private void searchCustomerByName() {
        System.out.println("\n=== Search Customer by Name ===");
        
        String name = getStringInput("Enter customer name to search: ");
        
        try {
            List<Customer> customers = customerController.searchCustomersByName(name);
            
            if (customers.isEmpty()) {
                System.out.println("No customers found with name containing: " + name);
            } else {
                System.out.println("Found " + customers.size() + " customer(s):");
                for (Customer customer : customers) {
                    System.out.println(customer);
                }
            }
        } catch (Exception e) {
            System.out.println("Error searching customers: " + e.getMessage());
        }
    }
    
    /**
     * Finds a customer by email.
     */
    private void findCustomerByEmail() {
        System.out.println("\n=== Find Customer by Email ===");
        
        String email = getStringInput("Enter customer email: ");
        
        try {
            Optional<Customer> customerOpt = customerController.getCustomerByEmail(email);
            
            if (customerOpt.isPresent()) {
                System.out.println("Customer found:");
                System.out.println(customerOpt.get());
            } else {
                System.out.println("No customer found with email: " + email);
            }
        } catch (Exception e) {
            System.out.println("Error finding customer: " + e.getMessage());
        }
    }
    
    /**
     * Updates an existing customer.
     */
    private void updateCustomer() {
        System.out.println("\n=== Update Customer ===");
        
        Long id = getLongInput("Enter customer ID to update: ");
        
        try {
            Optional<Customer> customerOpt = customerController.getCustomerById(id);
            
            if (!customerOpt.isPresent()) {
                System.out.println("Customer not found with ID: " + id);
                return;
            }
            
            Customer customer = customerOpt.get();
            System.out.println("Current customer details:");
            System.out.println(customer);
            
            System.out.println("\nEnter new details (press Enter to keep current value):");
            
            String name = getStringInputWithDefault("Name [" + customer.getName() + "]: ", customer.getName());
            String email = getStringInputWithDefault("Email [" + customer.getEmail() + "]: ", customer.getEmail());
            String phone = getStringInputWithDefault("Phone [" + customer.getPhone() + "]: ", customer.getPhone());
            String address = getStringInputWithDefault("Address [" + customer.getAddress() + "]: ", customer.getAddress());
            
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);
            customer.setAddress(address);
            
            Customer updatedCustomer = customerController.updateCustomer(customer);
            System.out.println("Customer updated successfully!");
            System.out.println("Updated details: " + updatedCustomer);
            
        } catch (Exception e) {
            System.out.println("Error updating customer: " + e.getMessage());
        }
    }
    
    /**
     * Deletes a customer.
     */
    private void deleteCustomer() {
        System.out.println("\n=== Delete Customer ===");
        
        Long id = getLongInput("Enter customer ID to delete: ");
        
        try {
            Optional<Customer> customerOpt = customerController.getCustomerById(id);
            
            if (!customerOpt.isPresent()) {
                System.out.println("Customer not found with ID: " + id);
                return;
            }
            
            System.out.println("Customer to delete:");
            System.out.println(customerOpt.get());
            
            String confirmation = getStringInput("Are you sure you want to delete this customer? (yes/no): ");
            
            if ("yes".equalsIgnoreCase(confirmation)) {
                boolean deleted = customerController.deleteCustomer(id);
                if (deleted) {
                    System.out.println("Customer deleted successfully!");
                } else {
                    System.out.println("Failed to delete customer.");
                }
            } else {
                System.out.println("Delete operation cancelled.");
            }
            
        } catch (Exception e) {
            System.out.println("Error deleting customer: " + e.getMessage());
        }
    }
    
    /**
     * Handles ticket management operations.
     */
    private void manageTickets() {
        System.out.println("\n=== Ticket Management ===");
        System.out.println("Ticket management functionality will be implemented here.");
        System.out.println("This would include creating, viewing, updating, and deleting tickets.");
    }
    
    /**
     * Handles ticket search operations.
     */
    private void searchTickets() {
        System.out.println("\n=== Search Tickets ===");
        System.out.println("Ticket search functionality will be implemented here.");
        System.out.println("This would include searching by various criteria like status, priority, customer, etc.");
    }
    
    /**
     * Displays system reports.
     */
    private void displayReports() {
        System.out.println("\n=== System Reports ===");
        System.out.println("Reporting functionality will be implemented here.");
        System.out.println("This would include ticket statistics, agent performance, etc.");
    }
    
    /**
     * Initializes sample data for testing purposes.
     */
    private void initializeSampleData() {
        try {
            // Create sample customers
            Customer customer1 = new Customer(null, "John Doe", "john.doe@email.com", "+256701234567", "Kampala, Uganda");
            Customer customer2 = new Customer(null, "Jane Smith", "jane.smith@email.com", "+256702345678", "Entebbe, Uganda");
            Customer customer3 = new Customer(null, "Bob Johnson", "bob.johnson@email.com", "+256703456789", "Jinja, Uganda");
            
            customerController.createCustomer(customer1);
            customerController.createCustomer(customer2);
            customerController.createCustomer(customer3);
            
            System.out.println("Sample data initialized successfully.");
            
        } catch (Exception e) {
            System.out.println("Warning: Failed to initialize sample data: " + e.getMessage());
        }
    }
    
    /**
     * Gets string input from the user.
     * 
     * @param prompt The prompt to display
     * @return The user's input
     */
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    /**
     * Gets string input with a default value.
     * 
     * @param prompt The prompt to display
     * @param defaultValue The default value if input is empty
     * @return The user's input or default value
     */
    private String getStringInputWithDefault(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        return input.isEmpty() ? defaultValue : input;
    }
    
    /**
     * Gets integer input from the user.
     * 
     * @param prompt The prompt to display
     * @return The user's input as an integer
     */
    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    /**
     * Gets long input from the user.
     * 
     * @param prompt The prompt to display
     * @return The user's input as a long
     */
    private Long getLongInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Long.valueOf(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
