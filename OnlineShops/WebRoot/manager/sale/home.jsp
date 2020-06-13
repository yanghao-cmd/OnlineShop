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
           <li><a href="${pageContext.request.contextPath}/userLike" target="mainFrame" style="text-align:center">用&nbsp;户&nbsp;画&nbsp;像</a></li>
           <li><a href="${pageContext.request.contextPath}/saleTrend?type=super" target="mainFrame" style="text-align:center">销&nbsp;售&nbsp;趋&nbsp;势</a></li>
           <li><a href="${pageContext.request.contextPath}/logout?type=super" onclick="javascript:return confirm_logout()" style="text-align:center">退&nbsp;出&nbsp;登&nbsp;录</a></li>
        </ul>
	</div>
	<div class="divcontent_2">
	     <img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="840" height="300" />
	     <table><tr height="30px"></tr></table>
	     <p><b style="font-size:23px">欢迎来到OnlineShop，这里是你的管理中心，让我们一起用科技点亮未来吧！</b></p>
	</div>
</body>
</html>
