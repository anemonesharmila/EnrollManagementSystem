/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.EnquiryDao;
import com.EMS.daoImpl.EnquiryDaoImpl;
import com.EMS.entities.Enquiry;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class EnquiryService {

    private EnquiryDao enquiryDao;

    public EnquiryService() {
        enquiryDao = new EnquiryDaoImpl(new ArrayList<>());
    }

    public EnquiryService(EnquiryDao enquiryDao) {
        this.enquiryDao = enquiryDao;
    }

    public void insert(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        enquiryDao.insert(enquiry);
    }

    public int update(Enquiry enquiry) throws ClassNotFoundException, SQLException {
        return enquiryDao.update(enquiry);
    }

    public Enquiry getById(int batchId) throws ClassNotFoundException, SQLException {
        return enquiryDao.getById(batchId);
    }

    public List<Enquiry> delete(int enquiryId) throws ClassNotFoundException, SQLException {
        enquiryDao.delete(enquiryId);
        return null;
    }

    public List<Enquiry> getAll() throws ClassNotFoundException, SQLException {
        return enquiryDao.getAll();
    }

    public List<Enquiry> search(String param) throws ClassNotFoundException, SQLException {
        return enquiryDao.search(param);
    }

    public void export(String filepath, String content) throws IOException, ClassNotFoundException, SQLException {
        enquiryDao.exportData(filepath, content);

    }

    public void load(String filepath) throws IOException, ClassNotFoundException, SQLException {
        enquiryDao.loadData(filepath);

    }
}
