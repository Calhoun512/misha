/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.objects;

import java.util.List;
import java.util.Map;
import java.io.Serializable;


/**
 *
 * @author calho
 */
public class Users implements Serializable {
    private int user_id;
    private String username;
    private String password;
    private String user_level;

    
    private Users user;
    private Map<Integer, String> users;
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    public Map<Integer, String> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, String> users) {
        this.users = users;
    }
            

    public Users getUser() {
        return user;
    }
    
    public void setUser(Users user){
        this.user = user;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("User ID: " + this.user_id);
        buffer.append("Username: " + this.username);
        buffer.append("Password: " + this.password);
        buffer.append("User Level: " + this.user_level);
        return buffer.toString();
    }
    
}
