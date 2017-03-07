/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.repository;

import CRM.objects.clients;
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
        String sql = "INSERT INTO INTERACTIONS (first_name, last_name, status, method_of_contact, email, phone, notes, contact_date, client_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] values = {interactions.getFirst_name(), interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), interactions.getEmail(), interactions.getPhone(), interactions.getNotes(), interactions.getContact_date(), interactions.getClient_id()};
        return template.update(sql, values);
                
        }
    
    public int update (interactions interactions){
        String sql = "UPDATE interactions SET first_name = ?, last_name = ?, status = ?, method_of_contact = ?, email = ?, phone = ?, notes = ?, contact_date = ?, client_id = ? WHERE interaction_id = ?";
        Object[] values = {interactions.getFirst_name(), interactions.getLast_name(), interactions.getStatus(), interactions.getMethod_of_contact(), interactions.getEmail(), interactions.getPhone(), interactions.getNotes(), interactions.getContact_date(), interactions.getClient_id()};
        return template.update(sql, values);
    
    }
    public int delete (int interaction_id){
        String sql = "DELETE FROM interactions WHERE interaction_id = ?";
        Object[] values = {interaction_id};
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
    
    public interactions getInteractionsById (int interaction_id){
        String sql = "SELECT * from interactions WHERE interaction_id = ?";
        return template.queryForObject(sql, new Object[]{interaction_id}, new BeanPropertyRowMapper<interactions>(interactions.class));
    }
    
    public List<interactions> getInteractionsByPage(int start, int total){
       String sql = "SELECT interactions.interaction_id, interactions.client_id, interactions.contact_date, interactions.first_name, interactions.last_name, interactions.notes, clients.client_id  " + 
               "FROM Interactions AS interactions " +
               "INNER JOIN clients AS clients ON clients.client_id = interactions.client_id " +
               "ORDER BY clients.last_name, interactions.contact_date " +
               "LIMIT " + (start - 1) + "," + total; 
       return template.query(sql,new RowMapper<interactions>(){
           public interactions mapRow(ResultSet rs,int row) throws SQLException{
               interactions i = new interactions();
               i.setInteraction_id(rs.getInt(1));
               i.setFirst_name(rs.getString(2));
               i.setLast_name(rs.getString(3));
               i.setStatus(rs.getString(4));
               i.setMethod_of_contact(rs.getString(5));
               i.setEmail(rs.getString(6));
               i.setPhone(rs.getString(7));
               i.setNotes(rs.getString(8));
               i.setContact_date(rs.getString(9));
               i.setClient_id(rs.getInt(10));
               
               clients clients = new clients();
               clients.setId(rs.getInt(1));
               clients.setLast_name(rs.getString(2));
               clients.setFirst_name(rs.getString(3));
               
               return i;
               
            }
    
       });
    }
    
    public int getInteractionsCount(){
        String sql = "SELECT COUNT(interaction_id) AS rowcount FROM interactions";
        SqlRowSet rs = template.queryForRowSet(sql);
        if (rs.next()){
            return rs.getInt("rowcount");
        }
        return 1;
    }
}


