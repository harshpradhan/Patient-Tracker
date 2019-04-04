package com.cognizant.pts.dao;

import java.util.ArrayList;
import java.util.List;

public class StoreClerkId {

	static List<Integer> idList=new ArrayList<Integer>();
	public static void addClerkId(int id){
		idList.add(0,id);
	}
	public static int getClerkId(){
		return idList.get(0);
	}
} 