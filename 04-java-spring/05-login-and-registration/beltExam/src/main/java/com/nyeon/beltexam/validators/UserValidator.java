package com.nyeon.beltexam.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.nyeon.beltexam.model.User;
import com.nyeon.beltexam.repository.UserRepository;

@Component
public class UserValidator {

	@Autowired
	private UserRepository uRepo;
	
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if(this.uRepo.existsByEmail(user.getEmail())) {
        	errors.rejectValue("email", "Unique", "The email address is already in use!");
        }
        
        if (!user.getPassword().equals(user.getPasswordConfirmation())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}