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
		// ��ȡtype����ֵ���˴���type����������ͨ�û��ͳ����û�
		String type = request.getParameter("type");
		// ��ȡsession����
		HttpSession session = request.getSession();
		// ����session
		session.invalidate();
		// flag��ʶ
		String flag = request.getParameter("flag");
		// ��ͨ�û�Ĭ�ϲ�����typeֵ
		if(type==null){
			if (flag == null || flag.trim().isEmpty()) {
				// �ض�����ҳ
				Logger logger = Logger.getLogger("onelogger");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				logger.info("*******************************�û����˳���¼*******************************");
			}}
		else if(type=="admin"){
			if (flag == null || flag.trim().isEmpty()) {
				// �ض�����ҳ
				Logger logger = Logger.getLogger("salelogger");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				logger.info("*******************************������Ա���˳���¼*******************************");
			}
		}
		else {
			if (flag == null || flag.trim().isEmpty()) {
				// �ض�����ҳ
				Logger logger = Logger.getLogger("adminlogger");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
				logger.info("*******************************������Ա���˳���¼*******************************");
			}
		}
	}
}