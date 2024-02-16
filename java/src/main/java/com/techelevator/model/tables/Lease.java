package com.techelevator.model.tables;

import java.util.Date;

public class Lease {

    private int leaseId;
    private int propertyId;
    private int tenantId;
    private double rentAmount;
    private Date rentDueDate;
    private String rentStatus;

    public Lease() {}

    public Lease(int leaseId, int propertyId, int tenantId, double rentAmount, Date rentDueDate, String rentStatus) {
        this.leaseId = leaseId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.rentAmount = rentAmount;
        this.rentDueDate = rentDueDate;
        this.rentStatus = rentStatus;
    }

    public int getLeaseId() {
        return leaseId;
    }

    public void setLeaseId(int leaseId) {
        this.leaseId = leaseId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public Date getRentDueDate() {
        return rentDueDate;
    }

    public void setRentDueDate(Date rentDueDate) {
        this.rentDueDate = rentDueDate;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Override
    public String toString() {
        return "Lease{" +
                "leaseId=" + leaseId +
                ", propertyId=" + propertyId +
                ", tenantId=" + tenantId +
                ", rentAmount=" + rentAmount +
                ", rentDueDate=" + rentDueDate +
                ", rentStatus='" + rentStatus + '\'' +
                '}';
    }
}
