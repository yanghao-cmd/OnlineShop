<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>在线支付</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
</head>
<body>
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
	<p style="float:left"><b>&nbsp;&nbsp;支付中心&nbsp;>>&nbsp;确认支付</b></p>
	<img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="850" height="89" />
	<table><tr height="30px"></tr></table>
	<form action="${pageContext.request.contextPath}/pay" method="post">
		订单号&nbsp;&nbsp;<INPUT class="textinput" TYPE="text" NAME="orderid" value="${param.id}" style="color:#FF0000">
		&nbsp;&nbsp;&nbsp;&nbsp;
		支付金额&nbsp;&nbsp;<INPUT class="textinput" TYPE="text" NAME="money" value="${param.money}" style="color:#FF0000">元
		<div class="divBank">
		<table><tr height="15px"></tr></table>
			<div class="divText">选择支付方式</div>
			<table><tr height="15px"></tr></table>
			<div style="margin-left: 20px;">
				<div style="margin-bottom: 20px;">
					     
						
						<label class="demo--label">
                            <input class="demo--radio" type="radio" name="yh" value="ICBC-NET-B2C" checked="checked">
                            <span class="demo--radioInput"></span><img name="ICBC-NET-B2C" align="middle" src="<c:url value='/client/images/WeChatpay.png'/>" />
                        </label>
                        <label class="demo--label">
                            <input class="demo--radio" type="radio" name="yh" value="ICBC-NET-B2C">
                            <span class="demo--radioInput"></span><img name="CMBCHINA-NET-B2C" align="middle" src="<c:url value='/client/images/Alipay.png'/>" />
                        </label>

				</div>
				
			</div>
			<div style="margin: 40px;">
				<INPUT TYPE="submit" class="submit6" value="确定支付"/>
			</div>
		</div>
	</form>
	</div>
</body>
</html>
