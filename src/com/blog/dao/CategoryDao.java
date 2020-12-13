package com.blog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.blog.model.*;
import com.utils.DBUtils;

public class CategoryDao {
		
	public List<MainCategory> getMainCategory()
	{
		List<MainCategory> result = new ArrayList<MainCategory>();
		SubCategoryDao subCategoryDao = new SubCategoryDao();
		
		DBUtils dbUtils = new DBUtils();
		dbUtils.getConnection();
		
		String sql = "select * from maincategory;";
		List<Map<String, Object>> mainCateList;
		try {
			mainCateList = dbUtils.getResult(sql, null);
			if(!mainCateList.isEmpty()) 
			{
				for(Map<String ,Object> map: mainCateList) 
				{
					MainCategory category = new MainCategory(map);
					List<SubCategory> subList = subCategoryDao.getSubCategory(category.getId());
					category.setSublist(subList);
					result.add(category);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
