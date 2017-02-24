/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.Validation;

import CRM.objects.prospects;
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
public class ProspectsValidation implements Validator {
    
    private static final Logger logger = Logger.getLogger(ProspectsValidation.class.getName());
    
        @Override
        public boolean supports(Class<?> clazz) {
                return prospects.class.isAssignableFrom(clazz);
        }
        @Override
        public void validate(Object target, Errors errors)  {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "First Name", "prospects.first_name.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Last Name", "prospects.last_name.required");
            ValidationUtils.rejectIfEmpty(errors, "Address 1", "prospects.address_1.required");
            ValidationUtils.rejectIfEmpty(errors, "Address 2", "prospects.address_2.required");
            ValidationUtils.rejectIfEmpty(errors, "Address 3", "prospects.address_3.required");
            ValidationUtils.rejectIfEmpty(errors, "City", "prospects.city.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "State", "prospects.state.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Zip", "prospects.zip.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Phone", "prospects.phone.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Fax", "prospects.fax.required");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Email", "prospects.email.required");
            
    prospects prospects = (prospects)target;
    if(prospects.getFirst_name().length() > 45) {
			errors.rejectValue("First Name","prospects.first_name.length");
		}
                if(prospects.getLast_name().length() > 45) {
                        errors.rejectValue("Last Name", "prospects.last_name.length");
                }
                if(prospects.getAddress_1().length() > 128) {
                    errors.rejectValue("Address 1", "prospects.address_1.length");
                }
                if(prospects.getAddress_2().length() > 128) {
                    errors.rejectValue("Address_2", "prospects.address_2.length");
                }
                if(prospects.getAddress_3().length() > 128) {
                    errors.rejectValue("Address_3", "prospects.address_3.length");
                }
                if(prospects.getCity().length() > 64) {
                    errors.rejectValue("City", "prospects.city.length");
                }
                if(prospects.getState().length() > 2) {
                    errors.rejectValue("State", "prospects.state.length");
                }
                if(prospects.getZip().length() > 16) {
                    errors.rejectValue("ZIP", "prospects.zip.length");
                }
                if(prospects.getPhone().length() > 16) {
                    errors.rejectValue("Phone", "prospects.phone.length");
                }
                if(prospects.getFax().length() > 16) {
                    errors.rejectValue("Fax", "prospects.fax.length");
                }
                if(prospects.getEmail().length() > 45) {
                    errors.rejectValue("Email", "prospects.email.length");
                }
        
        if (!prospects.getFirst_name().matches("^[A-Za-z ]{2,45}$/")) {
            errors.rejectValue("First Name","prospects.first_name.pattern");
        }
        if (!prospects.getLast_name().matches("[^A-Za-z0-9_'-]{2,45}$/")) {
            errors.rejectValue("Last Name", "prospects.last_name.pattern");
        }
        if (!prospects.getAddress_1().matches("\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?")) {
            errors.rejectValue("Address_1", "prospects.address_1.pattern");
        }
        if (!prospects.getAddress_2().matches("\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?")) {
            errors.rejectValue("Address_2", "prospects.address_2.pattern");
	}
        if (!prospects.getAddress_3().matches("\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?")) {
            errors.rejectValue("Address_3", "prospects.address_3.pattern");
        }
        if (!prospects.getCity().matches("(?:[A-Z][a-z.-]+[ ]?)+")) {
            errors.rejectValue("city", "prospects.city.pattern");
        }
        if (!prospects.getState().matches("^(?-i:A[LKSZRAEP]|C[AOT]|D[EC]|F[LM]|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEHINOPST]|N[CDEHJMVY]|O[HKR]|P[ARW]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$")) {
            errors.rejectValue("State", "prospects.state.pattern");
        }
        if (!prospects.getZip().matches("^\\b\\d{5}(?:-\\d{4})?\\b$")){
            errors.rejectValue("Zip", "prospects.zip.pattern");
        }
        if (!prospects.getPhone().matches("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$")) {
            errors.rejectValue("Phone", "prospects.phone.pattern");
        }
        if (!prospects.getFax().matches("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$")) {
            errors.rejectValue("Fax", "prospects.fax.pattern");
        }
        if (!prospects.getEmail().matches("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$")) {
            errors.rejectValue("Email", "prospects.email.pattern");
        }
        
        
        }
        
 }
            
        
    

