package com.cognizant.pts.dao;

import java.util.List;

import com.cognizant.pts.entity.Clerk;



public interface ClerkDAO {
	
	 List<Clerk> getAllClerks();
	 boolean insertClerk(Clerk clerk);
	 //boolean deleteClerk(Clerk clerk);
	 //boolean updateClerk(Clerk clerk);
}
