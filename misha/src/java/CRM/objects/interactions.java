/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.objects;

import java.io.Serializable;
/**
 *
 * @author calho
 */
public class interactions implements Serializable {
    
    private int interaction_id;
    private String first_name;
    private String last_name;
    private String status;
    private String method_of_contact;
    private String email;
    private String phone;

    public int getInteraction_id() {
        return interaction_id;
    }

    public void setInteraction_id(int interaction_id) {
        this.interaction_id = interaction_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod_of_contact() {
        return method_of_contact;
    }

    public void setMethod_of_contact(String method_of_contact) {
        this.method_of_contact = method_of_contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}