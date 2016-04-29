/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Facilities;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface FacilitiesDao {
    void insert(Facilities facilities) throws ClassNotFoundException,SQLException;
    int update(Facilities facilities)throws ClassNotFoundException,SQLException;
    Facilities getById(int batchId)throws ClassNotFoundException,SQLException;
    int delete(int facilitiesId)throws ClassNotFoundException,SQLException;
    List<Facilities> getAll()throws ClassNotFoundException,SQLException;
    List<Facilities> search(String param)throws ClassNotFoundException,SQLException;
    void loadData(String path) throws IOException, ClassNotFoundException,SQLException;
    void exportData(String filename,String content) throws IOException, ClassNotFoundException,SQLException;
    
}
