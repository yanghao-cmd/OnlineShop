package superadmin;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import service.UserService;

/**
 * Servlet implementation class DelSalerServlet
 */
@WebServlet(name="delSaler",urlPatterns="/delSaler")
public class DelSalerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		UserService service = new UserService();
		try {
			service.delSaler(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//������־
    	String userid = request.getParameter("user");
    	Logger logger = Logger.getLogger("adminlogger");
    	//SimpleDateFormat  date=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");//����ʱ���ʽ
	    //System.out.println(date.format(new Date()));
	    //��ȡ�����ϵ�ip
	  	String ip=InetAddress.getLocalHost().getHostAddress();
	  	//System.out.println("����ip��"+ip+"�������ƣ�"+name);
	  	logger.info("����Ա["+userid+"] IP��ַ["+ip+"],ɾ��������Ա["+id+"]");		
		response.sendRedirect(request.getContextPath() + "/findSaler");
	}

}
