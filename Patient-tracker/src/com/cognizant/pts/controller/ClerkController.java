package com.cognizant.pts.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.pts.entity.Clerk;
import com.cognizant.pts.model.ClerkModel;
import com.cognizant.pts.service.ClerkService;
import com.cognizant.pts.validator.ClerkValidator;

@SessionAttributes({"clerkList","gender","oneClerk"})

@Controller
public class ClerkController {
	
	@Autowired
	private ClerkValidator clerkValidator;
	
	@Autowired
	private ClerkService clerkService;
	
	
	
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public ModelAndView viewClerks()
	{
		List<Clerk> clerkList = clerkService.viewAllClerks();
		ModelAndView mv= new ModelAndView();
		mv.addObject("clerkList",clerkList);
		mv.setViewName("viewclerks");
		return mv;
		
	}
	
	
	@RequestMapping(value="updateclerk.htm",method=RequestMethod.POST)
    public ModelAndView updateClerk(@Valid@ModelAttribute("oneClerk")ClerkModel clerkModel,Errors errors)
    {
		ModelAndView mv= new ModelAndView();
		ValidationUtils.invokeValidator(clerkValidator,clerkModel,errors);
		if(errors.hasErrors())
		{
	
			mv.setViewName("viewoneclerk");	
    }
		else{
			
			 boolean clerkPersist= clerkService.updateClerk(clerkModel);
			 
			 if(clerkPersist)
			 {
				 List<Clerk> clerkList= clerkService.viewAllClerks();
				 mv.addObject("clerkList",clerkList);
				 mv.addObject("status","Clerk successfully updated");
			
				 mv.setViewName("viewclerks");
			 }
			 
			 else{
				 mv.addObject("status","Clerk  updation failed");
				 mv.setViewName("viewoneclerk");
			 }
		
			
		}
		return mv;
}
	
	
	@RequestMapping(value="viewclerks.htm",method=RequestMethod.GET)
	public ModelAndView viewClerksAgain()
	{
		ModelAndView mv= new ModelAndView();
		List<Clerk> clerkList = clerkService.viewAllClerks();
		
		mv.addObject("clerkList",clerkList);
		mv.setViewName("viewclerks");
		return mv;
		
	}
	

	@RequestMapping(value="viewoneclerk.htm",method=RequestMethod.GET)
	public ModelAndView viewOneClerks(ModelMap map,@RequestParam("clerkId")String clerkId)
	{
		ModelAndView mv=new ModelAndView();
		List<String> genderList= new ArrayList<>();
		genderList.add("Male");
		genderList.add("Female");
		genderList.add("Trans Gender");
		mv.addObject("gender", genderList);
		ClerkModel clerkModel= clerkService.viewOneClerk(clerkId);
		
		map.addAttribute("oneClerk",clerkModel);
		mv.setViewName("viewoneclerk");
				return mv;
		
	}
	@RequestMapping(value="addclerkform.htm",method=RequestMethod.POST)
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
	
	
	@RequestMapping(value="addclerk.htm",method=RequestMethod.POST)
    public ModelAndView addClerk(@Valid@ModelAttribute("clerkModel")ClerkModel clerkModel,Errors errors)
    {
		ModelAndView mv= new ModelAndView();
		ValidationUtils.invokeValidator(clerkValidator,clerkModel,errors);
		if(errors.hasErrors())
		{
	
			mv.setViewName("clerkform");	
    }
		else{
			
			 boolean clerkPersist= clerkService.persistClerk(clerkModel);
			 
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
	
	@ModelAttribute("clerkModel")
	public ClerkModel createCommandObject()
	{
		ClerkModel clerkModel = new ClerkModel();
		
		return clerkModel;
		
	}
	
	
}