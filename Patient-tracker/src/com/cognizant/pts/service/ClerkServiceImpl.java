package com.cognizant.pts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pts.dao.ClerkDAO;
import com.cognizant.pts.entity.Clerk;

@Service

public class ClerkServiceImpl implements ClerkService {

	
	@Autowired
	private ClerkDAO clerkDAO;
	
	@Override
	public List<Clerk> getAllClerks() {
		
		return clerkDAO.getAllClerks();
	}

	@Override
	public boolean persistClerk(Clerk clerk) {
		return clerkDAO.insertClerk(clerk);
	}
	
	

}
