/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.DatabaseConnection.DbConnect;
import com.EMS.dao.CustomerDao;
import com.EMS.entities.Customer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author sharmila
 */
public class CustomerDaoImpl implements CustomerDao {

    private List<Customer> customerList;
    DbConnect dbConn = new DbConnect();

    Customer customer = new Customer();

    public CustomerDaoImpl() {
    }

    public CustomerDaoImpl(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public void insert(Customer customer) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "insert into tbl_customer(address,first_name,last_name) values(?,?,?)";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, customer.getAddress());
        ps.setString(2, customer.getFirstName());
        ps.setString(3, customer.getLastName());

        int result = ps.executeUpdate();
        System.out.println("rows affected " + result);
        dbConn.close();
    }

    @Override
    public int update(Customer customer) throws ClassNotFoundException, SQLException {
        dbConn.open();
        String sql = "update table tbl_customer set address=?,first_name=?,last_name=? where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, customer.getAddress());
        ps.setString(2, customer.getFirstName());
        ps.setString(3, customer.getLastName());
        ps.setInt(4, customer.getCustomerId());

        int result = dbConn.executeUpdate(sql);
        System.out.println("updated successfully,\n" + result + "rows affected");

        dbConn.close();
        return result;
    }

    @Override
    public Customer getById(int customerId) throws ClassNotFoundException, SQLException {

        dbConn.open();
        String sql = "select * from tbl_customer where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, customerId);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {

            customer = new Customer();
            if (customer.getCustomerId() == customerId) {
                customer = mapData(rs);
            } else {
                System.out.println("no such records");
            }
        }
        System.out.println(customer);
        dbConn.close();
        return customer;
    }

    @Override
    public int delete(int customerId) throws ClassNotFoundException, SQLException {

        dbConn.open();
        String sql = "delete from tbl_customer where id=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setInt(1, customerId);
        int result = dbConn.executeUpdate(sql);
        dbConn.close();
        return result;
    }

    @Override
    public List<Customer> getAll() throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Customer> customerList = new ArrayList<>();
        String sql = "select * from tbl_customer";
        PreparedStatement ps = dbConn.initStatement(sql);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {
            customerList.add(mapData(rs));
        }
        dbConn.close();
        return customerList;
    }

    @Override
    public List<Customer> search(String param) throws ClassNotFoundException, SQLException {
        dbConn.open();
        List<Customer> custSearchList = new ArrayList<>();
        String sql = "select * from tbl_customer where first_name=?";
        PreparedStatement ps = dbConn.initStatement(sql);
        ps.setString(1, param);
        ResultSet rs = dbConn.executeQuery();
        while (rs.next()) {

            custSearchList.add(mapData(rs));

        }
        System.out.println(custSearchList);

        dbConn.close();
        return custSearchList;
    }

    @Override
    public void loadData(String path) throws ClassNotFoundException, SQLException, IOException {

        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            customer.setCustomerId(Integer.parseInt(tokenizer.nextToken()));
            customer.setFirstName(tokenizer.nextToken());
            customer.setLastName(tokenizer.nextToken());

            insert(customer);
            System.out.println(customer);
        }

        reader.close();
    }

    @Override
    public void exportData(String filename, String content) throws IOException {
        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }

    private Customer mapData(ResultSet rs) throws SQLException, ClassNotFoundException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("id"));
        customer.setAddress(rs.getString("address"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        return customer;
    }
}
