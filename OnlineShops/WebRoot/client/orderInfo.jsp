<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>科技点亮未来</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
</head>
<body class="main">
	<jsp:include page="after_login_menu_search.jsp" />
	<div id="divpagecontent">
		<ul>
		   <li><img src="client/images/registerSuccess.jpg" width="200" height="150" /></li>
           <li><a class="active" href="#">个人中心</a></li>
           <li><a href="${pageContext.request.contextPath}/findOrderByUser">订单查询</a></li>
           <li><a href="${pageContext.request.contextPath}/logout" onclick="javascript:return confirm_logout()">退出登录</a></li>
       </ul>
	</div>
	<div class="divcontent_6">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td><p>&nbsp;&nbsp;订单查询&nbsp;>>&nbsp;订单详细信息<p>
					<table cellspacing="0" class="infocontent">
						<tr>
							<td>
								<table width="100%" border="0" cellspacing="0">
									
									<tr>
										<td><p>订单编号:${order.id}</p>
										<img src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="892" height="89" />
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="10%">序号</td>
													<td width="40%">商品名称</td>
													<td width="10%">价格</td>
													<td width="10%">数量</td>
													<td width="10%">小计</td>
												</tr>
											</table> 
											<c:forEach items="${order.orderItems}" var="item" varStatus="vs">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="10%">${vs.count }</td>
														<td width="40%">${item.p.name}</td>
														<td width="10%">${item.p.price }</td>
														<td width="10%">${item.buynum }</td>
														<td width="10%">${item.buynum*item.p.price }</td>
													</tr>
												</table>
											</c:forEach>
											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align:right; padding-right:40px;"><font
														style="color:#FF0000">合计：&nbsp;&nbsp;${order.money}</font>
													</td>
												</tr>
											</table>
											<p>
												收货地址：${order.receiverAddress }&nbsp;&nbsp;&nbsp;&nbsp;<br />
												收货人：&nbsp;&nbsp;&nbsp;&nbsp;${order.receiverName }&nbsp;&nbsp;&nbsp;&nbsp;<br />
												联系方式：${order.receiverEmail }&nbsp;&nbsp;&nbsp;&nbsp;
											</p>
											<hr>
											<c:if test="${order.paystate != 1 }">
											<p style="text-align:right">
												<a href="${pageContext.request.contextPath}/client/pay.jsp?id=${order.id}&money=${order.money}">
													<input type="button" class="submit4" name="buy" value="支付"/> 
												</a>
											</p>
											</c:if>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
