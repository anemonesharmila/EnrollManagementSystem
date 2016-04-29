/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.dao;

import com.EMS.entities.Payment;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sharmila
 */
public interface PaymentDao {
    void insert(Payment payment)throws ClassNotFoundException,SQLException;
    int update(Payment payment)throws ClassNotFoundException,SQLException;
    Payment getById(int batchId)throws ClassNotFoundException,SQLException;
    int delete(int paymentId)throws ClassNotFoundException,SQLException;
    List<Payment> getAll()throws ClassNotFoundException,SQLException;
    List<Payment> search(String param)throws ClassNotFoundException,SQLException;
    void loadData(String path) throws IOException,ClassNotFoundException,SQLException;
    void exportData(String filename,String content) throws IOException, ClassNotFoundException,SQLException;
}
