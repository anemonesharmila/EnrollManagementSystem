/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import com.EMS.service.CustomerService;
import com.EMS.views.CustomerView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class CustomerController extends mainController {

    private Scanner scanner;

    public CustomerController() {
    }

    public CustomerController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("===============================================");
        System.out.println("enter 1 to insert customer information \n");
        System.out.println("enter 2 to delete customer information \n");
        System.out.println("enter 3 to search customer information by id \n");
        System.out.println("enter 4 to search customer information by name\n");
        System.out.println("enter 5 to view all customer information \n \n");
        System.out.println("enter 6 to update customer information  \n");
        System.out.println("enter 7 to load customer information from file \n");
        System.out.println("enter 8 to export customer information to file \n");
        System.out.println("enter 9 to exit");
        System.out.println("===============================================");

    }

    @Override
    public void process() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        CustomerView customerView = new CustomerView(customerService, scanner);
        System.out.println("You selected customer \n");

        while (true) {
            menu();

            switch (scanner.nextInt()) {
                case 1:
                    customerView.insert();
                    break;
                case 2:
                    customerView.delete();
                    break;
                case 3:
                    customerView.searchById();
                    break;
                case 4:
                    customerView.search();
                    break;
                case 5:
                    customerView.viewAll();
                    break;
                case 6:
                    customerView.update();
                    break;
                case 7:
                    customerView.loadData();
                    break;
                case 8:
                    customerView.exportData();
                    break;
                case 9:
                    MainMenuController m = new MainMenuController();
                    m.process();
                    break;
            }

        }

    }

}
