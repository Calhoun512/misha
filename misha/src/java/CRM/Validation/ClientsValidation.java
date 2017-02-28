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
                ValidationUtils.rejectIfEmpty(errors, "Address 1", "clients.address_1.required");
                ValidationUtils.rejectIfEmpty(errors, "City", "clients.city.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "State", "clients.state.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Zip", "clients.zip.required");
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
                if(clients.getState().length() > 2) {
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
        
        if (!clients.getFirst_name().matches("^[A-Za-z ]{2,45}$/")) {
            errors.rejectValue("First Name","clients.first_name.pattern");
        }
        if (!clients.getLast_name().matches("[^A-Za-z0-9_'-]{2,45}$/")) {
            errors.rejectValue("Last Name", "clients.last_name.pattern");
        }
        if (!clients.getAddress_1().matches("\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?")) {
            errors.rejectValue("Address_1", "clients.address_1.pattern");
        }
        if (!clients.getAddress_2().matches("\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?")) {
            errors.rejectValue("Address_2", "clients.address_2.pattern");
	}
        if (!clients.getAddress_3().matches("\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?")) {
            errors.rejectValue("Address_3", "clients.address_3.pattern");
        }
        if (!clients.getCity().matches("(?:[A-Z][a-z.-]+[ ]?)+")) {
            errors.rejectValue("city", "clients.city.pattern");
        }
        if (!clients.getState().matches("^(?-i:A[LKSZRAEP]|C[AOT]|D[EC]|F[LM]|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEHINOPST]|N[CDEHJMVY]|O[HKR]|P[ARW]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$")) {
            errors.rejectValue("State", "clients.state.pattern");
        }
        if (!clients.getZip().matches("^\\b\\d{5}(?:-\\d{4})?\\b$")){
            errors.rejectValue("Zip", "clients.zip.pattern");
        }
        if (!clients.getPhone().matches("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$")) {
            errors.rejectValue("Phone", "clients.phone.pattern");
        }
        if (!clients.getFax().matches("^(?:(?:\\+?1\\s*(?:[.-]\\s*)?)?(?:\\(\\s*([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9])\\s*\\)|([2-9]1[02-9]|[2-9][02-8]1|[2-9][02-8][02-9]))\\s*(?:[.-]\\s*)?)?([2-9]1[02-9]|[2-9][02-9]1|[2-9][02-9]{2})\\s*(?:[.-]\\s*)?([0-9]{4})(?:\\s*(?:#|x\\.?|ext\\.?|extension)\\s*(\\d+))?$")) {
            errors.rejectValue("Fax", "clients.fax.pattern");
        }
        if (!clients.getEmail().matches("^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])$")) {
            errors.rejectValue("Email", "clients.email.pattern");
        }
        if (!clients.getDate_of_hire().matches("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)")) {
            errors.rejectValue("Date of Hire", "clients.date_of_hire.pattern");
        }
        
        }
        
 }