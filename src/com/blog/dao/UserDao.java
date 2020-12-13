package com.blog.dao;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.utils.DBUtils;

public class UserDao {
	
    public boolean VerifyUser(String username,String password){
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        DBUtils dbUtils = new DBUtils();
        dbUtils.getConnection();
        String sql = "select * from user where 1=1";
        List<Object> paramList = new ArrayList<Object>();
        paramList.add(username);
        sql += " and username = ?";
        paramList.add(password);
        sql += " and password = ?";
        List<Map<String, Object>> result = null;
        try {
            result = dbUtils.getResult(sql.toString(), paramList);
            if (result.size()!=0)
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
