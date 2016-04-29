/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.EnrollmentDao;
import com.EMS.daoImpl.EnrollmentDaoImpl;
import com.EMS.entities.Enrollment;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class EnrollmentService {

    protected EnrollmentDao enrollmentDao;

    public EnrollmentService() {
        enrollmentDao = new EnrollmentDaoImpl(new ArrayList<>());
    }

    public EnrollmentService(EnrollmentDao enrollmentDao) {
        this.enrollmentDao = enrollmentDao;
    }

    public void insert(Enrollment enrollment) throws ClassNotFoundException,SQLException {
        enrollmentDao.insert(enrollment);
    }

    public int update(Enrollment enrollment) throws ClassNotFoundException,SQLException{
        return enrollmentDao.update(enrollment);
    }

    public Enrollment getById(int batchId) throws ClassNotFoundException,SQLException{
        return enrollmentDao.getById(batchId);
    }

    public int delete(int enrollmentId) throws ClassNotFoundException,SQLException{
        return enrollmentDao.delete(enrollmentId);
    }

    public List<Enrollment> getAll() throws ClassNotFoundException,SQLException{
        return enrollmentDao.getAll();
    }

    public List<Enrollment> search(String param)throws ClassNotFoundException,SQLException {
        return enrollmentDao.search(param);
    }

    public void export(String filepath, String content) throws IOException, ClassNotFoundException, SQLException {
        enrollmentDao.exportData(filepath, content);

    }

    public void load(String filepath) throws IOException, ClassNotFoundException, SQLException {
        enrollmentDao.loadData(filepath);

    }
}
