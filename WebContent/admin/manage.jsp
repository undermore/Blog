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

<script>
function loadXMLDoc(uri)
{
	var xmlhttp;
	if (window.XMLHttpRequest)
		xmlhttp = new XMLHttpRequest();//其他浏览器
	else
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); //IE5 IE6 浏览器
	
	xmlhttp.onreadystatechange=function()
	{
		//readyState==4 代表载入完成    xmlhttp.status==200 代表载入正常
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{
			//替换 id 为 ajax-div 的div中的内容
			document.getElementById("ajax-div").innerHTML=xmlhttp.responseText;
		}
	}
	xmlhttp.open("POST", uri, true); //true 代表异步加载
	xmlhttp.send();//发起访问页面的请求
}

function getSubCatagory() {
    var main_id = $("#main_id").val(); //得到当前 主类别下拉菜单 对应的值
    $.ajax({
        dataType: "json",    //数据类型为json格式
        type: "GET",         //用 get 方式
        url: "<%=ctx %>/servlet/CategoryServlet?act=ajaxSub",  //CategoryServlet 返回该主类别下的全部子类 json格式 Key Value 键值对
        //把主类别的id发给 servlet
     	data: {"main_id":main_id},
        success: function (data, textStatus) {
            var sub_id = $("#sub_id"); //得到 子类别下拉菜单 对象
            sub_id.empty(); //清空子类别下拉菜单
            sub_id.append('<option value="0">全部子类别</option>');
            $.each(data, function (key, val) {
                sub_id.append('<option value="' + key + '">' + val + '</option>');
            })
        },
        error: function (xhr, status, errMsg) {
            alert("获取子类别失败");
        }
    })
};

</script>

</head>
<body>
	
	<div id="left-nav" class="open">
            <div class="author-nav">
                <img src="../img/home.png">
            </div>
            <div class="main-nav">
                <ul>
                    <a href="javascript:void(0);" onclick="loadXMLDoc('<%=ctx %>/servlet/Controller?act=11&info=all')" >
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
	
	<div id="ajax-div">
	
	</div>
        
</body>
</html>