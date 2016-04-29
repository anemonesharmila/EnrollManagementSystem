/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface CustomerDao {
    
    void insert(Customer customer) throws ClassNotFoundException,SQLException;
    int update(Customer customer)throws ClassNotFoundException,SQLException;
    Customer getById(int customerId)throws ClassNotFoundException,SQLException;
    int delete(int customerId)throws ClassNotFoundException,SQLException;
    List<Customer> getAll()throws ClassNotFoundException,SQLException;
    List<Customer> search(String param)throws ClassNotFoundException,SQLException;
    void loadData(String path) throws ClassNotFoundException,IOException,SQLException;
    void exportData(String filename,String content) throws IOException,ClassNotFoundException;
}
