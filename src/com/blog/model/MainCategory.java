package com.blog.model;

import java.util.List;
import java.util.Map;


public class MainCategory {
	
	private int id;
	private String name;
	private List<SubCategory> sublist;
	
	public MainCategory(Map<String, Object> map) 
	{
		id = (int)map.get("id");
		name = (String)map.get("name");
	}
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public List<SubCategory> getSublist() 
	{
		return sublist;
	}
	
	public void setSublist(List<SubCategory> list) 
	{
		sublist = list;
	}

}
