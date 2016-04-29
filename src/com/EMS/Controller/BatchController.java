/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import com.EMS.service.BatchService;
import com.EMS.views.BatchView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class BatchController extends mainController {

    MainMenuController mMC = new MainMenuController();

    public BatchController() {
    }

    @Override
    public void menu() {
        System.out.println("===============================================");
        System.out.println("enter 1 to insert batch information \n");
        System.out.println("enter 2 to delete batch information \n");
        System.out.println("enter 3 to search batch information by id \n");
        System.out.println("enter 4 to search batch information by name\n");
        System.out.println("enter 5 to view all batch information \n \n");
        System.out.println("enter 6 to update batch information  \n");
        System.out.println("enter 7 to load batch information from file \n");
        System.out.println("enter 8 to export batch information to file \n");
        System.out.println("enter 9 to exit");
        System.out.println("===============================================");

    }

    @Override
    public void process() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        BatchService batchService = new BatchService();
        BatchView bView = new BatchView(batchService, scanner);
        System.out.println("You selected batch ");

        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    bView.insert();
                    break;
                case 2:
                    bView.delete();
                    break;
                case 3:
                    bView.searchById();

                    break;
                case 4:
                    bView.search();
                    break;
                case 5:
                    bView.viewAll();

                    break;
                case 6:
                    bView.update();
                    break;
                case 7:
                    bView.loadData();
                    break;
                case 8:
                    bView.exportData();
                    break;
                case 9:
                    mMC.process();
                    break;
            }
        }
    }

}
