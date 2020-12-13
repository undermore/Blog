package com.blog.model;

public class ArticleInfo {

	int id;
	String title;
	String subtitle;
	String name;
	String html_content;
	String create_date;
	String sname;
	String mname;
	int user_id;
	int cate_id;
	int sub_cate_id;
	
	
	public int getCate_id() { return cate_id;	}
	
	public void setCate_id(int id) { cate_id = id; }
	
	public int getSub_cate_id() { return sub_cate_id; }
	
	public void setSub_cate_id(int id) { sub_cate_id = id;}
	
	public String getTitle() { return title;	}
	
	public String getSubtitle() 
	{
		return subtitle;
	}
	public ArticleInfo() {}
}
