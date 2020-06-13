<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>科技点亮未来</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
	<script type="text/javascript">
	//鼠标点击搜索框时执行
	function my_click(obj, myid){
		//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
		if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
		  document.getElementById(myid).value = '';
		  obj.style.color='#000';
		}
	}
	//鼠标不聚焦在搜索框时执行
	function my_blur(obj, myid){
		//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
		if (document.getElementById(myid).value == ''){
		 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
		 obj.style.color='#999';
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
	     <img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="840" height="150" />
	     <form action="${pageContext.request.contextPath}/editSaler?user=${sessionScope.user.id}" method="post">
    <div id="bg">
    <div id="details">

    <table align="center" width="35%">
    <tr style="CURSOR: hand; HEIGHT: 40px"></tr>
    <tr style="CURSOR: hand; HEIGHT: 40px" align="center">
		<td><strong>销售员ID：</strong></td>
		<td>${u.id}
		<input type="hidden" name="id" value="${u.id}"/>
		</td>
	</tr>
	<tr style="CURSOR: hand; HEIGHT: 40px" align="center">
		<td><strong>名称：</strong></td>
		<td><input type="text" name="name" value="${u.username}" id="gState"
		onmouseover="this.focus();" onclick="my_click(this, 'gState');" onBlur="my_blur(this, 'gState');"/>
		</td>
	</tr>
	<tr style="CURSOR: hand; HEIGHT: 40px" align="center">
		<td><strong>口令密码：</strong></td>
		<td><input type="text" name="password" value="${u.password}" id="gPrice"
		onmouseover="this.focus();" onclick="my_click(this, 'gPrice');" onBlur="my_blur(this, 'gPrice');"/>
		</td>
	</tr>
	<tr style="CURSOR: hand; HEIGHT: 40px" align="center">
		<td><strong>邮箱：</strong></td>
		<td><input type="text" name="email" id="gScore" value="${u.email}"
		onmouseover="this.focus();" onclick="my_click(this, 'gScore');" onBlur="my_blur(this, 'gScore');"/>	
		</td>
	</tr>
	</table>
    <div class="button" id="bottom" align="center">
		<p></p>
		<input type="submit" value="确定">	
	</div>  
    </div>
    </div>
</form>
</div>
</body>
</html>
