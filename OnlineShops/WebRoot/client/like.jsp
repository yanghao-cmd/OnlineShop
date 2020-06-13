<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>科技点亮未来</title>
	<%-- 导入css --%>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/client/css/main.css" type="text/css" />
	<!-- 导入首页轮播图css和js脚本 -->
    <link type="text/css" href="${pageContext.request.contextPath }/client/css/autoplay.css" rel="stylesheet" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/client/js/autoplay.js"></script>
</head>

<body class="main1">
	<%@include file="after_login_menu_search.jsp" %>	
	<!-- 首页轮播图  start -->
	<div id="box_autoplay">
    	<div class="list">
        	<ul class="auto">
            	<li class="auto1"><img src="${pageContext.request.contextPath }/client/ad/index_ad1.jpg" width="900" height="340" /></li>
            	<li class="auto1"><img src="${pageContext.request.contextPath }/client/ad/index_ad2.jpg" width="900" height="340" /></li>
            	<li class="auto1"><img src="${pageContext.request.contextPath }/client/ad/index_ad3.jpg" width="900" height="340" /></li>
            	<li class="auto1"><img src="${pageContext.request.contextPath }/client/ad/index_ad4.jpg" width="900" height="340" /></li>
            	<li class="auto1"><img src="${pageContext.request.contextPath }/client/ad/index_ad5.jpg" width="900" height="340" /></li>
        	</ul>
    	</div>
	</div>
	<!-- 首页轮播图  end -->	
	
	<div>
	<table>
	<tr>
	<td>
	<div id="divpagecontent1">
		<ul>
           <li><a class="active" href="#" style="text-align:center">商&nbsp;品&nbsp;分&nbsp;类</a></li>           
           <li><a href="${pageContext.request.contextPath}/showUserProductByPage?category=mobilephone" style="text-align:center">手&nbsp;&nbsp;机</a></li>
           <li><a href="${pageContext.request.contextPath}/showUserProductByPage?category=computer" style="text-align:center">电&nbsp;&nbsp;脑</a></li>
           <li><a href="${pageContext.request.contextPath}/showUserProductByPage?category=television" style="text-align:center">影&nbsp;&nbsp;音</a></li>
           <li><a href="${pageContext.request.contextPath}/showUserProductByPage?category=game" style="text-align:center">电&nbsp;&nbsp;竞</a></li>
           <li><a href="${pageContext.request.contextPath}/showUserProductByPage?category=camera" style="text-align:center">数&nbsp;&nbsp;码</a></li>
           <li><a href="${pageContext.request.contextPath}/recommendServlet?id=${user.id}" style="text-align:center"><strong>猜&nbsp;你&nbsp;喜&nbsp;欢</strong></a></li>
       </ul>
	</div>
	</td>
	
	
	<td class="divpagecontent2">
	<div>
		<table border="0" cellspacing="0">
			<tr>
				<td>
					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h2>小米科技-为发烧而生</h2>
								<div style="margin-top:20px; margin-bottom:5px" class="list_0">									
									<p>&nbsp;&nbsp;&nbsp;&nbsp;为您精心推荐的商品如下</p>
								</div>

								<table cellspacing="0" class="booklist">
								<tr height="30px"></tr>
									<tr>
										<c:forEach items="${orders}" var="order">
											<td class="all_list">
											<div class="list_1">
												<div class="divbookpic">
													<p>
														<a href="${pageContext.request.contextPath}/findProductById?id=${order.product.id}">
															<img src="${pageContext.request.contextPath}${order.product.imgurl}" width="115" height="129" border="0" /> 
														</a>
													</p>
												</div>
												<div class="divlisttitle">
													<a  class="divlisttitle_1" href="${pageContext.request.contextPath}/findProductById?id=${order.product.id}">&nbsp;&nbsp;&nbsp;&nbsp;${order.product.name}<br />售价：￥${order.product.price} </a>
												</div>
											</div>
											</td>
										</c:forEach>
									</tr>
								</table>
								
								
								<div class="pagination">
									<ul>
										<c:if test="${bean.currentPage!=1}">
											<li class="disablepage_p">
												<a class="disablepage_a" href="${pageContext.request.contextPath}/showUserProductByPage?currentPage=${bean.currentPage-1}&category=${bean.category}"></a>
											</li>
										</c:if>
										<c:if test="${bean.currentPage==1}">
											<li class="disablepage_p2"></li>
										</c:if>
										<c:forEach begin="1" end="${bean.totalPage}" var="pageNum">
											<c:if test="${pageNum==bean.currentPage}">
												<li class="currentpage">${pageNum }</li>
											</c:if>
											<c:if test="${pageNum!=bean.currentPage}">
												<li><a href="${pageContext.request.contextPath}/showUserProductByPage?currentPage=${pageNum}&category=${bean.category}">${pageNum}</a>
												</li>
											</c:if>
										</c:forEach>

										<c:if test="${bean.currentPage==bean.totalPage||bean.totalPage==0}">
											<li class="disablepage_n2"></li>
										</c:if>
										<c:if test="${bean.currentPage!=bean.totalPage&&bean.totalPage!=0}">
											<li class="disablepage_n">
												<a class="disablepage_a" href="${pageContext.request.contextPath}/showUserProductByPage?currentPage=${bean.currentPage+1}&category=${bean.category}"></a>
											</li>
										</c:if>
									</ul>
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	
	<td>
	</tr>
	</table>
	</div>