package superadmin;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import domain.User;
import service.UserService;

@WebServlet(name="findSaler",urlPatterns="/findSaler")
public class FindSalerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String op = request.getParameter("op");

		UserService service = new UserService();
		List<User> list = null;
		try {
			list = service.findSaler(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		if(type!=null) {
			User user = list.get(0);
			request.setAttribute("u", user);
			request.getRequestDispatcher("/manager/sale/useredit.jsp").forward(request,response);
		}
		else {
			if(op!=null) {
				if(op.equals("find")) {
				    //������־
		    		String userid = request.getParameter("user");
		    		Logger logger = Logger.getLogger("adminlogger");
			    	//��ȡ�����ϵ�ip
			  		String ip=InetAddress.getLocalHost().getHostAddress();
			  		//System.out.println("����ip��"+ip+"�������ƣ�"+name);
			  		logger.info("����Ա["+userid+"] IP��ַ["+ip+"],��������Ա��ѯ"
			  				+ " ��ѯ����Ϊ[id:"+id+"]");
				}
			}			
		    request.setAttribute("ul", list);	
		    request.getRequestDispatcher("/manager/sale/userlist.jsp").forward(request,response);
		}
	}

}
