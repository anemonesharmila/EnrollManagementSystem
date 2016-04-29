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
public class Enrollment {

    protected Facilities facilities;
    protected Customer customer;
    protected Batch batch;
    protected int enrollmentId;
    protected Date enrollmentDate;
    protected String enrollmentType;

    public Enrollment() {
    }

    public Enrollment(int enrollmentId, Date enrollmentDate, String enrollmentType) {
        this.enrollmentId = enrollmentId;
        this.enrollmentDate = enrollmentDate;
        this.enrollmentType = enrollmentType;
    }

    public String getEnrollmentType() {
        return enrollmentType;
    }

    public void setEnrollmentType(String enrollmentType) {
        this.enrollmentType = enrollmentType;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "enrollmentId=" + enrollmentId + ", enrollmentDate=" + enrollmentDate + ", enrollmentType=" + enrollmentType + '}';
    }

    public String toCSV() {
        return "Enrollment{" + "enrollmentId=" + enrollmentId + ", enrollmentDate=" + enrollmentDate + ", enrollmentType=" + enrollmentType + '}';

    }

}
