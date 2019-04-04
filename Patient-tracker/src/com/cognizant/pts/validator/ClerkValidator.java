package com.cognizant.pts.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.pts.entity.Clerk;
import com.cognizant.pts.model.ClerkModel;
import com.cognizant.pts.service.ClerkService;
import com.cognizant.pts.service.ClerkServiceImpl;

@Component("ClerkValidator")
public class ClerkValidator implements Validator {
	
	@Autowired
	private ClerkService clerkService;
	
	private Pattern pattern;
	private Matcher matcher;
	
	private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";
	
	String STRING_PATTERN = "[a-zA-Z]*$";
	String MOBILE_PATTERN="(^$|[0-9]{10})";
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ClerkModel.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	
		
		ClerkModel clerkModel= (ClerkModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
		pattern = Pattern.compile(STRING_PATTERN);
		matcher=pattern.matcher(clerkModel.getFirstName());
		if(!matcher.matches())
		{
			errors.rejectValue("firstName", "invalid.value");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		pattern = Pattern.compile(STRING_PATTERN);
		matcher=pattern.matcher(clerkModel.getLastName());
		if(!matcher.matches())
		{
			errors.rejectValue("lastName", "invalid.value");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "age.required");
		
		if(clerkModel.getAge()<=18 || clerkModel.getAge()>80)
		{
			errors.rejectValue("age", "invalid.value");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "contactNumber.required");
		
			Pattern contactNumber_pat= Pattern.compile("(0/91)?[7-9][0-9]{9}");
			if(contactNumber_pat.matcher(clerkModel.getContactNumber()).matches()==false)
		    errors.rejectValue("contactNumber", "contact.incorrect");
		
		
		
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "alternateContactNumber", "invalid.value");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "emailId.required");
		 pattern = Pattern.compile(EMAIL_PATTERN);
		matcher=pattern.matcher(clerkModel.getEmailId());
		if(!matcher.matches())
		{
			errors.rejectValue("emailId", "invalid.value");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine1", "addressLine1.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressLine2", "addressLine2.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "city.required");
		if(clerkModel.getCity().matches("^[a-zA-Z]*$")== false)
			errors.rejectValue("city", "invalid.value");
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "state.required");
		if(clerkModel.getState().matches("^[a-zA-Z]*$")== false)
			errors.rejectValue("city", "invalid.value");
			
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "zipCode.required");
		if(clerkModel.getZipCode()<100000 || clerkModel.getZipCode()>999999 )
		{
			errors.rejectValue("zipCode", "invalid.value");
		}
		
		System.out.println(errors);
		
	}
}
