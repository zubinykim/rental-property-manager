package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.tables.Lease;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcLeaseDao implements LeaseDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcLeaseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Lease getLeaseById(int leaseId) {
        Lease lease = null;
        String sql = "select lease_id, property_id, tenant_id, rent_amount, rent_due_date, rent_status from leases where lease_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leaseId);
            if (results.next()) {
                lease = mapRowToLease(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return lease;
    }

    @Override
    public List<Lease> getLeasesByLandlordId(int landlordId) {
        List<Lease> leases = new ArrayList<>();
        String sql = "select lease_id, leases.property_id, leases.tenant_id, rent_amount, rent_due_date, rent_status from leases join properties on leases.property_id = properties.property_id where landlord_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Lease lease = mapRowToLease(results);
                leases.add(lease);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return leases;
    }

    private Lease mapRowToLease(SqlRowSet rs) {
        Lease lease = new Lease();
        lease.setLeaseId(rs.getInt("lease_id"));
        lease.setPropertyId(rs.getInt("property_id"));
        lease.setTenantId(rs.getInt("tenant_id"));
        lease.setRentAmount(rs.getDouble("rent_amount"));
        lease.setRentDueDate(rs.getDate("rent_due_date"));
        lease.setRentStatus(rs.getString("rent_status"));
        return lease;
    }
}
