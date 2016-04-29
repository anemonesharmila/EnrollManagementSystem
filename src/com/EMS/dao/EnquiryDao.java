/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Enquiry;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface EnquiryDao {

    void insert(Enquiry enquiry) throws ClassNotFoundException, SQLException;

    int update(Enquiry enquiry) throws ClassNotFoundException, SQLException;

    Enquiry getById(int enquiryId) throws ClassNotFoundException, SQLException;

    int delete(int enquiryId) throws ClassNotFoundException, SQLException;

    List<Enquiry> getAll() throws ClassNotFoundException, SQLException;

    List<Enquiry> search(String param) throws ClassNotFoundException, SQLException;

    void loadData(String path) throws IOException, ClassNotFoundException, SQLException;

    void exportData(String filename, String content) throws ClassNotFoundException, SQLException, IOException;
}
