package client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取type参数值，此处的type用于区别普通用户和超级用户
		String type = request.getParameter("type");
		// 获取session对象
		HttpSession session = request.getSession();
		// 销毁session
		session.invalidate();
		// flag标识
		String flag = request.getParameter("flag");
		// 普通用户默认不传递type值
		if(type==null){
			if (flag == null || flag.trim().isEmpty()) {
				// 重定向到首页
				Logger logger = Logger.getLogger("onelogger");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				logger.info("*******************************用户已退出登录*******************************");
			}}
		else if(type=="admin"){
			if (flag == null || flag.trim().isEmpty()) {
				// 重定向到首页
				Logger logger = Logger.getLogger("salelogger");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				logger.info("*******************************销售人员已退出登录*******************************");
			}
		}
		else {
			if (flag == null || flag.trim().isEmpty()) {
				// 重定向到首页
				Logger logger = Logger.getLogger("adminlogger");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				logger.info("*******************************管理人员已退出登录*******************************");
			}
		}
	}
}