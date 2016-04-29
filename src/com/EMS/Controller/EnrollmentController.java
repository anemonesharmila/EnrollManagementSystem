/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import com.EMS.service.EnrollmentService;
import com.EMS.views.EnrollementView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class EnrollmentController extends mainController {

    private Scanner scanner;

    public EnrollmentController() {
    }

    public EnrollmentController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("==============================================");
        System.out.println("enter 1 to insert enrollment information \n");
        System.out.println("enter 2 to delete enrollment information \n");
        System.out.println("enter 3 to search enrollment information by id \n");
        System.out.println("enter 4 to search enrollment information by name\n");
        System.out.println("enter 5 to view all enrollment information \n \n");
        System.out.println("enter 6 to update enrollment information  \n");
        System.out.println("enter 7 to load enrollment information from file \n");
        System.out.println("enter 8 to export enrollment information to file \n");
        System.out.println("enter 9 to exit");
        System.out.println("===============================================");
    }

    @Override
    public void process() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        EnrollmentService enS = new EnrollmentService();
        EnrollementView eView = new EnrollementView(enS, scanner);
        System.out.println("You selected enrollment ");
        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    eView.insert();
                    break;
                case 2:
                    eView.delete();
                    break;
                case 3:
                    eView.search();

                    break;
                case 4:
                    eView.searchById();
                    break;
                case 5:

                    eView.viewAll();
                    break;
                case 6:
                    eView.update();
                    break;
                case 7:
                    eView.loadData();
                    break;
                case 8:
                    eView.exportData();
                    break;
                case 9:

                    MainMenuController m = new MainMenuController();
                    m.process();
                    break;

            }
        }
    }

}
