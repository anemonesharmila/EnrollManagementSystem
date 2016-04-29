/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.CustomerDao;
import com.EMS.daoImpl.CustomerDaoImpl;
import com.EMS.entities.Customer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class CustomerService {

    protected CustomerDao customerDao;

    public CustomerService() {
        customerDao = new CustomerDaoImpl(new ArrayList<>());
    }

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void insert(Customer customer) throws ClassNotFoundException, SQLException {
        customerDao.insert(customer);
    }

    public int update(Customer customer) throws ClassNotFoundException, SQLException {
        return customerDao.update(customer);
    }

    public Customer getById(int customerId) throws ClassNotFoundException, SQLException {
        return customerDao.getById(customerId);
    }

    public List<Customer> delete(int customerId) throws ClassNotFoundException, SQLException {
        customerDao.delete(customerId);
        return null;

    }

    public List<Customer> getAll() throws ClassNotFoundException, SQLException {

        return customerDao.getAll();
    }

    public List<Customer> search(String param) throws ClassNotFoundException, SQLException {
        return customerDao.search(param);
    }

    public void export(String filepath, String content) throws IOException, ClassNotFoundException, SQLException {
        customerDao.exportData(filepath, content);

    }

    public void load(String filepath) throws IOException, ClassNotFoundException, SQLException {
        customerDao.loadData(filepath);

    }
}
