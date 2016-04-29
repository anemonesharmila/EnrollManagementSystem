/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Batch;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface BatchDao {

    void insert(Batch batch)throws ClassNotFoundException,SQLException;

    int update(Batch batch)throws ClassNotFoundException,SQLException;

    Batch getById(int batchId)throws ClassNotFoundException,SQLException;

    int delete(int batchId)throws ClassNotFoundException,SQLException;

    List<Batch> getAll()throws ClassNotFoundException,SQLException;

    List<Batch> search(String param)throws ClassNotFoundException,SQLException;
    
    void loadData(String path) throws IOException,ClassNotFoundException,SQLException;
    
    void exportData(String filename,String content) throws IOException,ClassNotFoundException;
}
