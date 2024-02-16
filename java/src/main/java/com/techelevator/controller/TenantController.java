package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.model.tables.Property;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TenantController {

    private PropertyDao propertyDao;

    @RequestMapping(path = "/browse-available-properties", method = RequestMethod.GET)
    public List<Property> browseAvailableProperties() {
        return propertyDao.getAvailableProperties();
    }
}
