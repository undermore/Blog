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
	private final String Url = "jdbc:mysql://localhost:3306/";  //数据库服务器的地址，根据实际情况填写
	private final String DBName = "blog";  //数据库的名字，根据实际情况填写
	
	private Connection connection = null;  //连接对象
	private PreparedStatement pst = null;  //经过编译的 sql 语句
	private ResultSet result = null;       //存放查询的结果
	
	public DBUtils(){}
	
	public Connection getConnection()
	{
		//在这里初始化 Connection 对象
		try {
			Driver driver = new com.mysql.jdbc.Driver(); //得到数据库连接驱动
			DriverManager.registerDriver(driver);        //注册这个驱动
			connection = DriverManager.getConnection(Url+DBName, UserName, PassWord); //用前面设定的用户名密码连接数据库服务器
		} catch(Exception e) 
		{
			throw new RuntimeException("获取数据库连接失败", e);
		}
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
	
		//编译，预处理sql语句
		pst = connection.prepareStatement(sql);
		//把 sql 语句中的参数 逐个替换成 param 容器中的数值
		if(pst!=null && param != null) 
		{
			for(int i=0; i<param.size(); i++) 
			{ 
				pst.setObject(i+1, param.get(i));
			}
		}
		
		//执行 sql 语句 并得到结果
		result = pst.executeQuery(); 
		//取出结果中的数据类型、属性、行数等等信息
		ResultSetMetaData metaData = result.getMetaData();
		//取得数据的列数
		int cols = metaData.getColumnCount();
		
		//遍历结果 解析出来 装到 ret 里面
		while(result.next()) 
		{
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i=0; i<cols; i++) 
			{
				//每条数据的每一列 逐一解析
				String colName = metaData.getColumnLabel(i+1); //列的名字 列就是字段
				Object obj = result.getObject(colName);//列的值 字段的值
				if(obj == null) 
				{
					obj = "";
				}
				map.put(colName, obj);//字段 放到 map 里
			}
			ret.add(map); //把 map 放到 ret 里
		}
		
		return ret;
	}
	
	public boolean update(String sql, List<Object> param)
	{
		//【8-3】参照 getResult() 方法 将参数 param 添加到 sql 语句
		// 使用 PreparedStatement 对象的 executeUpdate() 方法执行 sql 语句
		// executeUpdate() 返回值大于0 则返回 true 代表成功 否则返回 false 代表执行失败
		int result = 0;
		try {
			pst = connection.prepareStatement(sql);
			result = pst.executeUpdate(sql); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result>0;
	}
	
	
}
