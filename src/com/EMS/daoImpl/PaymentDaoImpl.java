/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.daoImpl;

import com.EMS.dao.PaymentDao;
import com.EMS.entities.Payment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author sharmila
 */
public class PaymentDaoImpl implements PaymentDao {

    private List<Payment> paymentList;

    public PaymentDaoImpl() {
    }

    public PaymentDaoImpl(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @Override
    public void insert(Payment payment)throws ClassNotFoundException,SQLException {
        paymentList.add(payment);
    }

    @Override
    public int update(Payment payment) throws ClassNotFoundException,SQLException{
        return 1;
    }

    @Override
    public Payment getById(int batchId) throws ClassNotFoundException,SQLException{
        for (Payment p : paymentList) {
            if (p.getPaymentId() == batchId) {
                return p;
            }
        }
        return null;
    }

    @Override
    public int delete(int paymentId) throws ClassNotFoundException,SQLException{
        for (Payment pay : paymentList) {
            if (pay.getPaymentId() == paymentId) {
                paymentList.remove(pay);
            }
           
        }
        return 1;
    }

    @Override
    public List<Payment> getAll() throws ClassNotFoundException,SQLException{
        return paymentList;
    }

    @Override
    public List<Payment> search(String param) throws ClassNotFoundException,SQLException{

        List<Payment> paySearchList = new ArrayList<>();
        paymentList.forEach(se -> {
            if (se.getPaymentType().startsWith(param)) {
                paySearchList.add(se);
            }
        });
        return paySearchList;
    }

    @Override
    public void loadData(String path) throws IOException ,ClassNotFoundException,SQLException{
        Payment payment = new Payment();
        String line = "";
        BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            payment.setPaymentId(Integer.parseInt(tokenizer.nextToken()));
            payment.setPaymentType(tokenizer.nextToken());
           
            insert(payment);
        }
        reader.close();

    }

    @Override
    public void exportData(String filename, String content) throws IOException , ClassNotFoundException,SQLException{
        FileWriter fileWriter = new FileWriter(new File(filename));
        fileWriter.write(content);
        fileWriter.close();
    }

}
