/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.main;

import com.EMS.Controller.MainMenuController;
import com.EMS.service.BatchService;
import com.EMS.views.BatchView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class MainEnrollManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        BatchService batchService=new BatchService();
        BatchView batchView=new BatchView(batchService, scanner);
        MainMenuController mainMenuController=new MainMenuController();
        mainMenuController.process();
    }
}
