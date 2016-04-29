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
public class Enquiry {

    protected int enquiryId;
    protected Date enquiryDate;
    protected String enquiryType;
    protected Facilities facilities;
    protected Facilitator facilitator;
    protected Payment payment;

    public Enquiry() {

    }

    public Enquiry(int enquiryId, String enquiryType) {
        this.enquiryId = enquiryId;

        this.enquiryType = enquiryType;
    }

    public String getEnquiryType() {
        return enquiryType;
    }

    public void setEnquiryType(String enquiryType) {
        this.enquiryType = enquiryType;
    }

    public int getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(int enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Date getEnquiryDate() {
        return enquiryDate;
    }

    public void setEnquiryDate(Date enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    @Override
    public String toString() {
        return "Enquiry{" + "enquiryId=" + enquiryId + ", enquiryDate=" + enquiryDate + ", enquiryType=" + enquiryType + '}';
    }

    public String toCSV() {
        return "Enquiry{" + "enquiryId=" + enquiryId + ", enquiryDate=" + enquiryDate + ", enquiryType=" + enquiryType + '}';

    }

}
