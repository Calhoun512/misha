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

import CRM.objects.clients;


/**
 *
 * @author calho
 */
public class ClientsDAO {
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    /**
     *
     * @param clients
     * @return
     */
    public int save(clients clients){
        String sql = "INSERT INTO CLIENTS (first_name, last_name, address_1, address_2, address_3, city, state, zip, phone, fax, email, date_of_hire, file_number) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {clients.getFirst_name(), clients.getLast_name(), clients.getAddress_1(), clients.getAddress_2(), clients.getAddress_3(), clients.getCity(), clients.getState(), clients.getZip(), clients.getPhone(), clients.getFax(), clients.getEmail(), clients.getDate_of_hire(), clients.getFile_number()};
        return template.update(sql, values);
    }
    
    public int update(clients clients){
        String sql = "UPDATE clients SET first_name = ?, last_name = ?, address_1 = ?, address_2 = ?, address_3 = ?, city = ?, state = ?, zip = ?, phone = ?, fax = ?, email = ?, date_of_hire = ?, file_number = ? WHERE client_id = ?";
        Object[] values = {clients.getFirst_name(), clients.getLast_name(), clients.getAddress_1(), clients.getAddress_2(), clients.getAddress_3(), clients.getCity(), clients.getState(), clients.getZip(), clients.getPhone(), clients.getFax(), clients.getEmail(), clients.getDate_of_hire(), clients.getFile_number()};
        return template.update(sql, values);                       
    }
    
    public int delete(int client_id){
        String sql = "DELETE FROM clients WHERE client_id = ?";
        Object[] values = {client_id};
        return template.update(sql, values);
    }
    
    public List<clients> getClientsList(){
        return template.query("SELECT * FROM clients", new RowMapper<clients>(){
            public clients mapRow(ResultSet rs, int row) throws SQLException{
                clients c = new clients();
                c.setId(rs.getInt("client_id"));
                c.setFirst_name(rs.getString("first_name"));
                c.setLast_name(rs.getString("last_name"));
                c.setAddress_1(rs.getString("address_1"));
                c.setAddress_2(rs.getString("address_2"));
                c.setAddress_3(rs.getString("address_3"));
                c.setCity(rs.getString("city"));
                c.setState(rs.getString("state"));
                c.setZip(rs.getString("zip"));
                c.setPhone(rs.getString("phone"));
                c.setFax(rs.getString("fax"));
                c.setEmail(rs.getString("email"));
                c.setDate_of_hire(rs.getString("date_of_hire"));
                c.setFile_number(rs.getString("file_number"));
                return c;
                
                
            }
        });
    }
    
    
    
}
