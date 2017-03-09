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
import java.util.logging.Logger;

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
    
    public int save(Users Users){
        String sql = "INSERT INTO Users (username, password) values(?, md5(?))";
        Object[] values = {Users.getUsername(), Users.getPassword()};
        int r = template.update(sql,values);
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        for (String role: Users.getRoles()) {
            Object[] role_values = {Users.getUsername(), role};
            template.update(sql, role_values);
            
        }
        return r;
    }

    public Users getUsersByUsername(String username) {
       String sql = "SELECT *  FROM Users WHERE username = ?";
       return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<Users>(Users.class));
        
    }

    public int getUserCount() {
        String sql = "SELECT COUNT(username) AS rowcount FROM users";
        SqlRowSet rs = template.queryForRowSet(sql);

        if (rs.next()) {
            return rs.getInt("rowcount");
        }

        return 1;
    }
    

    public List<Users> getUsersByPage(int start, int total) {
        String sql = "SELECT * FROM users LIMIT " + (start - 1) + "," + total;
        return template.query(sql, new RowMapper<Users>() {
            public Users mapRow(ResultSet rs, int row) throws SQLException {
                Users u = new Users();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setEnabled(rs.getInt(3));
                u.setName(rs.getString(4));
                return u;
            }
        });
        
    }

    public int update(Users users) {
        String  sql = "DELETE From user_roles WHERE username = ?";
        Object[] delete = {users.getUsername()};
        template.update(sql, delete);
        
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        
        for (String rolelist: users.getRolelist()) {
            Object[] role_values = {users.getUsername(), rolelist};
            
           
            
            template.update(sql, role_values);
        
    }
        
        
         sql = "UPDATE users SET  `password` = md5(?), enabled = ?, name = ?"
                + "	   WHERE username = ?";
        Object[] values = {users.getPassword(), users.getEnabled(), users.getName(), users.getUsername()};
        int r = template.update(sql, values);
        
        
     return r; 
    }

    public int delete(Users Users) {
        String sql = "DELETE FROM users WHERE username = ?";
        Object[] values = {Users.getUsername()};
        return template.update(sql, values);
    }

       public Users getUsersbyUsername(String username) {
        String sql = "SELECT *  FROM users WHERE username = ?";
        return template.queryForObject(sql, new Object[]{username}, new BeanPropertyRowMapper<Users>(Users.class));
        }
       
}