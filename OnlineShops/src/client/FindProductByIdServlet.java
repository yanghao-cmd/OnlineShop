package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import domain.User;
import domain.Product;
import exception.FindProductByIdException;
import service.ProductService;
/**
 * ������Ʒid����ָ����Ʒ��Ϣ��servlet
 */
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �õ���Ʒ��id
		String id = request.getParameter("id");
		// ��ȡtype����ֵ���˴���type����������ͨ�û��ͳ����û�
		String type = request.getParameter("type");		
		ProductService service = new ProductService();	
		Logger logger = Logger.getLogger("onelogger");
		try{
			try {
				// ����service�㷽����ͨ��id������Ʒ
				Product p = service.findProductById(id);
				request.setAttribute("p", p);
				// ��ͨ�û�Ĭ�ϲ�����typeֵ������ת��info.jspҳ��
				if (type == null) {	
					HttpSession session = request.getSession();
					User user = (User) session.getAttribute("user");
					
					//��־
					switch(p.getCategory()) {
					case "mobilephone":
						Logger logger1 = Logger.getLogger("onelogger");
						try{
							logger1.info("�û�[" + user.getUsername() + "]���ڲ�ѯ��Ʒ[" + p.getName() + "] ��Ʒ���Ϊ[" + p.getId() + "]");
						}catch(Exception e){
							logger1.info("������Ϣ:"+e.toString());
						}
						break;
					case "computer":
						Logger logger2 = Logger.getLogger("onelogger");
						try{
							logger2.info("�û�[" + user.getUsername() + "]���ڲ�ѯ��Ʒ[" + p.getName() + "] ��Ʒ���Ϊ[" + p.getId() + "]");
						}catch(Exception e){
							logger2.info("������Ϣ:"+e.toString());
						}
						break;
					case "television":
						Logger logger3 = Logger.getLogger("onelogger");
						try{
							logger3.info("�û�[" + user.getUsername() + "]���ڲ�ѯ��Ʒ[" + p.getName() + "] ��Ʒ���Ϊ[" + p.getId() + "]");
						}catch(Exception e){
							logger3.info("������Ϣ:"+e.toString());
						}
						break;
					case "game":
						Logger logger4 = Logger.getLogger("onelogger");
						try{
							logger4.info("�û�[" + user.getUsername() + "]���ڲ�ѯ��Ʒ[" + p.getName() + "] ��Ʒ���Ϊ[" + p.getId() + "]");
						}catch(Exception e){
							logger4.info("������Ϣ:"+e.toString());
						}
						break;
					case "camera":
						Logger logger5 = Logger.getLogger("onelogger");
						try{
							logger5.info("�û�[" + user.getUsername() + "]���ڲ�ѯ��Ʒ[" + p.getName() + "] ��Ʒ���Ϊ[" + p.getId() + "]");
						}catch(Exception e){
							logger5.info("������Ϣ:"+e.toString());
						}
						break;
					}			
					
					request.getRequestDispatcher("/client/info.jsp").forward(request,response);	
					return;
				}						
				request.getRequestDispatcher("/admin/products/edit.jsp").forward(request, response);
				return;
			} catch (FindProductByIdException e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			logger.info("������Ϣ"+e.toString());
		}
	}
}
