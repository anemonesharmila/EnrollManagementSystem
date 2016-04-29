/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.EMS.entities;

/**
 *
 * @author sharmila
 */
public class Batch {

    protected int batchId;
    protected String batchName;
    protected Facilities facilities;

    public Batch() {
    }

    public Batch(String batchName) {

        this.batchName = batchName;
        // this.facilities=facilities;
    }

    public int getBatchId() {
        return batchId;
    }

    public void setBatchId(int batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Facilities getFacility() {
        return facilities;
    }

    public void setFacility(Facilities facility) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "Batch{" + "batchId=" + batchId + ", batchName=" + batchName + '}';
    }

    public String toCSV() {
        return batchId + "," + batchName + "\r\n";
    }

}
