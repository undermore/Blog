<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 作用类似于 java 的 import 引入了com.jsp.jstl.core这个包 ，并且给这个包起了一个名字 叫 c -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>博客</title>
</head>
<body>
	博客主页
	<!-- 使用 c 里面的  forEach 功能遍历  mainCategory 容器，其中的每个元素 起名字叫 mainCate -->
	<c:forEach items="${mainCategory}" var="mainCate">
		<!-- 把单个元素 mainCate 中的 name 属性 输出到页面-->
		${mainCate.name}
	</c:forEach>
			
</body>
</html>