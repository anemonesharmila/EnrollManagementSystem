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
public class Customer {
    protected int customerId;
    protected String address;
    protected String FirstName;
    protected String LastName;
    protected Facilities facilities;
   protected Batch batch;

    public Customer() {
    }

    public Customer(int customerId, String address, String FirstName, String LastName) {
        this.customerId = customerId;
        this.address = address;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

   

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", address=" + address + ", FirstName=" + FirstName + ", LastName=" + LastName + '}';
    }

  
    
    public String toCsv()
    {
        return  customerId + ", " + address + "," + FirstName + "," + LastName + "\r\n";
   
    }
    
}
