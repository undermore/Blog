package com.blog.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.SubCategoryDao;
import com.blog.model.SubCategory;
import com.google.gson.Gson;

@WebServlet("/servlet/CategoryServlet")
public class CategoryServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String act = request.getParameter("act");
        if (act.equals("ajaxSub")) 
            ajaxSub(request, response);
	}

	private void ajaxSub(HttpServletRequest request, HttpServletResponse response)
	{
		int main_id = Integer.parseInt(request.getParameter("main_id")); //获取jsp传过来的参数  main_id 主类别id
		SubCategoryDao subCategoryDao = new SubCategoryDao(); 
		List<SubCategory> subList = subCategoryDao.getSubCategory(main_id); //根据 main_id 查找所有的子类别
        Map<Integer, String> map = new HashMap<Integer, String>();  //放到 Map 容器中
              
        for (SubCategory item : subList)  //子类别放到 Map 容器中
        	map.put(item.getId(), item.getName());
        
        Gson gson = new Gson();  //声明一个 Gson 对象
        String json = gson.toJson(map); //将 Map 转换成 json 数据
        response.setContentType("application/json"); //设置 response 的数据类型为 json
        
        PrintWriter writer = null;
        try {
        	writer = response.getWriter(); 
        	writer.print(json);  //将 json 数据写到 response 中返回给浏览器
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	writer.close();
        }
	}

}
