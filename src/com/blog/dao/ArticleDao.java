package com.blog.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.blog.model.Article;
import com.blog.model.ArticleInfo;
import com.blog.model.MainCategory;
import com.utils.*;

public class ArticleDao {

	//根据 info参数，查询数据库，返回装着article的List容器
	public List<Article> getArticles(ArticleInfo info) {

		List<Article> ret = new ArrayList<Article>(); //要返回的容器
		int id = info.getCate_id(); //得到要查询的 id 参数
		String title = info.getTitle();//得到要查询的 标题 参数
		String subtitle = info.getSubtitle();//得到要查询的 子标题 参数
		int main_id = info.getCate_id();//得到要查询的 主类别id 参数
		int sub_id = info.getSub_cate_id();//得到要查询的 子类别id 参数
		
		
		
		//构造一个sql语句 查找 article 表
		String sql = "select a.*,m.name mname , s.name sname from "
				+ "article a left join maincategory m on a.cate_id=m.id "
				+ "left join subcategory s on a.sub_cate_id = s.id " + "where 1=1";
		
		//这个对象用来存放以上查询参数
				List<Object> paramList = new ArrayList<Object>();
				
				
		//把用到的参数放到 paramList
		if (id != 0) {
			sql += " and a.id=?";
			paramList.add(id);
		}
		if (sub_id != 0) {
			sql += " and a.sub_cate_id=?";
			paramList.add(sub_id);
		}

		if (main_id != 0) {
			sql += " and a.cate_id=?";
			paramList.add(sub_id);
		}

		//按创建日期 降序排列
		sql += " ORDER BY create_date desc";

		DBUtils dbUtils = new DBUtils(); //new一个数据库查询的工具对象
		dbUtils.getConnection(); //连接数据库

		List<Map<String, Object>> resultList;
		try {
			resultList = dbUtils.getResult(sql, paramList);  //执行查询 sql 会被预处理  paramList 中的参数 会填充到 sql 中
			if (!resultList.isEmpty()) {
				for (Map<String, Object> map : resultList) {
					//map 对象中包含了文章的数据
					//用这些数据构造一个 Article 对象
					Article article = new Article(map);
					ret.add(article); //添加到 ret 容器中
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	
	public boolean addArticle(Article article) 
	{
		//【8-2】参照 getArticles() 方法构造一个 sql 语句 insert... 
		//将 article 中的各个属性添加到一个 List<Object> 容器中
		//调用 dbUtils 中的 update() 方法 执行这个 sql 语句
		DBUtils dbUtils = new DBUtils(); 
		dbUtils.getConnection(); 
		List<Object> paramList = new ArrayList<Object>();//把参数添加到  paramList
		String sql = "insert...";
		return dbUtils.update(sql, paramList);
	}
	
	public boolean delArticle(int id) 
	{
		//【9-2】参照 getArticles() 方法构造一个 sql 语句 "delete from article where id=..."
		//调用 dbUtils 中的 update() 方法 执行这个 sql 语句
		DBUtils dbUtils = new DBUtils(); 
		dbUtils.getConnection(); 
		String sql = "delete from article where id=?";
		List<Object> paramList = new ArrayList<Object>();//把参数添加到  paramList
		//paramList 中只有一个参数 就是将要删除的文章的id
		paramList.add(id);
		return dbUtils.update(sql, paramList);
	}
}
