/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.Validation;

import CRM.objects.interactions;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author calho
 */
@Component
public class InteractionsValidation implements Validator {
    
    private static final Logger logger = Logger.getLogger(InteractionsValidation.class.getName());
    
        @Override
        public boolean supports(Class<?> clazz) {
                return interactions.class.isAssignableFrom(clazz);
        }
        
        @Override
        public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "interactions.first_name.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "interactions.last_name.required");
            ValidationUtils.rejectIfEmpty(errors, "status", "interactions.status.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "method_of_contact", "interactions.method_of_contact.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "interactions.email.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "interactions.phone.required");
            ValidationUtils.rejectIfEmpty(errors, "notes", "interactions.notes.required");
        
    
    interactions interactions = (interactions)target;
        if(interactions.getFirst_name().length() > 45) {
            errors.rejectValue("first_name", "interactions.first_name.length");
        }
        
        if(interactions.getLast_name().length() > 45) {
            errors.rejectValue("last_name", "interactions.last_name.length");
        }
        if(interactions.getStatus().length() > 45) {
            errors.rejectValue("status", "interactions.status.length");
        }
        if(interactions.getMethod_of_contact().length() > 45) {
            errors.rejectValue("method_of_contact", "interactions.method_of_contact.length");
        }
        if(interactions.getEmail().length() > 64) {
            errors.rejectValue("email", "interactions.email.length");
        }
        if(interactions.getPhone().length() > 16) {
            errors.rejectValue("phone", "interactions.phone.length");
        }
    if(interactions.getFirst_name() != null && !interactions.getFirst_name().matches("^[A-Za-z]{2,45}$")) {
        errors.rejectValue("first_name", "interactions.first_name.pattern");
    }
    if(interactions.getLast_name() != null && !interactions.getLast_name().matches("^[A-Za-z]{2,45}$")) {
        errors.rejectValue("last_name", "interactions.last_name.pattern");
    }
    if(!interactions.getEmail().matches("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$")) {
            errors.rejectValue("email", "clients.email.pattern");
    }
    if(!interactions.getPhone().matches("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$")) {
        errors.rejectValue("phone", "interactions.phone.pattern");
    }
}
        
}
