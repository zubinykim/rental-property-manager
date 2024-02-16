package com.techelevator.model.tables;

import java.time.LocalDate;

public class MaintenanceRequest {

    private int requestId;
    private int propertyId;
    private int tenantId;
    private int workerId;
    private String description;
    private LocalDate requestDate;
    private String issueLocation;

    public MaintenanceRequest() {}

    public MaintenanceRequest(int requestId, int propertyId, int tenantId, int workerId, String description, LocalDate requestDate, String issueLocation) {
        this.requestId = requestId;
        this.propertyId = propertyId;
        this.tenantId = tenantId;
        this.workerId = workerId;
        this.description = description;
        this.requestDate = requestDate;
        this.issueLocation = issueLocation;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
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

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getIssueLocation() {
        return issueLocation;
    }

    public void setIssueLocation(String issueLocation) {
        this.issueLocation = issueLocation;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "requestId=" + requestId +
                ", propertyId=" + propertyId +
                ", tenantId=" + tenantId +
                ", workerId=" + workerId +
                ", description='" + description + '\'' +
                ", requestDate=" + requestDate +
                ", issueLocation='" + issueLocation + '\'' +
                '}';
    }
}
