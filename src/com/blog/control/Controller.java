package com.blog.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet/Controller")
public class Controller extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("utf-8");    //设置Response使用 utf-8 编码
		response.setHeader("Content-Type", "text/html;charset=utf-8");  //告诉浏览器 Response 使用 utf-8编码
		response.getWriter().append("我们在这里处理浏览器的请求，默认情况中文是乱码");
	}



}
