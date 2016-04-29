/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Payment;
import com.EMS.service.PaymentServices;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class PaymentView extends View {

    protected PaymentServices paymentServices;
    protected Scanner scanner;

    Payment payment = new Payment();

    public PaymentView() {
    }

    public PaymentView(PaymentServices paymentServices, Scanner scanner) {
        this.paymentServices = paymentServices;
        this.scanner = scanner;
    }

    @Override
    public void insert() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter payment id \n");
            payment.setPaymentId(scanner.nextInt());
            System.out.println("Enter payment type \n");
            payment.setPaymentType(scanner.nextLine());
            paymentServices.insert(payment);
//        System.out.println("Enter enquiry date \n");
//        enquiry.setEnquiryDate();
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
            paymentServices.delete(scanner.nextInt());
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

            System.out.println("Enter the payment type \n");
            paymentServices.search(scanner.nextLine());
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
            System.out.println("Enter the payment id to search \n");
            paymentServices.getById(scanner.nextInt());
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }

    }

    @Override
    public void viewAll() throws ClassNotFoundException, SQLException {

        System.out.println("View all payment details \n");
        paymentServices.getAll().forEach(pa -> {
            System.out.println(pa.toString());
        });
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
