<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>科技点亮未来</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/main.css" type="text/css" />
</head>
<body class="main">	
	<jsp:include page="menu_search.jsp" />
	<div class="divcontent_s">
		<form action="${pageContext.request.contextPath}/login" method="post">
			<table width="850px" border="0" cellspacing="0">
				<tr>
					<td style="padding:30px"><div style="height:470px">							
							<div>
								<table  border="0" cellspacing="0">
									<tr>
										<td>
											<div>
												<table border="0" cellspacing="0">													
													<tr>
														<td style="text-align:center;padding-top:20px;"><font
															color="#ff0000">${requestScope["register_message"]}</font>
														</td>
													</tr>
													<tr>
														<td class="login" style="text-align:center"><h2>个人用户登录</h2>
															<table border="0" cellspacing="0"
																style="margin-top:15px ;margin-left:auto; margin-right:auto">															
																<tr>
																	<td
																		style="text-align:right; padding-top:5px; width:25%">用户名&emsp;</td>
																	<td style="text-align:left"><input name="username"
																		type="text" class="textinput" />
																	</td>
																</tr>
																<tr height="15px"></tr>
																<tr>
																	<td style="text-align:right; padding-top:5px">密&nbsp;&nbsp;&nbsp;&nbsp;码&emsp;</td>
																	<td style="text-align:left"><input name="password"
																		type="password" class="textinput" />
																	</td>
																</tr>
																<tr height="15px"></tr>
																<tr>
																	<td colspan="2" style="text-align:center">
																		<input type="checkbox" name="checkbox" value="checkbox01" />记住用户名
																		&nbsp;&nbsp; 
																		<input type="checkbox" name="checkbox" value="checkbox02" /> 自动登录
																	</td>
																</tr>
																<tr height="15px"></tr>
																<tr>
																	<td colspan="2"
																		style="padding-top:10px; text-align:center">
																		<button class="submit1" onclick="return formcheck()">登录</button>																		
																	</td>
																</tr>
                                                                <tr height="50px"></tr>																																 
															</table>
															<table>
															    <tr>                                                                    
                                                                    <td style="text-align:left; padding-top:30px; width:60%">
											                            <p>您还没有注册？</p>											
											                            <p style="text-align:left">
												                           <a href="${pageContext.request.contextPath }/client/register.jsp">
													                          <input type="button" class="submit2" name="submit" value="注册"/>
												                           </a>
											                            </p>
										                            </td>                                                                
                                                                </tr>
															</table>
														</td>
													</tr>
												</table>
											</div>
										</td>										
									</tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
