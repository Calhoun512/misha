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

import CRM.objects.Users;

/**
 *
 * @author calho
 */
public class UsersDAO {
    JdbcTemplate template;
    
    public void setTemplate(JdbcTemplate template){
        this.template = template;
    }
    
    public int save(Users users){
        String sql = "INSERT INTO USERS (username, password, user_level) values (?, ?, ?)";
        Object[] values = {users.getUsername(), users.getPassword(), users.getUser_level()};
        return template.update(sql, values);
    }
    
    public int update(Users users){
        String sql = "UPDATE users SET username = ?, password = ?, user_level = ? WHERE user_id = ?";
        Object[] values = {users.getUsername(), users.getPassword(), users.getUser_level()};
        return template.update(sql, values);
    }
    
    public int delete(int user_id){
        String sql = "DELETE FROM users WHERE user_id = ?";
        Object[] values = {user_id};
        return template.update(sql, values);
        
    }
    
    public List<Users> getUsersList(){
        return template.query("SELECT * FROM users", new RowMapper<Users>(){
            public Users mapRow(ResultSet rs, int row) throws SQLException{
                Users u = new Users();
                u.setUser_id(rs.getInt("User_id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setUser_level(rs.getString("user_level"));
                
                return u;
            }
        });
    }
    
    public Users getUsersById(int user_id){
        String sql = "SELECT * FROM users WHERE user_id = ?";
        return template.queryForObject(sql, new Object[]{user_id}, new BeanPropertyRowMapper<Users>(Users.class));
    }
   
    public List<Users> getUsersByPage(int start, int total){
        String sql = "SELECT * FROM users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Users>(){
            public Users mapRow(ResultSet rs, int row) throws SQLException{
                Users u = new Users();
                u.setUser_id(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setUser_level(rs.getString(4));
                return u;
            }
        });
    }
    
    public int getUserCount(){
        String sql = "SELECT COUNT (User_id) AS rowcount FROM users";
        SqlRowSet rs = template.queryForRowSet(sql);
        if(rs.next()){
            return rs.getInt("rowcount");
        }
        
        return 1;
    }
}
