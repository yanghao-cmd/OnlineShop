package superadmin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import domain.RegisterForm;
import domain.User;
import exception.RegisterException;
import service.UserService;

@WebServlet(name="addSaler",urlPatterns="/addSaler")
public class AddSalerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RegisterForm form = new RegisterForm();
		form.setName(request.getParameter("name"));
    	form.setPassword(request.getParameter("password"));
    	form.setPassword2(request.getParameter("password2"));
    	form.setEmail(request.getParameter("email"));
    	form.setId(request.getParameter("id"));
    	
    	if(!form.validate()) {
    		request.setAttribute("form", form);
    		request.getRequestDispatcher("/manager/sale/addsaler.jsp").forward(request, response);
    		return;
    	}   	
    	User user = new User();
    	try {
    		BeanUtils.populate(user, request.getParameterMap());
    	}catch(IllegalAccessException e) {
    		e.printStackTrace();
    	}catch(InvocationTargetException e) {
    		e.printStackTrace();
    	} 	
    	UserService service = new UserService();
    	try {
    		service.addSaler(user);
    	}catch(RegisterException e) {
    		e.printStackTrace();
    		response.getWriter().write(e.getMessage());
    		return;
    	}   	
    	//操作日志
    	String userid = request.getParameter("user");
    	Logger logger = Logger.getLogger("adminlogger");
	    //获取电脑上的ip
	  	String ip=InetAddress.getLocalHost().getHostAddress();
	  	//System.out.println("电脑ip："+ip+"电脑名称："+name);
	  	logger.info("管理员["+userid+"] IP地址["+ip+"],新增了销售员["+request.getParameter("id")+"]");    	
    	response.sendRedirect(request.getContextPath() + "/findSaler");
	}

}
