package com.blog.model;

import java.util.Map;

public class Article extends ArticleInfo {
	
	int id;

	public Article() {}
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
	public void setId(int what) { id=what; }
	
	public String getName() 
	{
		return name;
	}
	public void setName(String what) { name=what; }
	
	public String getCreate_date()
	{
		return create_date;
	}
	public void setCreate_date(String what) { create_date=what; }
	
	public String getSubtitle()
	{
		return subtitle;
	}
	public void setSubtitle(String what) { subtitle=what; }
	
	public String getTitle() 
	{
		return title;
	}
	public void setTitle(String what) { title=what; }

	public String getSname() 
	{
		return sname;
	}
	public void setSname(String what) { sname=what; }
	
	public String getMname() 
	{
		return mname;
	}
	public void setMname(String what) { mname=what; }
	
	public String getHtml_content () 
	{
		return html_content;
	}
	public void setHtml_content(String what) { html_content=what; }
	public void setCate_id(int what) { cate_id=what; }
	public void setSub_cate_id(int what) { sub_cate_id=what; }
}
