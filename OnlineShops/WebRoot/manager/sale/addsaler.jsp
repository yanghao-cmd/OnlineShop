<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>科技点亮未来</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
	<script type="text/javascript">
	function confirm_logout() {   
	    var msg = "您确定要退出登录吗？";   
	    if (confirm(msg)==true){   
	    return true;   
	    }else{   
	    return false;   
	    }   
	}
    </script> 
</head>
<body class="main">
	<jsp:include page="top.jsp" />
	<div id="divpagecontent">
		<ul>
		   <li><img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="200" height="150" /></li>
           <li><a class="active" href="#" style="text-align:center"><strong>后&nbsp;台&nbsp;管&nbsp;理&nbsp;中&nbsp;心</strong></a></li>         
           <li><a href="${pageContext.request.contextPath}/findSaler" target="mainFrame" style="text-align:center">销&nbsp;售&nbsp;员&nbsp;管&nbsp;理</a></li>
           <li><a href="${pageContext.request.contextPath}/manager/products/download.jsp" target="mainFrame" style="text-align:center">销&nbsp;售&nbsp;报&nbsp;表</a></li>
           <li><a href="${pageContext.request.contextPath}/listProduct" target="mainFrame" style="text-align:center">商&nbsp;品&nbsp;管&nbsp;理</a></li>
           <li><a href="${pageContext.request.contextPath}/superFindOrder" target="mainFrame" style="text-align:center">销&nbsp;售&nbsp;业&nbsp;绩</a></li>
           <li><a href="${pageContext.request.contextPath}/userLike" target="mainFrame" style="text-align:center">用&nbsp;户&nbsp;画&nbsp;像</a></li>
           <li><a href="${pageContext.request.contextPath}/saleTrend?type=super" target="mainFrame" style="text-align:center">销&nbsp;售&nbsp;趋&nbsp;势</a></li>
           <li><a href="${pageContext.request.contextPath}/logout?type=super" onclick="javascript:return confirm_logout()" style="text-align:center">退&nbsp;出&nbsp;登&nbsp;录</a></li>
        </ul>
	</div>
	<div class="divcontent_2">
	     <img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="840" height="100" />
	     <form action="${pageContext.request.contextPath}/addSaler?user=${sessionScope.user.id}" method="post">
<div id="bg">
<div id="card">
    <div id="welcome">新增销售
    </div>
<div id="details">
    <div class="box">
        <div class="ch">用户ID:</div>
        <div class="ip">
        <input type="text" name="id" value="${form.id }">
        <div class="error">${form.errors.id }</div>
    </div></div>

    <div class="box">
        <div class="ch">用户名:</div>
        <div class="ip">
        <input type="text" name="name" value="${form.name }" />
        <div class="error">${form.errors.name}</div>
    </div></div>
    
    <div class="box">
        <div class="ch">密码:</div>
        <div class="ip">
        <input type="password" name="password">
        <div class="error">${form.errors.password }</div>
    </div></div>
    
    <div class="box">
        <div class="ch">确认密码:</div>
        <div class="ip">
        <input type="password" name="password2">
        <div class="error">${form.errors.password2 }</div>
    </div></div>
    
    <div class="box">
        <div class="ch">邮箱:</div>
        <div class="ip">
        <input type="text" name="email" value="${form.email }">
        <div class="error">${form.errors.email }</div>
    </div></div></div>   
    <div id="button">
        <input type="submit" value="注册" />
    </div>   
</div>
</div>
</form>
	</div>
</body>
</html>
