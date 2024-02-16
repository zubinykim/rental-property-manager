package com.techelevator.dao;

import com.techelevator.model.tables.Lease;

import java.util.List;

public interface LeaseDao {

    Lease getLeaseById(int leaseId);

    List<Lease> getLeasesByLandlordId(int landlordId);
}
