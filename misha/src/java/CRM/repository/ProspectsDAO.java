/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import CRM.objects.prospects;
/**
 *
 * @author calho
 */
public class ProspectsDAO {
    
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(prospects prospects){
        String sql = "INSERT INTO prospects (first_name, last_name, address_1, address_2, address_3, city, state, zip, phone, fax, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {prospects.getFirst_name(), prospects.getLast_name(), prospects.getAddress_1(), prospects.getAddress_2(), prospects.getAddress_3(), prospects.getCity(), prospects.getState(), prospects.getZip(), prospects.getPhone(), prospects.getFax(), prospects.getEmail()};
        return template.update(sql, values);
    }
    
    public int update(prospects prospects){
        String sql = "UPDATE prospects SET first_name = ?, last_name = ?, address_1 = ?, address_2 = ?, address_3 = ?, city = ?, state = ?, zip = ?, phone = ?, fax = ?, email = ?";
        Object[] values = {prospects.getFirst_name(), prospects.getLast_name(), prospects.getAddress_1(), prospects.getAddress_2(), prospects.getAddress_3(), prospects.getCity(), prospects.getState(), prospects.getZip(), prospects.getPhone(), prospects.getFax(), prospects.getEmail()};
        return template.update(sql, values);
    }
    
    
    
}
