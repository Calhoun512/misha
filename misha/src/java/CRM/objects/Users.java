/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.objects;

import java.util.List;
import java.util.Map;
import java.io.Serializable;
import java.util.LinkedHashMap;


/**
 *
 * @author calho
 */
public class Users implements Serializable {
    
    private String username;
    private String password;
    private List<String> roles;
    private Map<String, String> rolemap;

    
    public Users(){
        this.rolemap = new LinkedHashMap<String, String>();
        this.rolemap.put("ROLE_USER", "User");
        this.rolemap.put("ROLE_ADMIN", "Administrator");
        
    }
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public Map<String, String> getRolemap(){
        return this.rolemap;
    }
    
    public List<String> getRoles(){
        return roles;
    }
    
    public void setRoles(List<String> roles){
        this.roles = roles;
    }
}


