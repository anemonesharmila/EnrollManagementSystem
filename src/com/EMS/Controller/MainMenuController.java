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
public class MainMenuController extends mainController {

    @Override
    public void menu() {
        System.out.println("==============================================");
        System.out.println("Select 1 to make changes to Batch \n");
        System.out.println("Select 2 to make changes to Customer \n");
        System.out.println("select 3 to make changes to Enquiry \n");
        System.out.println("Select 4 to make changes to Enrollment \n");
        System.out.println("Select 5 to make changes to Facilitator \n");
        System.out.println("Select 6 to make changes to Facilities \n");
        System.out.println("Select 7 to make changes to Payment \n");
        System.out.println("Select 8 to load data from the file \n");
        System.out.println("Select 9 to export data to the file \n");
        System.out.println("Select 10 to exit");

        System.out.println("==============================================");
    }

    @Override
    public void process() throws ClassNotFoundException, SQLException, IOException {
        Scanner scanner = new Scanner(System.in);

//        BatchService batchService = new BatchService();
//        BatchView batchView = new BatchView(batchService, scanner);
        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    mainController mainC = new BatchController();
                    mainC.process();

                    break;
                case 2:
                    mainController m = new CustomerController();
                    m.process();
                    break;

                case 3:
                    mainController m1 = new EnquiryController();
                    m1.process();
                    break;

                case 4:
                    mainController m2 = new EnrollmentController();
                    m2.process();
                    break;

                case 5:
                    mainController m3 = new FacilitatorController();
                    m3.process();
                    break;

                case 6:
                    mainController m4 = new FacilitiesController();
                    m4.process();
                    break;

                case 7:
                    mainController m5 = new PaymentController();
                    m5.process();
                    break;
                case 8:
                    mainController f = new LoadController();
                    f.process();
                    break;
                case 9:
                    mainController fc = new ExportController();
                    fc.process();
                    break;

                case 10:
                    System.exit(0);

            }

        }

    }
}
