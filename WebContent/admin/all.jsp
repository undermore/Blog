<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%
	String ctx = request.getContextPath();

    if(session.getAttribute("username") == null) {
    	response.sendRedirect("../login.html");
    }
%>

</head>
<body>
	<div id="list" class="col-md-10 col-xs-12">
           <h3>文章列表</h3>
           <hr>
               <table class="table table-hover">
                   <thead> <!-- table的 head 部分列出要显示的要素的名字  -->
                   <tr>
                       <th>标题</th>
                       <th>主类别</th>
                       <th>子类别</th>
                       <th>日期</th>
                       <th>操作</th>
                   </tr>
                   </thead>
                   <tbody>
                   
	                   <tr> <!-- table的 body 部分列出要显示的具体内容，这些内容下一步会被替换成数据库中的数据  -->
	                       <td>标题</td>
	                       <td>文章的标题</td>
	                       <td>教育相关</td>
	                       <td>2020-12-24 13:03</td>
	                       <td>
	                           <a> <!-- 编辑按钮接下来需要定向到文章的编辑页面  -->
	                               <button type="button" class="btn btn-primary">编辑</button>
	                           </a> <!-- 删除按钮接下来要实现文章删除  -->
	                           <button type="button" class="btn btn-danger">删除</button>
	                       </td>
	                   </tr>
                   
            		</tbody>
               </table>
           
           <div class="fiter col-md-4">
               <form class="form-horizontal form-inline" method="post" id="postForm">
                   <select class="form-control" name="main_id" id="main_id">
                       <option value="0">全部主类别</option> <!-- 主类别的值改变时 子类别内容要随之改变 -->
                       
                       <option value="1">新闻</option>
                       <option value="2">评论</option>
                       
                   </select>
                   <select class="form-control" name="sub_id" id="sub_id">
                       <option value="0">全部子类别</option>
                   </select>
                   <!-- 确定按钮按下时，将主类别、，子类别参数提交给 servlet 执行数据库查询，而后再次定向到 all.jsp 只显示选中类别中的文章  -->
                   <button type="submit" class="btn btn-success">确定</button>
               </form>
           </div>
      </div>
</body>
</html>