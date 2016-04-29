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
public class Facilities {
    protected int facilityId;
    protected String name;
    protected double fee;
    protected int facilitiesDuration;
    protected Facilitator facilitator;

    public Facilities() {
    }

    public Facilities(int facilityId, String name, double fee) {
        this.facilityId = facilityId;
        this.name = name;
        this.fee = fee;
    
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getFacilitiesDuration() {
        return facilitiesDuration;
    }

    public void setFacilitiesDuration(int facilitiesDuration) {
        this.facilitiesDuration = facilitiesDuration;
    }

    

    public Facilitator getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(Facilitator facilitator) {
        this.facilitator = facilitator;
    }

    @Override
    public String toString() {
        return "Facilities{" + "facilityId=" + facilityId + ", name=" + name + ", fee=" + fee + ", facilitiesDuration=" + facilitiesDuration + ", facilitator=" + facilitator + '}';
    }
    
    
    
}
