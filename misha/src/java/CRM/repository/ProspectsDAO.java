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
    
    public int delete(int prospects){
        String sql = "DELETE FROM prospects WHERE prospect_id = ?";
        return template.update(sql);
    }
    
    public List<prospects> getProspectsList(){
        return template.query("SELECT * FROM prospects", new RowMapper<prospects>(){
            public prospects mapRow(ResultSet rs, int row) throws SQLException{
                prospects p = new prospects();
                p.setProspect_id(rs.getInt("prospect_id"));
                p.setFirst_name(rs.getString("first_name"));
                p.setLast_name(rs.getString("last_name"));
                p.setPhone(rs.getString("phone"));
                p.setEmail(rs.getString("email"));
                
                return p;               
            }           
        });          
    }
        
    public prospects getProspectsById(int prospect_id){
        String sql = "SELECT * FROM prospects WHERE prospect_id = ?";
        return template.queryForObject(sql, new Object[]{prospect_id}, new BeanPropertyRowMapper<prospects>(prospects.class));
        
    }    
    
    public List<prospects> getProspectsByPage(int start, int total){
       String sql = "SELECT * FROM prospects LIMIT " + (start - 1) + "," + total;
       return template.query(sql,new RowMapper<prospects>(){
           public prospects mapRow(ResultSet rs,int row) throws SQLException{
               prospects p = new prospects();
               p.setProspect_id(rs.getInt(1));
               p.setFirst_name(rs.getString(2));
               p.setLast_name(rs.getString(3));
               p.setAddress_1(rs.getString(4));
               p.setAddress_2(rs.getString(5));
               p.setAddress_3(rs.getString(6));
               p.setCity(rs.getString(7));
               p.setState(rs.getString(8));
               p.setZip(rs.getString(9));
               p.setPhone(rs.getString(10));
               p.setFax(rs.getString(11));
               p.setEmail(rs.getString(12));
               
               return p;
           }
    
       });
    }
    
    public int getProspectCount(){
       String sql = "SELECT COUNT(prospect_id) AS rowcount FROM prospects";
       SqlRowSet rs = template.queryForRowSet(sql);
       if(rs.next()){
       return rs.getInt("rowcount");
          }
          
          return 1;
        }

}
    
