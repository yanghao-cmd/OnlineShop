<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
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

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
</script>
<header>
<div class="header">
                                <div class="container">                                
                                    <div class="logo"><a href="${pageContext.request.contextPath}/showProductByPage?category=mobilephone">OnlineShop</a></div>
                                    <ul class="head_left">
                                        <li class="head-nav-home"><a href="${pageContext.request.contextPath}/showProductByPage?category=mobilephone">首页</a></li>
                                        
                                        <!-- <li><a href="${pageContext.request.contextPath}/client/cart.jsp">购物车</a></li>  -->         
                                    </ul>
                                </div>
                                
                                
                                <div>
                                    
<div class="search">
<form action="${pageContext.request.contextPath }/MenuSearchServlet" id="searchform">
		<table>
		    <tr>
		        <td>
				<input type="text" name="textfield" class="inputtable" id="textfield" value="Search"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');" />
				</td>
				<td>
				<button class="search" onclick="search()">Go</button>
				</td>
			</tr>	
		</table>	
</form>
</div>
                                   <ul class="head_right">
                                        <li class="head-compose"><a href="${pageContext.request.contextPath}/client/register.jsp" id="registerLink">新会员注册</a></li>
                                        <li class="head-compose"><a href="${pageContext.request.contextPath}/client/login.jsp" id="loginLink">登录</a></li>
                                    </ul>
                                </div>
</div>
</header>