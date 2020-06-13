<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<meta http-equiv="content-Type" content="text/html;charset=UTF-8"/>
<head>
	<title>科技点亮未来</title>
	<%--导入css --%>
	<link rel="stylesheet" href="client/css/main.css" type="text/css" />
</head>

<body class="main">
	<jsp:include page="menu_search.jsp" />
	<table>
	<tr class="product_search_list">
	<td>
	<div id="divpagecontent4">
		<ul>
		   <!-- <li><img src="images/registerSuccess.jpg" width="200" height="100" /></li> -->
           <li><a class="active" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品分类</a></li>           
           <li><a href="${pageContext.request.contextPath}/showProductByPage?category=mobilephone">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手&nbsp;&nbsp;机</a></li>
           <li><a href="${pageContext.request.contextPath}/showProductByPage?category=computer">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;脑</a></li>
           <li><a href="${pageContext.request.contextPath}/showProductByPage?category=television">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;影&nbsp;&nbsp;音</a></li>
           <li><a href="${pageContext.request.contextPath}/showProductByPage?category=game">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电&nbsp;&nbsp;竞</a></li>
           <li><a href="${pageContext.request.contextPath}/showProductByPage?category=camera">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数&nbsp;&nbsp;码</a></li>
       </ul>
	</div>
	</td>
	
	<td class="divpagecontent5">
	
	<div>
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td>
					<table cellspacing="0" class="listcontent">
						<tr>
							<td>
								<h2>小米科技-为发烧而生</h2>
								<div style="margin-top:20px; margin-bottom:5px" class="list_0">									
									<p>&nbsp;&nbsp;&nbsp;&nbsp;商品列表</p>
								</div>

								<table cellspacing="0" class="booklist">
								<tr height="30px"></tr>
									<tr>
										<c:forEach items="${bean.ps}" var="p" varStatus="vs">
											<td class="all_list">
											<div class="list_1">
												<div class="divbookpic">
													<p>
														<a href="${pageContext.request.contextPath}/visitorFindProductById?id=${p.id}">
															<img src="${pageContext.request.contextPath}${p.imgurl}" width="115" height="129" border="0" /> 
														</a>
													</p>
												</div>
												<div class="divlisttitle">
													<a  class="divlisttitle_1" href="${pageContext.request.contextPath}/visitorFindProductById?id=${p.id}">&nbsp;&nbsp;&nbsp;&nbsp;${p.name}<br />售价：￥${p.price} </a>
												</div>
											</div>
											</td>
										</c:forEach>
									</tr>
								</table>
								
								<div class="pagination">
									<ul>
										<c:if test="${bean.currentPage!=1}">
											<li class="nextPage">
												<a href="${pageContext.request.contextPath}/MenuSearchServlet?currentPage=${bean.currentPage-1}&textfield=${bean.searchfield}">&lt;&lt;上一页</a>
											</li>
										</c:if>
										<c:if test="${bean.currentPage==1}">
											<li class="disablepage">&lt;&lt;上一页</li>
										</c:if>
										<c:forEach begin="1" end="${bean.totalPage}" var="pageNum">

											<c:if test="${pageNum==bean.currentPage}">
												<li class="currentpage">${pageNum }</li>
											</c:if>
											<c:if test="${pageNum!=bean.currentPage}">
												<li><a href="${pageContext.request.contextPath}/MenuSearchServlet?currentPage=${pageNum}&textfield=${bean.searchfield}">${pageNum}</a>
												</li>
											</c:if>

										</c:forEach>

										<c:if test="${bean.currentPage==bean.totalPage||bean.totalPage==0}">
											<li class="disablepage">下一页 &gt;&gt;</li>
										</c:if>

										<c:if test="${bean.currentPage!=bean.totalPage&&bean.totalPage!=0}">
											<li class="nextpage">
												<a href="${pageContext.request.contextPath}/MenuSearchServlet?currentPage=${bean.currentPage+1}&textfield=${bean.searchfield}">下一页&gt;&gt;</a>
											</li>
										</c:if>
									</ul>
								</div></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
	</td>
	</tr>
	</table>
</body>
</html>
