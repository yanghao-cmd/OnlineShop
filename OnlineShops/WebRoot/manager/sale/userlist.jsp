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
    //添加商品
	function addSaler() {
		window.location.href = "${pageContext.request.contextPath}/manager/sale/addsaler.jsp";
	}
	//删除商品
	function p_del() {   
		var msg = "确定要删除该销售员吗？";
		if (confirm(msg)==true){   
		return true;   
		}else{   
		return false;   
		}   
	}   
	</script></head> 
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
           <li><a href="${pageContext.request.contextPath}/saleTrend" target="mainFrame" style="text-align:center">销&nbsp;售&nbsp;趋&nbsp;势</a></li>
           <li><a href="${pageContext.request.contextPath}/logout?type=super" onclick="javascript:return confirm_logout()" style="text-align:center">退&nbsp;出&nbsp;登&nbsp;录</a></li>
        </ul>
	</div>
	<div class="divcontent_2">
	     <img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="840" height="100" />
	     <form name="Form1" action="${pageContext.request.contextPath}/findSaler?op=find&user=${sessionScope.user.id}" method="post">
	    <div id="head">
	    <table style="width:100%;">
	        <tr style="CURSOR: hand; HEIGHT: 20px"></tr>
	        <tr>
	        <td style="text-align:center"><strong>销售员编号</strong>
			<input type="text" name="id" value="" />&nbsp;<button class="but" type="submit" name="search" value="查询"><strong>查询</strong></button></td>
			<!--  <td><button type="button" name="add" value="添加" onclick="addSaler()"><strong>添加</strong></button></td>-->
	        </tr>
	    </table>
	    </div>
	    
	    
	    <table style="width:100%;">
			<tr><td>
			<div id="wholeform">
			<div id="colum">
			<table style="width:100%;">
			    <tr>
			    <td style="CURSOR: hand; HEIGHT: 40px" align="center" width="5%">&nbsp;</td>
				<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="10%">销售员编号</td>
				<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="20%">销售员名称</td>
				<td style="CURSOR: hand; HEIGHT: 40px" width="35%" align="center">邮箱</td>
				<td style="CURSOR: hand; HEIGHT: 40px" width="15%" align="center">编辑</td>
				<td style="CURSOR: hand; HEIGHT: 40px" width="15%" align="center">删除</td>
				</tr>
			</table>
			</div>
			
			<div id="form">
			<table style="width:100%;">
				<c:forEach items="${ul}" var="u">
	                <tr>
	                <td style="CURSOR: hand; HEIGHT: 40px" align="center" width="5%">&nbsp;</td>
					<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="10%">${u.id}</td>
					<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="20%">${u.username}</td>
					<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="35%">${u.email}</td>
					<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="15%">
					<a href="${pageContext.request.contextPath}/findSaler?type=edit&id=${u.id}">编辑</a>
					</td>
					<td style="CURSOR: hand; HEIGHT: 40px" align="center" width="15%">
					<a href="${pageContext.request.contextPath}/delSaler?id=${u.id}&user=${sessionScope.user.id}" onclick="javascript:return p_del()">
					删除
					</a>
					</td>
					</tr>
				</c:forEach>
			</table>
			</div>			
			</div>
			</td></tr>			
	    </table>	    	    
</form>
</div>
</body>
</html>
