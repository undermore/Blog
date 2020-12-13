<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>控制台</title>

<%
	String ctx = request.getContextPath();

    if(session.getAttribute("username") == null) {
    	response.sendRedirect("../login.html");
    }
%>

<link rel="stylesheet" href="<%=ctx%>/css/blog.css"/>
<link rel="stylesheet" href="<%=ctx%>/css/bootstrap.min.css">
<script src="<%=ctx %>/js/jquery.min.js"></script>
<script src="<%=ctx %>/js/blog.js"></script>

</head>
<body>
	
	<div id="left-nav" class="open">
            <div class="author-nav">
                <img src="../img/home.png">
            </div>
            <div class="main-nav">
                <ul>
                    <a href="javascript:void(0);">
                    	<li>所有文章</li>
                    </a>
                    <a href="javascript:void(0);">
                        <li>写文章</li>
                    </a>
                    <a href="javascript:void(0);">
                        <li>分类</li>
                    </a>
                    <a href="<%=ctx %>/index.html">
                        <li>首页</li>
                    </a>
                </ul>
            </div>
	</div>
        
</body>
</html>