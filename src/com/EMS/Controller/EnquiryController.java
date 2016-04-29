/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import com.EMS.service.EnquiryService;
import com.EMS.views.EnquiryView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class EnquiryController extends mainController {

    private Scanner scanner;

    public EnquiryController() {
    }

    public EnquiryController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("===============================================");
        System.out.println(" enter 1 to insert enquiry information \n");
        System.out.println(" enter 2 to delete enquiry information \n");
        System.out.println(" enter 3 to search enquiry information by id \n");
        System.out.println(" enter 4 to search enquiry information by name\n");
        System.out.println(" enter 5 to view all enquiry information \n \n");
        System.out.println(" enter 6 to update enquiry information  \n");
        System.out.println("enter 7 to load enquiry information from file \n");
        System.out.println("enter 8 to export enquiry information to file \n");
        System.out.println("enter 9 to exit");
        System.out.println("===============================================");
    }

    @Override
    public void process() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        EnquiryService enquiryService = new EnquiryService();
        EnquiryView enquriyView = new EnquiryView(enquiryService, scanner);
        System.out.println("You selected enquiry \n");

        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    enquriyView.insert();
                    break;
                case 2:
                    enquriyView.delete();
                    break;
                case 3:
                    enquriyView.searchById();
                    break;
                case 4:
                    enquriyView.search();
                    break;
                case 5:
                    enquriyView.viewAll();
                    break;
                case 6:
                    enquriyView.update();
                    break;
                case 7:
                    enquriyView.loadData();
                case 8:
                    enquriyView.exportData();
                case 9:
                    MainMenuController m = new MainMenuController();
                    m.process();
            }
        }}

    
}
