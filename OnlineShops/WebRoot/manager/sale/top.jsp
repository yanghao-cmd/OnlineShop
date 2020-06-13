<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
<header>

<div class="header">
                                <div class="container">                                
                                    <div class="logo1"><a href="${pageContext.request.contextPath}/manager/sale/home.jsp">OnlineShop管&nbsp;理&nbsp;中&nbsp;心</a></div>    
                                    <ul class="head_left">
                                        <li class="head-nav-home"><a href="${pageContext.request.contextPath}/showUserProductByPage?category=mobilephone" target="_blank">前&nbsp;&nbsp;台</a></li>                                                  
                                    </ul>               
                                </div>
<div>                                    
                                   <ul class="head_right1">
                                        <li class="head-compose1"><a href="#">
                                        <img class="profile" src="${pageContext.request.contextPath}/client/images/registerSuccess.jpg" width="45" height="45" /></a></li>
                                        <li class="head-compose2"><a href="#">${user.username}</a></li>                                                                               
                                    </ul>
</div>
</div>
</header>