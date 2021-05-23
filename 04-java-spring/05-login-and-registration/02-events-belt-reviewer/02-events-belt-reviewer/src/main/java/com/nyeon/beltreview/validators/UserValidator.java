package com.nyeon.beltreview.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nyeon.beltreview.model.User;
import com.nyeon.beltreview.services.UserService;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserService uService;
	
	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	@Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if(this.uService.emailExist(user.getEmail())) {
        	errors.rejectValue("email", "Unique", "The email address is already in use!");
        }
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
