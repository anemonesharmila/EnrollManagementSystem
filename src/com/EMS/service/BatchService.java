/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.BatchDao;
import com.EMS.daoImpl.BatchDaoImpl;
import com.EMS.entities.Batch;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class BatchService {

    protected BatchDao batchDao;

    public BatchService() {
        batchDao = new BatchDaoImpl(new ArrayList<>());
    }

    public BatchService(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    public void insert(Batch batch) throws ClassNotFoundException,SQLException {
        batchDao.insert(batch);
    }

    public int update(Batch batch) throws ClassNotFoundException,SQLException{
        return batchDao.update(batch);
    }

//    public List<Batch> getById(int batchId) throws ClassNotFoundException,SQLException{
//        batchDao.getById(batchId);
//        return null;
//    }
     public Batch getById(int batchId) throws ClassNotFoundException,SQLException{
        return batchDao.getById(batchId);
       // return null;
    }

    public List<Batch> delete(int batchId) throws ClassNotFoundException,SQLException{
        batchDao.delete(batchId);
        return null;
    }

    public List<Batch> getAll()throws ClassNotFoundException,SQLException {
        return batchDao.getAll();
    }

    public List<Batch> search(String param)throws ClassNotFoundException,SQLException {
        return batchDao.search(param);
    }

    public void export(String filepath, String content) throws IOException,ClassNotFoundException,SQLException {
         batchDao.exportData(filepath, content);

    }
   public void load(String filepath) throws IOException, ClassNotFoundException,SQLException
   {
       batchDao.loadData( filepath);
       
   }
}
