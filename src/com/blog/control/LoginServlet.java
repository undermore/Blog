package com.blog.control;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.UserDao;

import java.io.IOException;

@WebServlet("/servlet/LoginServlet")
public class LoginServlet extends HttpServlet {

	private UserDao userDao;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	userDao = new UserDao();
    	//取得表单提交的各参数
    	String username = request.getParameter("username");
        String password = request.getParameter("password");
        String result = request.getParameter("VerifyCode");
        
        //取得由 ImgServlet 设置的验证码答案
        String answer =(String)request.getSession().getAttribute("VerifyCode");
        
        //判断用户名和密码是否正确 以及 验证码答案是否正确
        if((userDao.VerifyUser(username,password))&&(result.equals(answer))) 
        {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(3*60);//单位s
            response.sendRedirect(request.getContextPath()+"/servlet/Controller?act=10"); //在 Controller 中跳转到 管理员界面
        }
        else
        	//如果错误 则跳转到 error 页面
            request.getRequestDispatcher("/error.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
}
