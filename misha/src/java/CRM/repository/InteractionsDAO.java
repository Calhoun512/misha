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

import CRM.objects.interactions;
/**
 *
 * @author calho
 */
public class InteractionsDAO {
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save (interactions interactions){
        String sql = "INSERT INTO INTERACTIONS (first_name, last_name, status, method_of_contact, email, phone, notes) values (?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {interactions.getFirst_name(), interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), interactions.getEmail(), interactions.getPhone(), interactions.getNotes()};
        return template.update(sql, values);
                
        }
    
    public int update (interactions interactions){
        String sql = "UPDATE interactions SET first_name = ?, last_name = ?, status = ?, method_of_contact = ?, email = ?, phone = ?, notes = ? WHERE interaction_id = ?";
        Object[] values = {interactions.getFirst_name(), interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), interactions.getEmail(), interactions.getPhone(), interactions.getNotes()};
        return template.update(sql, values);
    
    }
    public int delete (interactions interactions){
        String sql = "DELETE FROM interactions WHERE interaction_id = ?";
        return template.update(sql);
    }
    
    public List<interactions> getInteractionsList(){
        return template.query("SELECT * FROM interactions", new RowMapper<interactions>(){
            public interactions mapRow(ResultSet rs, int row) throws SQLException{
                interactions i = new interactions();
                i.setInteraction_id(rs.getInt("interaction_id"));
                i.setFirst_name(rs.getString("first_name"));
                i.setLast_name(rs.getString("last_name"));
                i.setNotes(rs.getString("notes"));
                
                return i;
                
            }
        });
    }
    
    public interactions getInteractionById (int interaction_id){
        String sql = "SELECT * from client WHERE client_id = ?";
        return template.queryForObject(sql, new Object[]{interaction_id}, new BeanPropertyRowMapper<interactions>(interactions.class));
    }
    
    public List<interactions> getClientsByPage(int start, int total){
       String sql = "SELECT * FROM client LIMIT " + (start - 1) + "," + total;
       return template.query(sql,new RowMapper<interactions>(){
           public interactions mapRow(ResultSet rs,int row) throws SQLException{
               interactions i = new interactions();
               i.setInteraction_id(rs.getInt("interaction_id"));
               i.setFirst_name(rs.getString("first_name"));
               i.setLast_name(rs.getString("last_name"));
               i.setStatus(rs.getString("status"));
               i.setMethod_of_contact(rs.getString("method_of_contact"));
               i.setEmail(rs.getString("email"));
               i.setPhone(rs.getString("phone"));
               i.setNotes(rs.getString("notes"));
               return i;
               
            }
    
       });
    }
    
    
    

}


