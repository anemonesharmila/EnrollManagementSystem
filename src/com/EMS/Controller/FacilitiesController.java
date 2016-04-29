/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.Controller;

import com.EMS.service.FacilitiesService;
import com.EMS.views.FacilitiesView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class FacilitiesController extends mainController {

    private Scanner scanner;

    public FacilitiesController(Scanner scanner) {
        this.scanner = scanner;
    }

    public FacilitiesController() {
    }

    @Override
    public void menu() {
        System.out.println("==============================================");
        System.out.println("enter 1 to insert facilities information \n");
        System.out.println("enter 2 to delete facilities information \n");
        System.out.println("enter 3 to search facilities information by id \n");
        System.out.println("enter 4 to search facilities information by name\n");
        System.out.println("enter 5 to view all facilities information \n \n");
        System.out.println("enter 6 to update facilities information  \n");
        System.out.println("enter 7 to load facilities information from file \n");
        System.out.println("enter 8 to export facilities information to file \n");
        System.out.println("enter 9 to exit");
        System.out.println("===============================================");
    }

    @Override
    public void process() throws SQLException, ClassNotFoundException, IOException {
        Scanner scanner = new Scanner(System.in);
        FacilitiesService facilitiesService = new FacilitiesService();
        FacilitiesView fv = new FacilitiesView(facilitiesService, scanner);
        System.out.println("You selected enrollment ");
        while (true) {
            menu();
            switch (scanner.nextInt()) {
                case 1:
                    fv.insert();
                    break;
                case 2:
                    fv.delete();
                    break;
                case 3:
                    fv.searchById();

                    break;
                case 4:
                    fv.search();
                    break;
                case 5:

                    fv.viewAll();
                    break;
                case 6:
                    fv.update();
                    break;
                case 7:
                    fv.loadData();
                    break;
                case 8:
                    fv.exportData();
                    break;
                case 9:
                    MainMenuController m = new MainMenuController();
                    m.process();
                    break;

            }
        }
    }

}
