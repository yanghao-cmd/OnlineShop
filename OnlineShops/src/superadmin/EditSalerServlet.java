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
import domain.User;
import service.UserService;
@WebServlet(name="editSaler",urlPatterns="/editSaler")
public class EditSalerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("password");
		String email = request.getParameter("email");
		//System.out.println("id:"+id+"name:"+name+"pw:"+pw+"gtype:"+gtype+"email:"+email);
		
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(name);
		user.setPassword(pw);
		user.setEmail(email);
		
		UserService service = new UserService();
		try {
			service.editSaler(user);
		} catch (SQLException e) {
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
	  	logger.info("����Ա["+userid+"] IP��ַ["+ip+"],�༭������Ա["+id+"]");
		
		
		response.sendRedirect(request.getContextPath() + "/findSaler");
	}

}
