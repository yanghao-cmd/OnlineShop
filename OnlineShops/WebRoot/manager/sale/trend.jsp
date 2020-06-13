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
           <li><a class="active" href="#">后台中心</a></li>         
           <li><a href="${pageContext.request.contextPath}/listProduct" target="mainFrame">商品管理</a></li>
           <li><a href="${pageContext.request.contextPath}/admin/products/download.jsp" target="mainFrame">销售榜单</a></li>
           <li><a href="${pageContext.request.contextPath}/findOrders" target="mainFrame">订单管理</a></li>
           <li><a href="${pageContext.request.contextPath}/userLike" target="mainFrame">用户画像</a></li>
           <li><a href="${pageContext.request.contextPath}/saleTrend" target="mainFrame">销售趋势</a></li>
           <li><a href="${pageContext.request.contextPath}/logout?type=admin" onclick="javascript:return confirm_logout()">退出登录</a></li>
        </ul>
	</div>
	<div class="divcontent_2">    
	    <img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="840" height="120" />
	    <p><strong>销售量Top10的商品</strong></p>
	    <table>
		<tr><td>
		<div id="wholeform">
		<div id="colum">
		<table style="width:170%;">
		<tr>
		<td style="CURSOR: hand; HEIGHT: 35px" align="center" width="60%">商品编号</td>
		<td style="CURSOR: hand; HEIGHT: 35px" align="center" width="20%">商品名称</td>
		<td style="CURSOR: hand; HEIGHT: 35px" align="center" width="20%">销售量</td>
		</tr>
		</table>
		</div>
		
		<div id="form">
		<table style="width:170%;">
		<c:forEach items="${list}" var="p">
			<tr>
			<td style="CURSOR: hand; HEIGHT: 35px" align="center" width="60%">${p.id}</td>
			<td style="CURSOR: hand; HEIGHT: 35px" align="center" width="20%">${p.name}</td>
			<td style="CURSOR: hand; HEIGHT: 35px" align="center" width="20%">${p.getNum()}</td>
			</tr>
		</c:forEach>
		</table>
		</div>
		
		</div>
		</td></tr>
	</table>
	</div>
</body>
</html>
