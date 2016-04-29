/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Enrollment;
import com.EMS.service.EnrollmentService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class EnrollementView extends View {

    protected EnrollmentService enrollmentService;
    protected Scanner scanner;

    public EnrollementView() {
    }

    public EnrollementView(EnrollmentService enrollmentService, Scanner scanner) {
        this.enrollmentService = enrollmentService;
        this.scanner = scanner;
    }

    Enrollment enrollment = new Enrollment();

    @Override
    public void insert() throws ClassNotFoundException, SQLException {
        while (true) {

            System.out.println("Enter enrollment type");
            enrollment.setEnrollmentType(scanner.next());
            enrollmentService.insert(enrollment);
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
            System.out.println("Enter enrollment id to delete \n");
            enrollmentService.delete(scanner.nextInt());
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
            System.out.println("Enter the enrollment type \n");
            enrollmentService.search(scanner.nextLine());
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
            System.out.println("Enter the enrollment id to search \n");
            enrollmentService.getById(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    
}

    @Override
    public void viewAll() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadData() throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportData() throws ClassNotFoundException, SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}