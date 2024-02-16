package com.techelevator.dao;

import com.techelevator.model.DTOs.AddPropertyDTO;
import com.techelevator.model.tables.PropertyImage;

public interface PropertyImageDao {

    int addImage(int propertyId, String imageUrl);
}
