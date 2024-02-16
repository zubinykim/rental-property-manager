package com.techelevator.dao;

import com.techelevator.model.DTOs.AddPropertyDTO;
import com.techelevator.model.tables.PropertyImage;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcPropertyImageDao implements PropertyImageDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPropertyImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addImage(int propertyId, String imageUrl) {
        String sql = "insert into property_images (property_id, image_url) values (?, ?) returning image_id";
        return jdbcTemplate.queryForObject(sql, int.class, propertyId, imageUrl);
    }


}
