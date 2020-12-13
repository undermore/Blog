<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 作用类似于 java 的 import 引入了com.jsp.jstl.core这个包 ，并且给这个包起了一个名字 叫 c -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>博客</title>

<%
    //这里直接写 java 代码，用jsp内置对象 request 得到网站的地址 ctx
	String ctx = request.getContextPath();
%>		
			
</head>
<body>
	<!-- 这里用 尖括号%= 输出变量 ctx 构造一个超链接 -->
	<a href="<%=ctx %>/index.html">博客主页</a>
	
	<!-- 使用 c 里面的  forEach 功能遍历  mainCategory 容器，其中的每个元素 起名字叫 mainCate -->
	<c:forEach items="${mainCategory}" var="mainCate">
		<!-- 把单个元素 mainCate 中的 name 属性 输出到页面-->
		${mainCate.name}
		
		<!-- mainCate 中还有一个容器数据 包含了这个主类别里面所有的 子类别  -->
		<!-- 继续用 forEach 遍历子类别 也就是 mainCate 的 sublist 属性，里面的元素起名字叫 subCate -->
		<c:forEach items="${mainCate.sublist}" var="subCate">
			<!-- 把子类别的名字输出到页面-->
			${subCate.name}
		</c:forEach>
					
	</c:forEach>
			
</body>
</html>