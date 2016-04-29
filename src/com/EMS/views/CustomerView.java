/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Customer;
import com.EMS.service.CustomerService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CustomerView extends View {
    
    protected CustomerService customerService;
    protected Scanner scanner;
    
    Customer customer = new Customer();
    
    public CustomerView() {
        
    }
    
    public CustomerView(CustomerService customerService, Scanner scanner) {
        this.customerService = customerService;
        this.scanner = scanner;
        
    }
    
    @Override
    public void insert() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter customer first name \n");
            customer.setFirstName(scanner.next());
            System.out.println("Enter customer last name \n");
            customer.setLastName(scanner.next());
            System.out.println("Enter customer address \n");
            customer.setAddress(scanner.next());
            customerService.insert(customer);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
            
        }
    }
    
    @Override
    public void delete() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter customer id to delete \n");
            customerService.delete(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    
    @Override
    public void search() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter the customer name \n");
            customerService.search(scanner.next());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    
    @Override
    public void searchById() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter the customer id to search \n");
            customerService.getById(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
    
    @Override
    public void update() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter the id of the customer to update the information ");
            int id = scanner.nextInt();
            System.out.println("Enter the new address");
            String address = scanner.nextLine();
            customer.setAddress(address);
            System.out.println("Enter the new first name");
            String firstName = scanner.next();
            customer.setFirstName(firstName);
            System.out.println("Enter the new last name");
            String lastName = scanner.next();
            customer.setLastName(lastName);
            customerService.update(customer);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
        
    }
    
    @Override
    public void loadData() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Enter the file name to load data from");
        String fileName = scanner.next();
        customerService.load(fileName);
        System.out.println("Data loading successfull");
        
    }
    
    @Override
    public void exportData() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Enter the file name to export the data to ");
        String fileName = scanner.next();
        StringBuilder builder = new StringBuilder();
        customerService.getAll().forEach(c -> {
            builder.append(c.toCsv());
        });
        customerService.export(fileName,builder.toString());
    }
    
    @Override
    public void viewAll() throws ClassNotFoundException, SQLException {
        System.out.println("View all customers \n");
        customerService.getAll().forEach(c -> {
            System.out.println(c.toString());
        });
    }
}
