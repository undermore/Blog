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
		
<link rel="stylesheet" href="<%=ctx %>/css/blog.css"/>
<link rel="stylesheet" href="<%=ctx %>/css/bootstrap.min.css">

<script src="<%=ctx %>/js/jquery.min.js"></script>
<script src="<%=ctx %>/js/blog.js"></script>
	
</head>


<body style="background: #d2d2d2 url(<%=ctx %>/img/blog_bg.jpg) no-repeat fixed center;" >
  
<div id="switch">
	<div id="iconfixed">
		<div class="icon"></div>
	</div>
</div>

<div id="left-nav">
	<div class="main-nav">
		<ul>
			<!-- 这里用 尖括号%= 输出变量 ctx 构造一个超链接 -->
			<a href="<%=ctx %>/index.html">
					<li>主页</li>
			</a>
			
			<!-- 使用 c 里面的  forEach 功能遍历  mainCategory 容器，其中的每个元素 起名字叫 mainCate -->
			<c:forEach items="${mainCategory}" var="mainCate">
				<a href="javascript:void(0)" class="showSub">
					<!-- 把单个元素 mainCate 中的 name 属性 输出到页面-->
					<li>${mainCate.name}</li>
				</a>
				<ul class="submenu"> 
					<!-- mainCate 中还有一个容器数据 包含了这个主类别里面所有的 子类别  -->
					<!-- 继续用 forEach 遍历子类别 也就是 mainCate 的 sublist 属性，里面的元素起名字叫 subCate -->
					<c:forEach items="${mainCate.sublist}" var="subCate">
						<a href="#">
							<!-- 把子类别的名字输出到页面-->
                           <li> ${subCate.name} </li>
	                    </a>
					</c:forEach>
				</ul>
			</c:forEach>	
			
			<a href="<%=ctx %>/login.html">
					<li>控制台</li>
			</a>
		</ul>
	</div>
</div>

<div id="wrap">

	<div id="top">
        <div class="info">
            <div class="bg-title">
                My Blog
            </div>
            <div class="md-title">
                JSP + Servlet
            </div>
        </div>
    </div>
    
    
    <div id="main">
        <form id="postForm" method="POST" action="<%=ctx %>/servlet/">
            <div class="container main-inner">
                <div class="row">
                    <div class="article-wrap col-md-10 col-md-offset-1 col-xs-12">
                        
                            <article class="index-article">
                                <div class="post-info">
                                    <h2>
                                        <a href="">文章的主标题</a>
                                    </h2>
                                    <div class="post-detial">
                                        <span>作者名字</span>
                                        <span>创建日期</span>
                                    </div>
                                </div>
                                <div class="sub-title">
                                        <span>文章的子标题</span>
                                </div>
                                <center>
                                    <button class="more"><a href="">阅读</a></button>
                                </center>
                            </article>
  
                    </div>
                </div>
            </div>
        </form>
    </div>

	<footer>
        <div id="block">
            <span id="beian">公安备案xxxxx号</span>
            <span id="demo"></span>
        </div>
		版权 © 2020
    </footer>
    
</div>


</body>
</html>