package com.blog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.ArticleDao;
import com.blog.model.Article;

//【7】添加代码使这个servlet类响应 edit.jsp 中的表单提交  4分
@WebServlet("/servlet/EditArticle")
public class EditArticle extends HttpServlet {




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String act = request.getParameter("act");
        if (act.equals("add")) 
        {
        	//【8-1】在这里将提交上来的文章写入到数据库  第8题共40分 包含3个小题 8-1 8-2 8-3
        	// 提示 调用 ArticleDao中的 addArticle()方法 将数据 insert到数据库中
        	ArticleDao adao = new ArticleDao();
        	Article article = new Article(); //给 Article 对象添加相应的 setXXX方法
        	//用setXXX方法 设置 article 的标题，类别，创建时间 等等
        	//标题，类别，创建时间 是由 request.getParameter("xxx"); 得到的 其中 xxx 是 edit.jsp 中控件 name属性的值
        	//article填充完毕 调用 Dao 将article 加入到数据库
        	
        	article.setTitle(request.getParameter("title"));
            article.setHtml_content(request.getParameter("text"));
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String hour = request.getParameter("hour");
            String minute = request.getParameter("minute");
            String createdate = year + "-" + month + "-" + day + " " + hour + ":" + minute;
            article.setCreate_date(createdate);
            article.setSubtitle(request.getParameter("subtitle"));
            article.setCate_id(Integer.parseInt(request.getParameter("main_id")));
            article.setSub_cate_id(Integer.parseInt(request.getParameter("sub_id")));
            article.setName((String)request.getSession().getAttribute("username"));
            
        	boolean result = adao.addArticle(article);
        	if(result)
        		response.getWriter().append("发布成功");
        	else
        		response.getWriter().append("发布失败");
        	
        } else if(act.equals("delete")) 
        {
        	//【9-1】在这里删除一篇文章  第9题共20分 包含3个小题 9-1 9-2 9-3
        	ArticleDao adao = new ArticleDao();
        	int id = Integer.parseInt(request.getParameter("aid")) ;
        	boolean result = adao.delArticle(id);
        	if(result)
        		response.getWriter().append("删除成功");
        	else
        		response.getWriter().append("删除失败");
        }
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
