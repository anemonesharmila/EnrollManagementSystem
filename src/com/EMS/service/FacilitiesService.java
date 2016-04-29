/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.FacilitiesDao;
import com.EMS.daoImpl.FacilitiesDaoImpl;
import com.EMS.entities.Facilities;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class FacilitiesService {

    private FacilitiesDao facilitiesDao;

    public FacilitiesService() {
        facilitiesDao = new FacilitiesDaoImpl(new ArrayList<>());
    }

    public FacilitiesService(FacilitiesDao facilitiesDao) {
        this.facilitiesDao = facilitiesDao;
    }

    public void insert(Facilities facilities) throws ClassNotFoundException,SQLException{
        facilitiesDao.insert(facilities);
    }

    public int update(Facilities facilities) throws ClassNotFoundException,SQLException{
        return 1;
    }

    public List<Facilities> getById(int batchId) throws ClassNotFoundException,SQLException{
         facilitiesDao.getById(batchId);
         return null;
    }

    public int delete(int facilitiesId) throws ClassNotFoundException,SQLException {
        return facilitiesDao.delete(facilitiesId);
    }

    public List<Facilities> getAll() throws ClassNotFoundException,SQLException{
        return facilitiesDao.getAll();
    }

    public List<Facilities> search(String param) throws ClassNotFoundException,SQLException {
        return facilitiesDao.search(param);
    }

    public void export(String filepath, String content) throws IOException, ClassNotFoundException, SQLException {
        facilitiesDao.exportData(filepath, content);

    }

    public void load(String filepath) throws IOException, ClassNotFoundException, SQLException {
        facilitiesDao.loadData(filepath);

    }
}
