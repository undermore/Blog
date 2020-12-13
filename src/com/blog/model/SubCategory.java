package com.blog.model;

import java.util.Map;

public class SubCategory {
	
	int id;
	String name;
	int cate_id;
	
	public SubCategory(Map<String ,Object> map)
	{
		id = (int)map.get("id");
		name = (String)map.get("name");
		cate_id = (int)map.get("cate_id");
	}
	
	public int getId() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public int getCate_id() 
	{
		return cate_id;
	}
	
}
