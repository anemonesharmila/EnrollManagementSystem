/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Facilitator;
import com.EMS.service.FacilitatorService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class FacilitatorView extends View {

    protected FacilitatorService facilitatorService;
    protected Scanner scanner;
    Facilitator facilitator = new Facilitator();

    public FacilitatorView() {
    }

    public FacilitatorView(FacilitatorService facilitatorService, Scanner scanner) {
        this.facilitatorService = facilitatorService;
        this.scanner = scanner;
    }

    @Override
    public void insert() throws ClassNotFoundException,SQLException{
        while (true) {
            System.out.println("Enter facilitator id \n");
            facilitator.setFacilitatorId(scanner.nextInt());
            System.out.println("Enter facilitator  name \n");
            facilitator.setName(scanner.next());
            System.out.println("Enter facilitator salary \n");
            facilitator.setSalary(scanner.nextDouble());
//        System.out.println("Enter enquiry date \n");
//        enquiry.setEnquiryDate();

            facilitatorService.insert(facilitator);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void delete() throws ClassNotFoundException,SQLException{
        while (true) {
            System.out.println("Enter enrollment id to delete \n");
            facilitatorService.delete(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    @Override
    public void search()throws ClassNotFoundException,SQLException {

        while (true) {
            System.out.println("Enter the facilitator type \n");
            facilitatorService.search(scanner.nextLine());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void searchById() throws ClassNotFoundException,SQLException{
        while (true) {
            System.out.println("Enter the facilitator id to search \n");
            facilitatorService.getById(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    @Override
    public void viewAll()throws ClassNotFoundException,SQLException {
        System.out.println("View all enquiries \n");
        facilitatorService.getAll().forEach(f -> {
            System.out.println(f.toString());
        });
    }

    @Override
    public void update() throws ClassNotFoundException,SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadData() throws ClassNotFoundException,SQLException,IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportData() throws ClassNotFoundException,SQLException,IOException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
