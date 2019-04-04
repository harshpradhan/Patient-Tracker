package com.cognizant.pts.service;

import java.util.List;

import com.cognizant.pts.entity.Clerk;
import com.cognizant.pts.model.ClerkModel;

public interface ClerkService {

	List<Clerk> viewAllClerks();
	boolean persistClerk(ClerkModel clerkModel);
	boolean updateClerk(ClerkModel clerkModel);
    ClerkModel viewOneClerk(String clerkId);

}
