package com.cognizant.pts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pts.dao.ClerkDAO;
import com.cognizant.pts.entity.Clerk;
import com.cognizant.pts.model.ClerkModel;

@Service

public class ClerkServiceImpl implements ClerkService {

	
	@Autowired
	private ClerkDAO clerkDao;
	
	@Override
	public List<Clerk> viewAllClerks() {
		
		return clerkDao.viewAllClerks();
	}

	@Override
	public boolean persistClerk(ClerkModel clerkModel) {
		
		Clerk clerk= new Clerk();
		//clerk.setClerkId(clerkModel.getClerkId());
		clerk.setFirstName(clerkModel.getFirstName());
		clerk.setLastName(clerkModel.getLastName());
		clerk.setAge(clerkModel.getAge());
		clerk.setGender(clerkModel.getGender());
		clerk.setDob(clerkModel.getDob());
		clerk.setContactNumber(clerkModel.getContactNumber());
		clerk.setAlternateContactNumber(clerkModel.getAlternateContactNumber());
		clerk.setEmailId(clerkModel.getEmailId());
		clerk.setAddressLine1(clerkModel.getAddressLine1());
		clerk.setAddressLine2(clerkModel.getAddressLine2());
		clerk.setCity(clerkModel.getCity());
		clerk.setState(clerkModel.getState());
		clerk.setZipCode(clerkModel.getZipCode());
		
		return clerkDao.insertClerk(clerk);
	}
	
	@Override
	public boolean updateClerk(ClerkModel clerkModel)
	{
		Clerk clerk= new Clerk();
		clerk.setClerkId(clerkModel.getClerkId());
		clerk.setFirstName(clerkModel.getFirstName());
		clerk.setLastName(clerkModel.getLastName());
		clerk.setAge(clerkModel.getAge());
		clerk.setGender(clerkModel.getGender());
		clerk.setDob(clerkModel.getDob());
		clerk.setContactNumber(clerkModel.getContactNumber());
		clerk.setAlternateContactNumber(clerkModel.getAlternateContactNumber());
		clerk.setEmailId(clerkModel.getEmailId());
		clerk.setAddressLine1(clerkModel.getAddressLine1());
		clerk.setAddressLine2(clerkModel.getAddressLine2());
		clerk.setCity(clerkModel.getCity());
		clerk.setState(clerkModel.getState());
		clerk.setZipCode(clerkModel.getZipCode());
		
		return clerkDao.updateClerk(clerk);
	}
	
	@Override
	public ClerkModel viewOneClerk(String clerkId) {
		
		Clerk clerk= clerkDao.viewOneClerk(clerkId);
		ClerkModel clerkModel= new ClerkModel();

		clerkModel.setClerkId(clerk.getClerkId());
		clerkModel.setFirstName(clerk.getFirstName());
		clerkModel.setLastName(clerk.getLastName());
		clerkModel.setAge(clerk.getAge());
		clerkModel.setGender(clerk.getGender());
		clerkModel.setDob(clerk.getDob());
		clerkModel.setContactNumber(clerk.getContactNumber());
		clerkModel.setAlternateContactNumber(clerk.getAlternateContactNumber());
		clerkModel.setEmailId(clerk.getEmailId());
		clerkModel.setAddressLine1(clerk.getAddressLine1());
		clerkModel.setAddressLine2(clerk.getAddressLine2());
		clerkModel.setCity(clerk.getCity());
		clerkModel.setState(clerk.getState());
		clerkModel.setZipCode(clerk.getZipCode());
		
		return clerkModel;
	}

}
