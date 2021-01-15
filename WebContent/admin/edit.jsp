<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- 【11】在这里引入需要用到的 JSTL 标签  4分-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%
	String ctx = request.getContextPath();

 //【5】在这里判断 session 是否有 username属性 如果没有跳转到 login.html 4分
%>

</head>
<body>

<!-- 【6】给 form-inline 表单指定 action 和 method 属性 使得表单提交到 /servlet/EditArticle路径 并传一个参数 act=add    4分-->
	<form class="form-inline" action="<%=ctx %>/servlet/EditArticle?act=add" method="post">
            <div id="edit" class="col-md-8 col-xs-12">
                <h3>编辑文章</h3>
                <hr/>
                <input type="text" id="article-title" name="title" class="form-control" placeholder="标题"
                       required="" autofocus="" autocomplete="off" style="width:100%;">
                <div class="editormd" id="test-editormd">
                    <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
                    <textarea class="editormd-html-textarea" name="text"></textarea>
                </div>
            </div>
            <div id="operate" class="col-md-2 col-xs-12">
                <h3>操作</h3>
                <hr/>
                <div class="publish">
                    <h4>发布时间：</h4>
                    <input type="text" id="year" name="year"  size="4" maxlength="4" style="margin: 5px 0;">
                    - <input type="text" id="month" name="month" size="2" maxlength="2" style="margin: 5px 0;">
                    - <input type="text" id="day" name="day"  size="2" maxlength="2" style="margin: 5px 0;"><br/>
                    <input type="text" id="hour" name="hour"  size="2" maxlength="2" autocomplete="off">
                    : <input type="text" id="minute" name="minute"  size="2" maxlength="2" autocomplete="off"><br/>
                </div>
                <h4>子标题：</h4>
                <input name="subtitle" rows="8" class="form-control"></input>
                <h4>分类：</h4>
                <select class="form-control" id="main_id" name="main_id" style="margin:5px;" onchange="getSubCatagory()">
                <!--【10】 参照all.jsp 中的方式将 mainCategory 填充到  form-control 中并实现 子类别的联动  4分-->
                    <option value="0">全部主类别</option> <!-- 主类别的值改变时 子类别内容要随之改变 -->
                       
                       <c:forEach items="${mainCategory}" var="category">
                       		<option value="${category.id}">${category.name}</option>
                       </c:forEach>
                </select>
                <select class="form-control" id="sub_id" name="sub_id" style="margin:5px;">
                    <option value="0">全部子类别</option>
                </select>
                <button type="submit" class="btn btn-primary" style="float: right;margin:5px;">发布</button>
            </div>
        </form>
        
</body>
</html>