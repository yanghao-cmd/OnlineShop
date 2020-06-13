<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="content-Type" content="text/html;charset=UTF-8"/>
<head>

<title>科技点亮未来</title>
<%--导入css和js --%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/client/js/form.js" charset="UTF-8"></script>
<script type="text/javascript">
	function changeImage() {
		// 改变验证码图片中的文字
		document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
				+ new Date().getTime();
	}
</script>
</head>

<body class="main">
<!--2. 网上书城菜单列表  start -->
       <%@include file="menu_search.jsp" %>
<!-- 网上书城菜单列表  end -->
<!-- 3.网上书城用户注册  start -->
	<div class="divcontent">
		<form action="${pageContext.request.contextPath}/register" method="post" onsubmit="return checkForm();">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td class="new_users" style="padding: 30px"><h2>新用户注册</h2>
						<table width="70%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align: right; width: 20%">邮箱 &emsp; </td>
								<td style="width: 40%">
								<input type="text" class="textinput"  id="email" name="email" onkeyup="checkEmail();"/>
								</td>
								<td colspan="2"><span id="emailMsg"></span><font color="#999999" size="2px">&nbsp;请输入有效的qq邮箱地址</font></td>							
							</tr>							
							<tr height="15px"></tr>
							<tr>
							 
								<td style="text-align: right">用户名 &emsp; </td>
								<td><input type="text" class="textinput"  id="username" name="username" onkeyup="checkUsername();"/>
								</td>
								<td colspan="2"><span id="usernameMsg"></span><font color="#999999" size="2px">&nbsp;字母数字下划线1到10位, 不能是数字开头</font></td>
							</tr>
							<tr height="15px"></tr>
							<tr>
								<td style="text-align: right">密码 &emsp; </td>
								<td><input type="password" class="textinput"  id="password" name="password" onkeyup="checkPassword();"/></td>
								<td><span id="passwordMsg"></span><font color="#999999" size="2px">&nbsp;密码请设置6-16位字符</font></td>
							</tr>
							<tr height="15px"></tr>
							<tr>
								<td style="text-align: right">重复密码 &emsp; </td>
								<td>
								<input type="password" class="textinput"  id="repassword" name="repassword" onkeyup="checkConfirm();"/>
								</td>
								<td><span id="confirmMsg"></span>&nbsp;</td>
							</tr>
							<tr height="5px"></tr>
						</table>
						<h2>注册验证</h2>
						<table width="80%" border="0" cellspacing="2" class="upline">
							<tr>
								<td style="text-align: right; width: 20%">输入验证码 &nbsp;&nbsp;</td>
								<td style="width: 50%">
								<input type="text" class="textinput" />
								</td>
								<td>&nbsp;</td>
							</tr>
							<tr height="15px"></tr>
							<tr>
								<td style="text-align: right; width: 20%;">&nbsp;</td>
								<td rowspan="2" style="width: 80%">
								<img src="${pageContext.request.contextPath}/imageCode" width="180"
									height="30" class="textinput" style="height: 30px;" id="img" />&nbsp;&nbsp;
									<a href="javascript:void(0);" class="change_pictures" onclick="changeImage()">看不清换一张</a>
								</td>
							</tr>
							<tr height="15px"></tr>
						</table>
						<table>
						<tr height="20px"></tr>
							<tr>
								<td>
									<button class="submit" name="submit">提交</button>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</div>
 <!-- 网上书城用户注册  end -->
</body>
</html>
