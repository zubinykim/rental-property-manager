package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.DTOs.AddPropertyDTO;
import com.techelevator.model.tables.Property;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Property getPropertyById(int propertyId) {
        Property property = null;
        String sql = "select property_id, landlord_id, tenant_id, description, image_url from properties where property_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
            if (results.next()) {
                property = mapRowToProperty(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return property;
    }

    @Override
    public List<Property> getAvailableProperties() {
        List<Property> properties = new ArrayList<>();
        String sql = "select property_id, landlord_id, tenant_id, description, image_url from properties where tenant_id is null";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Property property = mapRowToProperty(results);
                properties.add(property);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return properties;
    }

    @Override
    public List<Property> getPropertiesByLandlordId(int landlordId) {
        List<Property> properties = new ArrayList<>();
        String sql = "select property_id, landlord_id, tenant_id, description, image_url from properties where landlord_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlordId);
            while (results.next()) {
                Property property = mapRowToProperty(results);
                properties.add(property);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return properties;
    }

    @Override
    public int addProperty(int landlordId, AddPropertyDTO newProperty) {
        String sql = "insert into properties (landlord_id, description, address) values (?, ?, ?) returning property_id";
        try {
            return jdbcTemplate.queryForObject(sql, int.class, landlordId, newProperty.getDescription(), newProperty.getAddress());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }
    @Override
    public void updateProperty(Property property) {
        String sql = "update properties set tenant_id = ?, description = ?, address = ? where property_id = ?";
        int tenantId = property.getTenantId();
        String description = property.getDescription();
        String address = property.getAddress();
        int propertyId = property.getPropertyId();
        try {
            jdbcTemplate.update(sql, tenantId, description, address, propertyId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    private Property mapRowToProperty(SqlRowSet rs) {
        Property property = new Property();
        property.setPropertyId(rs.getInt("property_id"));
        property.setLandlordId(rs.getInt("landlord_id"));
        property.setTenantId(rs.getInt("tenant_id"));
        property.setDescription(rs.getString("description"));
        property.setAddress(rs.getString("image_url"));
        return property;
    }
}
