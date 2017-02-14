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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "client.artist.name.required");
        
        clients clients = (clients)target;
		if(clients.getFirst_name().length() > 45) {
			errors.rejectValue("name","clients.first_name.length");
		}
        
        if (!clients.getFirst_name().matches("^[A-Za-z0-9]*$")) {
            errors.rejectValue("name","clients.first_name.pattern");
        }
	}
}