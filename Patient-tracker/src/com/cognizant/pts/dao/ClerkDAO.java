package com.cognizant.pts.dao;

import java.util.List;

import com.cognizant.pts.entity.Clerk;



public interface ClerkDAO {
	
	 List<Clerk> viewAllClerks();
	 boolean insertClerk(Clerk clerk);
	Clerk viewOneClerk(String clerkId);
	 boolean updateClerk(Clerk clerk);
}
