/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import com.EMS.service.PaymentServices;
import com.EMS.views.PaymentView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class PaymentController extends mainController {

    private Scanner scanner;

    public PaymentController() {
    }

    public PaymentController(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void menu() {
        System.out.println("==============================================");
        System.out.println("enter 1 to insert payment information \n");
        System.out.println("enter 2 to delete payment information \n");
        System.out.println("enter 3 to search payment information by id \n");
        System.out.println("enter 4 to search payment information by name\n");
        System.out.println("enter 5 to view all payment information \n \n");
        System.out.println("enter 6 to update payment information  \n");
        System.out.println("enter 7 to load payment information from file \n");
        System.out.println("enter 8 to export payment information to file \n");
        System.out.println("enter 9 to exit");
        System.out.println("===============================================");
    }

    @Override
    public void process() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        PaymentServices ps = new PaymentServices();
        PaymentView pv = new PaymentView(ps, scanner);
        System.out.println("You selected payment ");
        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    pv.insert();
                    break;
                case 2:
                    pv.delete();
                    break;
                case 3:
                    pv.searchById();

                    break;
                case 4:
                    pv.search();
                    break;
                case 5:
                    pv.viewAll();
                    break;
                case 6:
                    pv.update();
                    break;
                case 7:
                    pv.loadData();
                    break;
                case 8:
                    pv.exportData();
                    break;
                case 9:

                    MainMenuController m = new MainMenuController();
                    m.process();
                    break;

            }
        }
    }

}
