/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Facilitator;
import com.EMS.entities.Facilities;
import com.EMS.service.FacilitiesService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class FacilitiesView extends View {

    protected FacilitiesService facilitiesService;
    protected Scanner scanner;

    Facilities facilities = new Facilities();
    Facilitator facilitator = new Facilitator();

    public FacilitiesView() {
    }

    public FacilitiesView(FacilitiesService facilitiesService, Scanner scanner) {
        this.facilitiesService = facilitiesService;
        this.scanner = scanner;
    }

    @Override
    public void insert() throws ClassNotFoundException, SQLException {
        while (true) {
            System.out.println("Enter the facility name \n");
            facilities.setName(scanner.next());
            System.out.println("Enter the facility charge \n");
            facilities.setFee(scanner.nextDouble());
            System.out.println("Enter the facility duration\n");
            facilities.setFacilitiesDuration(scanner.nextInt());

            facilitiesService.insert(facilities);
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
            System.out.println("Enter the facility id to delete \n");
            facilitiesService.delete(scanner.nextInt());
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
            System.out.println("Enter the facility name to search \n");
            String search = scanner.nextLine();
            facilitiesService.search(search);
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
            System.out.println("Enter the facility id to search \n");
            int search = scanner.nextInt();
            facilitiesService.getById(search);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void viewAll() throws ClassNotFoundException, SQLException {
        while (true) {
            facilitiesService.getAll().forEach(fa -> {
                System.out.println(fa.toString());
            });
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void update() throws ClassNotFoundException, SQLException {
        System.out.println("Enter the id of  facility ,you need to change");
        int id= scanner.nextInt();
       
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
