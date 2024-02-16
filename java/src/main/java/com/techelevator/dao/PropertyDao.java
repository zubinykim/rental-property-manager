package com.techelevator.dao;

import com.techelevator.model.DTOs.AddPropertyDTO;
import com.techelevator.model.tables.Property;

import java.util.List;

public interface PropertyDao {

    Property getPropertyById(int propertyId);

    List<Property> getAvailableProperties();

    List<Property> getPropertiesByLandlordId(int landlordId);

    int addProperty(int landlordId, AddPropertyDTO property);

    void updateProperty(Property property);
}
