package com.cognizant.pts.service;

import java.util.List;

import com.cognizant.pts.entity.Clerk;

public interface ClerkService {

	List<Clerk> getAllClerks();
	boolean persistClerk(Clerk clerk);
}
