/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.objects;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author calho
 */
public class clients implements Serializable {
    
    private int client_id;
    private String first_name;
    private String last_name;
    private String address_1;
    private String address_2;
    private String address_3;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String fax;
    private String email;
    private String date_of_hire;
    private String file_number;
    private String status;
    private Map<String, String> statesMap;
    private Map<String, String> statusMap;
    
    public Map<String, String> getStatesMap() {
        this.statesMap = new LinkedHashMap<String, String>();
        this.statesMap.put("AL - Alabama", "AL - Alabama");
        this.statesMap.put("AK - Alaska", "AK - Alaska");
        this.statesMap.put("AZ - Arizona", "AZ - Arizona");
        this.statesMap.put("AR - Arkansas", "AR - Arkansas");
        this.statesMap.put("CA - California", "CA - California");
        this.statesMap.put("CO - Colorado", "CO - Colorado");
        this.statesMap.put("DE - Delaware", "DE - Delaware");
        this.statesMap.put("FL - Florida", "FL - Florida");
        this.statesMap.put("GA - Georgia", "GA - Georgia");
        this.statesMap.put("HI - Hawaii", "HI - Hawaii");
        this.statesMap.put("ID - Idaho", "ID - Idaho");
        this.statesMap.put("IL - Illinois", "IL - Illinois");
        this.statesMap.put("IN - Indiana", "IN - Indiana");
        this.statesMap.put("IA - Iowa", "IA - Iowa");
        this.statesMap.put("KS - Kansas", "KS - Kansas");
        this.statesMap.put("KY - Kentucky", "KY - Kentucky");
        this.statesMap.put("LA - Louisiana", "LA - Louisiana");
        this.statesMap.put("ME - Maine", "ME - Maine");
        this.statesMap.put("MD - Maryland", "MD - Maryland");
        this.statesMap.put("MA - Massachusetts", "MA - Massachusetts");
        this.statesMap.put("MI - Michigan", "MI - Michigan");
        this.statesMap.put("MN - Minnesota", "MN - Minnesota");
        this.statesMap.put("MS - Mississippi:", "MS - Mississippi");
        this.statesMap.put("MO - Missouri", "MO - Missouri");
        this.statesMap.put("MT - Montana", "MT - Montana");
        this.statesMap.put("NE - Nebraska", "NE - Nebraska");
        this.statesMap.put("NV - Nevada", "NV - Nevada");
        this.statesMap.put("NH - New Hampshire", "NH - New Hampshire");
        this.statesMap.put("NJ - New Jersey", "NJ - New Jersey");
        this.statesMap.put("NM - New Mexico", "NM - New Mexico");
        this.statesMap.put("NY - New York", "NY - New York");
        this.statesMap.put("NC - North Carolina", "NC - North Carolina");
        this.statesMap.put("ND - North Dakota", "ND - North Dakota");
        this.statesMap.put("OH - Ohio", "OH - Ohio");
        this.statesMap.put("OK - Oklahoma", "OK - Oklahoma");
        this.statesMap.put("OR - Oregon", "OR - Oregon");
        this.statesMap.put("PA - Pennsylvania", "PA - Pennsylvania");
        this.statesMap.put("RI - Rhode Island", "RI - Rhode Island");
        this.statesMap.put("SC - South Carolina", "SC - South Carolina");
        this.statesMap.put("SD - South Dakota", "SD - South Dakota");
        this.statesMap.put("TN - Tennessee", "TN - Tennessee");
        this.statesMap.put("TX - Texas", "TX - Texas");
        this.statesMap.put("UT - Utah", "UT - Utah");
        this.statesMap.put("VT - Vermont", "VT - Vermont");
        this.statesMap.put("VA - Virginia", "VA - Virginia");
        this.statesMap.put("WA - Washington", "WA - Washington");
        this.statesMap.put("WV - West Virginia", "WV - West Virginia");
        this.statesMap.put("WI - Wisconsin", "WI - Wisconsin");
        this.statesMap.put("WY - Wyoming", "WY - Wyoming");
        this.statesMap.put("AS - American Samoa", "AS - American Samoa");
        this.statesMap.put("DC - District of Columbia", "DC - District of Columbia");
        this.statesMap.put("FM - Federated States of Micronesia", "FM - Federated States of Micronesia");
        this.statesMap.put("GU - Guam", "GU - Guam");
        this.statesMap.put("MH - Marshall Islands", "MH - Marshall Islands");
        this.statesMap.put("MP - Northern Mariana Islands", "MP - Northern Mariana Islands");
        this.statesMap.put("PW - Palau", "PW - Palau");
        this.statesMap.put("PR - Puerto Rico", "PR - Puerto Rico");
        this.statesMap.put("VI - Virgin Islands", "VI - Virgin Islands");
        this.statesMap.put("AE - Armed Forces Africa", "AE - Armed Forces Africa");
        this.statesMap.put("AA - Armed Forces Americas", "AA - Armed Forces Americas");
        this.statesMap.put("AE - Armed Forces Canada", "AE - Armed Forces Canada");
        this.statesMap.put("AE - Armed Forces Europe", "AE - Armed Forces Europe");
        this.statesMap.put("AE - Armed Forces Middle East", "AE - Armed Forces Middle East");
        this.statesMap.put("(AP - Armed Forces Pacific", "AP - Armed Forces Pacific");
        
        return statesMap;
    }
    
    public Map<String, String> getStatusMap(){
        this.statusMap = new LinkedHashMap<String, String>();
        this.statusMap.put("Active", "Active");
        this.statusMap.put("Inactive", "Inactive");
        this.statusMap.put("prospect", "Prospect");
        
        return statusMap;
    }
    

    public int getId() {
        return client_id;
    }

    public void setId(int id) {
        this.client_id = id;
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

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getAddress_3() {
        return address_3;
    }

    public void setAddress_3(String address_3) {
        this.address_3 = address_3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate_of_hire() {
        return date_of_hire;
    }

    public void setDate_of_hire(String date_of_hire) {
        this.date_of_hire = date_of_hire;
    }

    public String getFile_number() {
        return file_number;
    }

    public void setFile_number(String file_number) {
        this.file_number = file_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("ID: " + this.client_id + ";");
        buffer.append("First Name: " + first_name);
        buffer.append("Last Name: " + last_name);
        buffer.append("Address 1: " + address_1);
        buffer.append("Address 2: " + address_2);
        buffer.append("Address 3: " + address_3);
        buffer.append("City: " + city);
        buffer.append("State: " + state);
        buffer.append("Zip: " + zip);
        buffer.append("Phone: " + phone);
        buffer.append("Fax: " + fax);
        buffer.append("Email: " + email);
        buffer.append("Date of Hire: " + date_of_hire);
        buffer.append("File Number: " + file_number);
        buffer.append("Status: " + status);
        
        return buffer.toString();
    }
    
}
