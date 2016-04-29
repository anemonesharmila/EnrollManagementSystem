/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Enquiry;
import com.EMS.service.EnquiryService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class EnquiryView extends View {

    protected EnquiryService enquiryService;
    protected Scanner scanner;
    Enquiry enquiry = new Enquiry();

    public EnquiryView() {
    }

    public EnquiryView(EnquiryService enquiryService, Scanner scanner) {
        this.enquiryService = enquiryService;
        this.scanner = scanner;
    }

    @Override
    public void insert() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter the type of enquiry \n");
            enquiry.setEnquiryType(scanner.next());
            enquiryService.insert(enquiry);
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
            System.out.println("Enter enquiry id to delete \n");
            enquiryService.delete(scanner.nextInt());
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
            System.out.println("Enter the enquiry name \n");
            enquiryService.search(scanner.next());
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
            System.out.println("Enter the enquiry id to search \n");
            enquiryService.getById(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void viewAll() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("View all enquiries \n");

            enquiryService.getAll().forEach(e -> {
                System.out.println(e.toString());
            });
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
            Enquiry enquiry=new Enquiry();
            System.out.println("Enter the id of which to update the enquiry type");
            int id = scanner.nextInt();
            enquiry.setEnquiryId(id);
            System.out.println("Enter the new enquiry type");
            String enquiryType = scanner.next();
            enquiry.setEnquiryType(enquiryType);
            
            enquiryService.update(enquiry);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void loadData() throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            System.out.println("Enter the file name to load the data from");
            String fileName = scanner.next();
            enquiryService.load(fileName);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    @Override
    public void exportData() throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            System.out.println("Enter the file name to export the data to");
            String fileName = scanner.next();
            StringBuilder builder = new StringBuilder();
            enquiryService.getAll().forEach(e -> {
                builder.append(e.toCSV());
            });
            enquiryService.export(fileName, builder.toString());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

}
