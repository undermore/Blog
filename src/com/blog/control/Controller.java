package com.blog.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDao;
import com.blog.dao.CategoryDao;
import com.blog.model.Article;
import com.blog.model.ArticleInfo;
import com.blog.model.MainCategory;


@WebServlet("/servlet/Controller")
public class Controller extends HttpServlet {

	CategoryDao categoryDao = new CategoryDao();
	ArticleDao articleDao = new ArticleDao();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("utf-8");    //设置Response使用 utf-8 编码
		response.setHeader("Content-Type", "text/html;charset=utf-8");  //告诉浏览器 Response 使用 utf-8编码
		response.getWriter().append("我们在这里处理浏览器的请求，默认情况中文是乱码");
		
		String info = request.getParameter("info"); //取得info参数 
		List<MainCategory> mainCategory = new ArrayList<MainCategory>();  //这个容器装所有的 主类别
		ArticleInfo searchInfo = new ArticleInfo(); //搜索条件  默认是查找全部文章
		
		//比如只查找 主类别为1的文章
		//searchInfo.setCate_id(1);
		
		mainCategory = categoryDao.getMainCategory(); //用 CategoryDao 得到所有的 主类别 主类别中实际上已经包含了子类别 不需要再单独查找了
		request.setAttribute("mainCategory", mainCategory);//放到 request 中就可以在 jsp 页面中使用这些数据了

		List<Article> articleList = articleDao.getArticles(searchInfo); //用 ArticleDao 得到所有符合 searchInfo 的文章
		request.setAttribute("articleList", articleList); //放到 request 中就可以在 jsp 页面中使用这些数据了
		
		
		String act = request.getParameter("act");//取得 主页点击时 传递的参数 act
		
		if(act != null) 
		{
			if(act.equals("0")) {
				//如果act 为0  跳转到 blog.jsp  在这个 jsp中 展示  mainCategory 和  articleList
				request.getRequestDispatcher("/blog.jsp").forward(request, response);
			}
			else if(act.equals("1")) {
				request.getRequestDispatcher("/null.jsp").forward(request, response);
			}
			else if(act.equals("2")) {
				request.getRequestDispatcher("/null.jsp").forward(request, response);
			}
			else if(act.equals("3")) {
				request.getRequestDispatcher("/null.jsp").forward(request, response);
			}
			else if(act.equals("10")) {
				request.getRequestDispatcher("/admin/manage.jsp").forward(request, response);
			}
		} 
		else
		{
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}



}
