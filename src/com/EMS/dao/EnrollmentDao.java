/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Enrollment;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface EnrollmentDao {
    void insert(Enrollment enrollment)throws ClassNotFoundException,SQLException;
    int update(Enrollment enrollment)throws ClassNotFoundException,SQLException;
    Enrollment getById(int batchId)throws ClassNotFoundException,SQLException;
    int delete(int enrollementId)throws ClassNotFoundException,SQLException;
    List<Enrollment> getAll()throws ClassNotFoundException,SQLException;
    List<Enrollment> search(String param)throws ClassNotFoundException,SQLException;
    void loadData(String path) throws IOException,ClassNotFoundException,SQLException;
    void exportData(String filename,String content) throws IOException,ClassNotFoundException,SQLException;
}
