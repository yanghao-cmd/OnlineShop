package client;
import java.io.IOException;
import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.User;
import service.UserService;
import org.apache.log4j.Logger;
import utils.IpUtil;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.��ȡ��¼ҳ��������û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2.����service��ɵ�¼������
		UserService service = new UserService();
		try {
			User user = service.login(username, password);
			
			// 3.��¼�ɹ������û��洢��session��.
			request.getSession().setAttribute("user", user);
			// ��ȡ�û��Ľ�ɫ�������û��Ľ�ɫ����ͨ�û��ͳ����û�����
			String role = user.getRole();
			// ����ǳ����û����ͽ��뵽������ǵĺ�̨����ϵͳ����������ҵ��˻�ҳ��
			if ("�����û�".equals(role)) {
				Logger logger = Logger.getLogger("salelogger");
				try{
					logger.info("*******************************" + "������Ա" + username + "��¼�ɹ�*******************************");
				    }catch(Exception e){
					    logger.info("������Ϣ"+e.toString());}
				response.sendRedirect(request.getContextPath() + "/admin/login/home.jsp");
				try {
			        String ipAddr = IpUtil.getIpAddr(request);
			        logger.info("������Ա��IP��ַΪ��" + ipAddr);
			    }catch (Exception e) {
			        e.printStackTrace();
			    }
				return;
			} else if("��ͨ�û�".equals(role)) {
				Logger logger = Logger.getLogger("onelogger");
				try{
					logger.info("*******************************" + "�û�" + username + "��¼�ɹ�*******************************");
				    }catch(Exception e){
					    logger.info("������Ϣ"+e.toString());}
				response.sendRedirect(request.getContextPath() + "/client/myAccount.jsp");
				try {
			        String ipAddr = IpUtil.getIpAddr(request);
			        logger.info("�û���IP��ַΪ��" + ipAddr);
			    }catch (Exception e) {
			        e.printStackTrace();
			    }
				return;
			}
			else {
				Logger logger = Logger.getLogger("adminlogger");
				try{
					logger.info("*******************************" + "������Ա" + username + "��¼�ɹ�*******************************");
				    }catch(Exception e){
					    logger.info("������Ϣ"+e.toString());}
				response.sendRedirect(request.getContextPath() + "/manager/sale/home.jsp");
				try {
			        String ipAddr = IpUtil.getIpAddr(request);
			        logger.info("������Ա��IP��ַΪ��" + ipAddr);
			    }catch (Exception e) {
			        e.printStackTrace();
			    }
				return;
			}
		} catch (LoginException e) {
			// ����������⣬��������Ϣ�洢��request��Χ������ת�ص�¼ҳ����ʾ������Ϣ
			e.printStackTrace();
			request.setAttribute("register_message", e.getMessage());
			request.getRequestDispatcher("/client/login.jsp").forward(request, response);
			return;
		}
	}
}
