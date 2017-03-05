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
    
    public int save(Users users){
        String sql = "INSERT INTO users (username, password) values(?, md5(?))";
        Object[] values = {users.getUsername(), users.getPassword()};
        int r = template.update(sql,values);
        sql = "INSERT INTO user_roles (username, role) VALUES (?, ?)";
        for (String role: users.getRoles()) {
            Object[] role_values = {users.getUsername(), role};
            template.update(sql, role_values);
            
        }
        return r;
    }
}
