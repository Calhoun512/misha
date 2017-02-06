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
        String sql = "INSERT INTO CLIENTS (first_name, last_name, address_1, address_2, address_3, city, state, zip, phone, fax, email, date_of_hire, file_number, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {clients.getFirst_name(), clients.getLast_name(), clients.getAddress_1(), clients.getAddress_2(), clients.getAddress_3(), clients.getCity(), clients.getState(), clients.getZip(), clients.getPhone(), clients.getFax(), clients.getEmail(), clients.getDate_of_hire(), clients.getFile_number(), clients.getStatus()};
        return template.update(sql, values);
    }
    
    public int update(clients clients){
        String sql = "UPDATE clients SET first_name = ?, last_name = ?, address_1 = ?, address_2 = ?, address_3 = ?, city = ?, state = ?, zip = ?, phone = ?, fax = ?, email = ?, date_of_hire = ?, file_number = ?, status = ? WHERE client_id = ?";
        Object[] values = {clients.getFirst_name(), clients.getLast_name(), clients.getAddress_1(), clients.getAddress_2(), clients.getAddress_3(), clients.getCity(), clients.getState(), clients.getZip(), clients.getPhone(), clients.getFax(), clients.getEmail(), clients.getDate_of_hire(), clients.getFile_number(), clients.getStatus()};
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
    
                return c;
                        
            }
        });
    }
    
    public clients getClientById(int client_id){
        String sql = "SELECT * FROM client WHERE client_id = ?";
        return template.queryForObject(sql, new Object[]{client_id}, new BeanPropertyRowMapper<clients>(clients.class)); 
    }
    
       public List<clients> getClientsByPage(int start, int total){
       String sql = "SELECT * FROM client LIMIT " + (start - 1) + "," + total;
       return template.query(sql,new RowMapper<clients>(){
           public clients mapRow(ResultSet rs,int row) throws SQLException{
               clients c = new clients();
                c.setId(rs.getInt(1));
                c.setFirst_name(rs.getString(2));
                c.setLast_name(rs.getString(3));
                c.setAddress_1(rs.getString(4));
                c.setAddress_2(rs.getString(5));
                c.setAddress_3(rs.getString(6));
                c.setCity(rs.getString(7));
                c.setState(rs.getString(8));
                c.setZip(rs.getString(9));
                c.setPhone(rs.getString(10));
                c.setFax(rs.getString(11));
                c.setEmail(rs.getString(12));
                c.setDate_of_hire(rs.getString(13));
                c.setFile_number(rs.getString(14));
                c.setStatus(rs.getString(15));
                return c;
               
           }
    
       });
           
}
        public int getClientCount(){
          String sql = "SELECT COUNT(client_id) AS rowcount FROM clients";
          SqlRowSet rs = template.queryForRowSet(sql);
          if(rs.next()){
            return rs.getInt("rowcount");
          }
          
          return 1;
        }
}
