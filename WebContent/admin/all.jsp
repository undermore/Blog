<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
           <c:if test="${fn:length(articleList) eq 0 }">
           		<!-- 如果为空则 显示提示信息 -->
               <span>查询的结果不存在</span>
           </c:if>
           <c:if test="${fn:length(articleList) gt 0 }">
				<!-- 如果非空则用 articleList 中的数据填充 table -->
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
                     <c:forEach items="${articleList}" var="article">
	                   <tr> <!-- table的 body 部分列出要显示的具体内容，这些内容下一步会被替换成数据库中的数据  -->
	                       <td>${article.title}</td>
                       	   <td>${article.mname}</td>
                           <td>${article.sname}</td>
                           <td>${article.create_date}</td>
	                       <td>
	                           <a> <!-- 编辑按钮接下来需要定向到文章的编辑页面  -->
	                               <button type="button" class="btn btn-primary">编辑</button>
	                           </a> <!-- 删除按钮接下来要实现文章删除  -->
	                           <a href="<%=ctx %>/servlet/EditArticle?act=delete&aid=${article.id}">
	                           <button type="button" class="btn btn-danger">删除</button>
	                           </a>
	                       </td>
	                   </tr>
                      </c:forEach>
            		</tbody>
               </table>
           </c:if>
           <div class="fiter col-md-4">
               <form class="form-horizontal form-inline" method="post" id="postForm">
                   <select class="form-control" name="main_id" id="main_id" onchange="getSubCatagory()">
                       <option value="0">全部主类别</option> <!-- 主类别的值改变时 子类别内容要随之改变 -->
                       
                       <c:forEach items="${mainCategory}" var="category">
                       		<option value="${category.id}">${category.name}</option>
                       </c:forEach>
                       
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