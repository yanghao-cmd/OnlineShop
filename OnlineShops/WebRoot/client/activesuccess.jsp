<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>科技点亮未来</title>
	<link rel="stylesheet" href="css/main.css" type="text/css" />
	<script type="text/javascript" src="js/my.js"></script>
</head>

<body class="main">
	<jsp:include page="menu_search.jsp" />

	<div class="divcontent">
		<table border="0" cellspacing="0"> 
			<tr>
				<td class="registerSuccess" style="padding:30px; text-align:center">
					<table border="0" cellspacing="0" style="margin-top:70px">
						<tr>
							<td style="width:98">
								<img src="images/registerSuccess.jpg" width="700" height="310" />
							</td>
							
						</tr>
						<tr>
						    <td class="registerSuccess1" style="padding-top:30px">
								<font style="font-weight:bold; color:#000000" size="5px">恭喜您！账户激活成功！</font><br />
								<br /> <br />
								<a class="skip" href="${pageContext.request.contextPath }/index.jsp">
									<span id="second">5</span>秒后自动为您转跳回首页
								</a>
							</td>
						</tr>
					</table>
					<h1>&nbsp;</h1></td>
			</tr>
		</table>
	</div>
</body>
</html>
