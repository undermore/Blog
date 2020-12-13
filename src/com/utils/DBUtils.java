package com.utils;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;



public class DBUtils {

	private final String UserName = "root";  //数据库登录名，根据实际情况填写
	private final String PassWord = "";      //数据库密码，根据实际情况填写
	private final String Url = "jdbc:mysql://localhost:3306/";  //数据库地址，根据实际情况填写
	private final String DBName = "blog";  //数据库的名字，根据实际情况填写
	
	private Connection connection = null;  //连接对象
	private PreparedStatement pst = null;  //经过编译的 sql 语句
	private ResultSet result = null;       //存放查询的结果
	
	public DBUtils(){}
	
	public Connection getConnection()
	{
		//在这里初始化 Connection 对象
		return connection;
	}
	
	
	public  List<Map<String ,Object>> getResult(String sql, List<Object> param) 
			throws SQLException 
	{
		//构造一个 ret 对象 用来保存所有从数据库查找到的数据
		//所以 ret 应该可以容纳任何数据类型所以 使用 Object 根类
		//String 是数据的名字 与数据一一对应，存放在 Map容器中
		//每一个Map容器 又放在了 List 容器中
		List<Map<String ,Object>> ret = new ArrayList<Map<String ,Object>>();
	
		return ret;
	}
	
}
