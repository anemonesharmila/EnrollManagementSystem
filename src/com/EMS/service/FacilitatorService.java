/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.FacilitatorDao;
import com.EMS.dao.FacilitiesDao;
import com.EMS.daoImpl.FacilitatorDaoImpl;
import com.EMS.entities.Facilitator;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class FacilitatorService {

    protected FacilitatorDao facilitatorDao;

    public FacilitatorService() {
        facilitatorDao = new FacilitatorDaoImpl(new ArrayList<>());
    }

    public FacilitatorService(FacilitiesDao facilitiesDao) {
        this.facilitatorDao = facilitatorDao;
    }

    public void insert(Facilitator facilitator)throws ClassNotFoundException,SQLException {
        facilitatorDao.insert(facilitator);
    }

    public int update(Facilitator facilitator)throws ClassNotFoundException,SQLException {
        facilitatorDao.update(facilitator);
        return 1;
    }

    public Facilitator getById(int batchId) throws ClassNotFoundException,SQLException{
        return facilitatorDao.getById(batchId);
    }

    public int delete(int facilitatorId) throws ClassNotFoundException,SQLException {
        return facilitatorDao.delete(facilitatorId);
    }

    public List<Facilitator> getAll() throws ClassNotFoundException,SQLException{
        return facilitatorDao.getAll();
    }

    public List<Facilitator> search(String param) throws ClassNotFoundException,SQLException{
        return facilitatorDao.search(param);
    }

    public void export(String filepath, String content) throws IOException, ClassNotFoundException, SQLException {
        facilitatorDao.exportData(filepath, content);

    }

    public void load(String filepath) throws IOException, ClassNotFoundException, SQLException {
        facilitatorDao.loadData(filepath);

    }

}
