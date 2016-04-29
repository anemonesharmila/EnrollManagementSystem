/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class LoadController extends mainController {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        System.out.println("Enter 1 to load  batch data \n");
        System.out.println("Enter 2 to load  customer data \n");
        System.out.println("Enter 3 to load  enquiry data \n");
        System.out.println("Enter 4 to load  enrollment data \n");
        System.out.println("Enter 5 to load facilitator data \n");
        System.out.println("Enter 6 to load  facilities data \n");
        System.out.println("Enter 7 to load  payment data \n");

        System.out.println("Enter 8 to exit ");
    }

    @Override
    public void process() throws ClassNotFoundException,SQLException,IOException{
        while (true) {
            menu();
                
            switch (scanner.nextInt()) {
                case 1:
                    BatchController bc = new BatchController();
                    bc.process();
                    break;
                case 2:
                    CustomerController c = new CustomerController();
                    c.process();
                    break;
                case 3:
                    EnquiryController en = new EnquiryController();
                    en.process();
                    break;
                case 4:
                    EnrollmentController er = new EnrollmentController();
                    er.process();
                    break;
                case 5:
                    FacilitatorController fac = new FacilitatorController();
                    fac.process();
                    break;
                case 6:
                    FacilitiesController f = new FacilitiesController();
                    f.process();
                    break;
                case 7:
                    PaymentController p = new PaymentController();
                    p.process();
                    break;

                case 8:
                    MainMenuController m = new MainMenuController();
                    m.process();

                    break;
            }

        }
    }

}

