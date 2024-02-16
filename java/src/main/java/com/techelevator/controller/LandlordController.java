package com.techelevator.controller;

import com.techelevator.dao.LeaseDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.PropertyImageDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.DTOs.AddPropertyDTO;
import com.techelevator.model.tables.Lease;
import com.techelevator.model.tables.Property;
import com.techelevator.model.tables.PropertyImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class LandlordController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private PropertyImageDao propertyImageDao;

    @Autowired
    private LeaseDao leaseDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/landlord/add-property", method = RequestMethod.POST)
    public void addProperty(Principal principal, @Valid @RequestBody AddPropertyDTO newProperty) {
        try {
            Integer propertyId = propertyDao.addProperty(userDao.getUserIdByUsername(principal.getName()), newProperty);
            Integer imageId = propertyImageDao.addImage(propertyId, newProperty.getImageUrl());
            if (propertyId == null || imageId == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property add failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Property add failed.");
        }
    }

    @RequestMapping(path = "/landlord/browse-my-properties", method = RequestMethod.GET)
    public List<Property> browseMyProperties(Principal principal) {
        return propertyDao.getPropertiesByLandlordId(userDao.getUserIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/landlord/update-property", method = RequestMethod.PUT)
    public void updateProperty(@Valid @RequestBody Property property) {
        try {
            propertyDao.updateProperty(property);
            if (property == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Property add failed.");
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Property add failed.");
        }
    }

    @RequestMapping(path = "/landlord/view-rents", method = RequestMethod.GET)
    public List<Lease> viewRents(Principal principal) {
        return leaseDao.getLeasesByLandlordId(userDao.getUserIdByUsername(principal.getName()));
    }

    @RequestMapping(path = "/landlord/view-maintenance-requests", method = RequestMethod.GET)
    public void viewLandlordMaintenanceRequests() {

    }

    @RequestMapping(path = "/landlord/view-maintenance-workers", method = RequestMethod.GET)
    public void viewMaintenanceWorkers() {

    }

    @RequestMapping(path = "/landlord/assign-maintenance-worker", method = RequestMethod.PUT)
    public void assignMaintenanceWorker() {

    }
}
