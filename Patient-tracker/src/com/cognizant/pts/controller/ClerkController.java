package com.cognizant.pts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.entity.Clerk;
import com.cognizant.pts.service.ClerkService;
import com.cognizant.pts.validator.ClerkValidator;

@SessionAttributes("gender")

@Controller
public class ClerkController {
	
	@Autowired
	private ClerkValidator clerkValidator;
	
	@Autowired
	private ClerkService clerkService;
	
	
	
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public ModelAndView viewClerks()
	{
		List<Clerk> clerkList = clerkService.getAllClerks();
		ModelAndView mv= new ModelAndView();
		mv.addObject("clerkList",clerkList);
		mv.setViewName("viewclerks");
		return mv;
		
	}
	
	@RequestMapping(value="viewclerks.htm",method=RequestMethod.GET)
	public ModelAndView viewClerksAgain()
	{
		ModelAndView mv= new ModelAndView();
		List<Clerk> clerkList = clerkService.getAllClerks();
		
		mv.addObject("clerkList",clerkList);
		mv.setViewName("viewclerks");
		return mv;
		
	}
	
	@RequestMapping(value="addclerkform.htm",method=RequestMethod.GET)
	public ModelAndView loadClerkForm()
	{
		ModelAndView mv=new ModelAndView();
		List<String> genderList= new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Trans Gender");
		mv.addObject("gender", genderList);
		mv.setViewName("clerkform");
		return mv;
		
	}
	
	
	@RequestMapping(value="addclerk.htm",method=RequestMethod.GET)
    public ModelAndView persistView(@ModelAttribute("clerk")Clerk clerk,Errors errors)
    {
		ModelAndView mv= new ModelAndView();
		ValidationUtils.invokeValidator(clerkValidator,clerk,errors);
		if(errors.hasErrors())
		{
			mv.setViewName("clerkform");	
    }
		else{
			
			 boolean clerkPersist= clerkService.persistClerk(clerk);
			 
			 if(clerkPersist)
			 {
				 mv.addObject("status","Clerk successfully registered");
				 
			 }
			 
			 else{
				 mv.addObject("status","Clerk  registration failed");
				 
			 }
		
			 mv.setViewName("clerkform");
		}
		return mv;
}
	
	@ModelAttribute("clerk")
	public Clerk createCommandObject()
	{
		Clerk clerk = new Clerk();
		clerk.setClerkId("");
		clerk.setFirstName("Please enter name");
		clerk.setLastName("Please last name");
		clerk.setAge(0);
		clerk.setGender("enter");
		clerk.setDob("dob");
		clerk.setContactNumber(0);
		clerk.setAlternateContactNumber(0);
		clerk.setEmailId("mail id");
		clerk.setAddressLine1("enter address");
		clerk.setAddressLine2("enter address");
		clerk.setCity("enter city");
		clerk.setState("enter state");
		clerk.setZipCode(0);
		
		return clerk;
		
	}
	
	
}