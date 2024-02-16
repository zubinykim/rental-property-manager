package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcMaintenanceRequestDao implements MaintenanceRequestDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceRequestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
