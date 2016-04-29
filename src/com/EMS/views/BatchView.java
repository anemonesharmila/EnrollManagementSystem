/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.views;

import com.EMS.entities.Batch;
import com.EMS.service.BatchService;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author sharmila
 */
public class BatchView extends View {

    protected BatchService batchService;
    protected Scanner scanner;

    // Facilities facilities = new Facilities();
    public BatchView() {
    }

    public BatchView(BatchService batchService, Scanner scanner) {
        this.batchService = batchService;
        this.scanner = scanner;
    }

    @Override
    public void insert() throws ClassNotFoundException, SQLException {
        while (true) {

            Batch batch = new Batch();

            System.out.println("Enter the batch name \n");
            batch.setBatchName(scanner.next());

            batchService.insert(batch);

//            System.out.println("Enter the Facilities \n");
//            int faciId = scanner.nextInt();
//            if (faciId == facilities.getFacilityId()) {
//                {
//                    batch.setFacility(new Facilities());
//                }
//            }
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
            System.out.println("Enter the batch id to delete \n");
            batchService.delete(scanner.nextInt());
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
            System.out.println("Enter the batch name to search \n");
            String search = scanner.next();
            batchService.search(search);
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
            System.out.println("Enter the batch id to search \n");
            int search = scanner.nextInt();
            batchService.getById(search);
            System.out.println("----------------------------------");
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    @Override
    public void viewAll() throws ClassNotFoundException, SQLException {
        System.out.println("view all the batch information");
        batchService.getAll().forEach(b -> {
            System.out.println(b.toString());
        });
    }

    @Override
    public void update() throws ClassNotFoundException, SQLException {
        Batch batch = new Batch();
        System.out.println("Enter the batch id where you want to update");
        int id = scanner.nextInt();
        batch.setBatchId(id);
        System.out.println("Enter the new batch name");
        String batchName = scanner.next();
        batch.setBatchName(batchName);
        batchService.update(batch);
    }

    @Override
    public void loadData() throws ClassNotFoundException, SQLException, IOException {
        System.out.println("Enter the path of the file to import data \n");
        String filePath = scanner.next();
//        batchService.getAll().forEach(b->{
//            System.out.println(b);});
        batchService.load(filePath);
        System.out.println("import successfull");
    }

    @Override
    public void exportData() throws ClassNotFoundException, SQLException, IOException {
        while (true) {
            System.out.println("Enter the path to export the data \n");
            String filePath = scanner.next();
            StringBuilder builder = new StringBuilder();
            batchService.getAll().forEach(b -> {
                builder.append(b.toCSV());
            });

            batchService.export(filePath, builder.toString());
            System.out.println("Do you want to continue??[y/n]");
            if (scanner.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
