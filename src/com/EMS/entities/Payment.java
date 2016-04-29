/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.entities;

import java.util.Date;

/**
 *
 * @author sharmila
 */
public class Payment {

    protected int paymentId;
    protected Date paymentDate;
    protected double dues;
    protected String paymentType;
    protected Facilities facilities;
    protected Customer customer;
    protected Enrollment enrollment;

    public Payment() {
    }

    public Payment(int paymentId, String paymentType, Date paymentDate, double dues /*, Facilities facilities, Customer customer, Enrollment enrollment */) {
        this.paymentId = paymentId;
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
        this.dues = dues;
//        this.facilities = facilities;
//        this.customer = customer;
//        this.enrollment = enrollment;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getDues() {
        return dues;
    }

    public void setDues(double dues) {
        this.dues = dues;
    }

    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }
    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }
    
    
    @Override
    public String toString() {
        return "Payment{" + "paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", dues=" + dues + ", paymentType=" + paymentType + '}';
    }

}
