/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.service;

import com.EMS.dao.PaymentDao;
import com.EMS.daoImpl.PaymentDaoImpl;
import com.EMS.entities.Payment;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sharmila
 */
public class PaymentServices {

    private PaymentDao paymentDao;

    public PaymentServices() {
        paymentDao = new PaymentDaoImpl(new ArrayList<>());
    }

    public PaymentServices(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    public void insert(Payment payment) throws ClassNotFoundException,SQLException {
        paymentDao.insert(payment);
    }

    public int update(Payment payment) throws ClassNotFoundException,SQLException {

        return 1;
    }

    public Payment getById(int batchId) throws ClassNotFoundException,SQLException{
        return paymentDao.getById(batchId);

    }

    public int delete(int paymentId) throws ClassNotFoundException,SQLException {
        return paymentDao.delete(paymentId);
    }

    public List<Payment> getAll() throws ClassNotFoundException,SQLException{
        return paymentDao.getAll();
    }

    public List<Payment> search(String param) throws ClassNotFoundException,SQLException {
        return paymentDao.search(param);
    }

    public void export(String filepath, String content) throws IOException, ClassNotFoundException, SQLException {
        paymentDao.exportData(filepath, content);

    }

    public void load(String filepath) throws IOException, ClassNotFoundException, SQLException {
        paymentDao.loadData(filepath);

    }
}
