/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.stereotype.Component;

import CRM.objects.clients;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@Component
public class ClientsValidation implements Validator {
    
    private static final Logger logger = Logger.getLogger(ClientsValidation.class.getName());

	@Override
	public boolean supports(Class<?> clazz) {
		return clients.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "First Name", "clients.first_name.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Last Name", "clients.last_name.required");
                ValidationUtils.rejectIfEmpty(errors, "Address 1", "clients.Address_1.required");
                ValidationUtils.rejectIfEmpty(errors, "Address 2", "clients.Address_2.required");
                ValidationUtils.rejectIfEmpty(errors, "Address 3", "clients.Address_3.required");
                ValidationUtils.rejectIfEmpty(errors, "City", "clients.city.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "State", "clients.state.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ZIP", "clients.zip.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Phone", "clients.phone.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Fax", "clients.fax.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email", "clients.email.required");
                ValidationUtils.rejectIfEmpty(errors, "Date of Hire", "clients.date_of_hire");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "File Number", "clients.file_number.required");
                ValidationUtils.rejectIfEmpty(errors, "Status", "clients.status.required");
                
        
        clients clients = (clients)target;
		if(clients.getFirst_name().length() > 45) {
			errors.rejectValue("First Name","clients.first_name.length");
		}
                if(clients.getLast_name().length() > 45) {
                        errors.rejectValue("Last Name", "clients.last_name.length");
                }
                if(clients.getAddress_1().length() > 128) {
                    errors.rejectValue("Address 1", "clients.address_1.length");
                }
                if(clients.getAddress_2().length() > 128) {
                    errors.rejectValue("Address_2", "clients.address_2.length");
                }
                if(clients.getAddress_3().length() > 128) {
                    errors.rejectValue("Address_3", "clients.address_3.length");
                }
                if(clients.getCity().length() > 64) {
                    errors.rejectValue("City", "clients.city.length");
                }
                if(clients.getState().length() > 45) {
                    errors.rejectValue("State", "clients.state.length");
                }
                if(clients.getZip().length() > 16) {
                    errors.rejectValue("ZIP", "clients.zip.length");
                }
                if(clients.getPhone().length() > 16) {
                    errors.rejectValue("Phone", "clients.phone.length");
                }
                if(clients.getFax().length() > 16) {
                    errors.rejectValue("Fax", "clients.fax.length");
                }
                if(clients.getEmail().length() > 45) {
                    errors.rejectValue("Email", "clients.email.length");
                }
                if(clients.getDate_of_hire().length() > 45) {
                    errors.rejectValue("Date of Hire", "clients.date_of_hire.length");
                }
                if(clients.getFile_number().length() > 45) {
                    errors.rejectValue("File Number", "clients.file_number.length");
                }
                if(clients.getStatus().length() > 45) {
                    errors.rejectValue("Status", "clients.status.length");
                }
        
        if (!clients.getFirst_name().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name","clients.first_name.pattern");
        }
	}
}