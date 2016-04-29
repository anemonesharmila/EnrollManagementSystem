/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.DatabaseConnection.DbConnect;
import com.EMS.dao.EnquiryDao;
import com.EMS.entities.Enquiry;
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
public class EnquiryDaoImpl implements EnquiryDao {

    Enquiry enquiry = new Enquiry();
    List<Enquiry> enquiryList = new ArrayList<>();
    DbConnect dbConnect = new DbConnect();

    public EnquiryDaoImpl() {
    }

    public EnquiryDaoImpl(List<Enquiry> enquiryList) {
        this.enquiryList = enquiryList;
    }

    @Override
    public void insert(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        dbConnect.open();
        String sql = "insert into tbl_enquiry(enquiry_type) values(?)";
        PreparedStatement ps = dbConnect.initStatement(sql);
        ps.setString(1, enquiry.getEnquiryType());
        int result = dbConnect.executeUpdate(sql);
        System.out.println(result + "rows affected");
        dbConnect.close();
    }

    @Override
    public int update(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        dbConnect.open();
        String sql = "update table tbl_enquiry set enquiry_type=? where id=?";
        PreparedStatement ps = dbConnect.initStatement(sql);
        ps.setString(1, enquiry.getEnquiryType());
        ps.setInt(2, enquiry.getEnquiryId());
        int result = dbConnect.executeUpdate(sql);
        dbConnect.close();
        return result;
    }

    @Override
    public Enquiry getById(int enquiryId) throws ClassNotFoundException, SQLException {
        dbConnect.open();
        String sql = "select * from tbl_enquiry where id=?";
        PreparedStatement ps = dbConnect.initStatement(sql);
        ps.setInt(1, enquiryId);
        ResultSet rs = dbConnect.executeQuery();
        
            while (rs.next()) {
                enquiry = new Enquiry();
                enquiry.setEnquiryId(rs.getInt("id"));
                enquiry.setEnquiryDate(rs.getDate("enquiry_date"));
                enquiry.setEnquiryType(rs.getString("enquiry_type"));
            }
        
        dbConnect.close();
        System.out.println(enquiry);
        return enquiry;

    }

    @Override
    public int delete(int enquiryId) throws ClassNotFoundException, SQLException {
        dbConnect.open();
        String sql = "delete from tbl_enquiry where id=?";
        PreparedStatement ps = dbConnect.initStatement(sql);
        ps.setInt(1, enquiryId);
        int result = dbConnect.executeUpdate(sql);
        System.out.println(result + " row affected");
        dbConnect.close();
        return result;
    }

    @Override
    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        dbConnect.open();
        List<Enquiry> enquiryList = new ArrayList<>();
        String sql = "select * from tbl_enquiry";
        PreparedStatement ps = dbConnect.initStatement(sql);
        ResultSet rs = dbConnect.executeQuery();
        while (rs.next()) {
            enquiry = new Enquiry();
            enquiry.setEnquiryId(rs.getInt("id"));
            enquiry.setEnquiryDate(rs.getDate("enquiry_date"));
            enquiry.setEnquiryType(rs.getString("enquiry_type"));
            enquiryList.add(enquiry);
        }
        dbConnect.close();
        return enquiryList;
    }

    @Override
    public List<Enquiry> search(String param) throws ClassNotFoundException, SQLException {
        dbConnect.open();
        List<Enquiry> searchList = new ArrayList<>();
        String sql = "select * from tbl_enquiry where enquiry_type=?";
        PreparedStatement ps = dbConnect.initStatement(sql);
        ps.setString(1, param);
        ResultSet rs = dbConnect.executeQuery();
        while (rs.next()) {
            enquiry = new Enquiry();
            enquiry.setEnquiryId(rs.getInt("id"));
            enquiry.setEnquiryDate(rs.getDate("enquiry_date"));
            enquiry.setEnquiryType(rs.getString("enquiry_type"));
        }
        searchList.add(enquiry);
        System.out.println(searchList);
        dbConnect.close();
        return searchList;

    }

    @Override
    public void loadData(String path) throws ClassNotFoundException, SQLException, IOException {
        Enquiry enquiry = new Enquiry();
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            enquiry.setEnquiryId(Integer.parseInt(tokenizer.nextToken()));
            enquiry.setEnquiryType(tokenizer.nextToken());
            insert(enquiry);
        }
        reader.close();
    }

    @Override
    public void exportData(String filename, String content) throws ClassNotFoundException, SQLException, IOException {
        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }
}
