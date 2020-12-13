package com.blog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.blog.model.MainCategory;
import com.blog.model.SubCategory;
import com.utils.DBUtils;

public class SubCategoryDao {

	
	public List<SubCategory> getSubCategory(int cate_id)
	{
		List<SubCategory> result = new ArrayList<SubCategory>();
		if(cate_id<=0)
			return result;
		
		DBUtils dbUtils = new DBUtils();
		dbUtils.getConnection();
		
		String sql = "select * from subcategory where cate_id =" + cate_id;
		List<Map<String, Object>> subCateList;
		try {
			subCateList = dbUtils.getResult(sql, null);
			if(!subCateList.isEmpty()) 
			{
				for(Map<String ,Object> map: subCateList) 
				{
					SubCategory category = new SubCategory(map);
					result.add(category);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
