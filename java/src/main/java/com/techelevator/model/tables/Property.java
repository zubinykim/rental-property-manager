package com.techelevator.model.tables;

public class Property {
    private int propertyId;
    private int landlordId;
    private int tenantId;
    private String description;
    private String address;

    public Property() { }

    public Property(int propertyId, int landlordId, int tenantId, String description, String address) {
        this.propertyId = propertyId;
        this.landlordId = landlordId;
        this.tenantId = tenantId;
        this.description = description;
        this.address = address;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(int landlordId) {
        this.landlordId = landlordId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Property{" +
                "propertyId=" + propertyId +
                ", landlordId=" + landlordId +
                ", tenantId=" + tenantId +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
