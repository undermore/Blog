package com.blog.model;

import java.util.Map;

public class Article extends ArticleInfo {
	
	int id;

	public Article(Map<String ,Object> map)
	{
		id = (int)map.get("id");
		super.title = (String)map.get("title");
		super.subtitle = (String)map.get("subtitle");
		super.name = (String)map.get("name");
		super.html_content = (String)map.get("html_content");
		super.create_date = (String)map.get("create_date");
		super.user_id = (int)map.get("user_id");
		super.cate_id = (int)map.get("cate_id");
		super.sub_cate_id = (int)map.get("sub_cate_id");
		super.sname = (String)map.get("sname");
		super.mname = (String)map.get("mname");
	}
	
	public int getId() 
	{
		return id;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getCreate_date()
	{
		return create_date;
	}
	
	public String getSubtitle()
	{
		return subtitle;
	}
	
	public String getTitle() 
	{
		return title;
	}

	public String getSname() 
	{
		return sname;
	}
	
	public String getMname() 
	{
		return mname;
	}
	
	public String getHtml_content () 
	{
		return html_content;
	}
}
