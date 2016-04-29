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
public class Facilitator {
    protected int facilitatorId;
    protected String name;
    protected Facilities facilities;
    protected double salary;

    public Facilitator() {
    }

    public Facilitator(int facilitatorId, String name, double salary) {
        this.facilitatorId = facilitatorId;
        this.name = name;
       // this.facilities = facilities;
        this.salary = salary;
    }

    public int getFacilitatorId() {
        return facilitatorId;
    }

    public void setFacilitatorId(int facilitatorId) {
        this.facilitatorId = facilitatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Facilitator{" + "facilitatorId=" + facilitatorId + ", name=" + name + ", salary=" + salary + '}';
    }
    
    
}
