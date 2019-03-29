package com.cognizant.pts.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.pts.entity.Clerk;
import com.cognizant.pts.service.ClerkServiceImpl;

@Component("ClerkValidator")
public class ClerkValidator implements Validator {
	
	@Autowired
	private ClerkServiceImpl clerkService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Clerk.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "clerkId", "clerkId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "contactNumber.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "addressLine1.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine2", "addressLine2.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "zipCode.required");
		

		
		
	}
}
