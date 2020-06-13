<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>科技点亮未来</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
	<script type="text/javascript">
	//退出确认框
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
	<jsp:include page="after_login_menu_search.jsp" />
	<div id="divpagecontent">
		<ul>
		   <li><img src="${pageContext.request.contextPath }/client/images/registerSuccess.jpg" width="200" height="150" /></li>
           <li><a class="active" href="#">个人中心</a></li>
           <li><a href="${pageContext.request.contextPath}/findOrderByUser">订单查询</a></li>
           <li><a href="${pageContext.request.contextPath}/logout" onclick="javascript:return confirm_logout()">退出登录</a></li>
       </ul>
	</div>
	<div class="divcontent_2">
	<img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="840" height="300" />
	<table><tr height="30px"></tr></table>
	<p><b style="font-size:23px">欢迎来到OnlineShop,这里是你的用户中心，让我们一起用科技点亮未来吧！</b></p>
	     
	</div>
</body>
</html>
