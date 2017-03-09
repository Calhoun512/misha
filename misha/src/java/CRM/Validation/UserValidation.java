/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.Validation;

import CRM.objects.users;
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
public class UserValidation implements Validator{
    private static final Logger logger = Logger.getLogger(UserValidation.class.getName());
    
    @Override
    public boolean supports(Class<?> clazz) {
            return users.class.isAssignableFrom(clazz);
}
    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Users.username.required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Users.password.required");
    }
    
}
