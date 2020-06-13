package client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import java.util.Map;
import javax.servlet.http.HttpSession;
import utils.MailUtils;
import service.OrderService;
import domain.Order;
import utils.IdUtils;
import domain.Product;
import domain.User;

/**
 * ���ģ��֧����
 */
public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");		
		for (Product p : cart.keySet()){
			Order order = new Order();
			order.setUser(user);
			order.setProduct(p);
			order.setMoney(p.getPrice());
			order.setId(IdUtils.getUUID());
			OrderService service = new OrderService();
			// ��־
			Logger logger1 = Logger.getLogger("onelogger");
			try{
				logger1.info("�û�[" + user.getUsername() + "]������[" + p.getPrice() + "]Ԫ,������["+p.getCategory()+"]����Ʒ[" + p.getId() + "]");
			}catch(Exception e){
				logger1.info("������Ϣ:"+e.toString());
			}
			int count = service.findAllOrderById(Integer.toString(user.getId()), p.getId());
			System.out.println("pay count:"+count);
			double wholeprice = p.getPrice()*count;
			System.out.println("wholeprice:"+wholeprice);
			//��ʾ�ѹ����˳���5�ε�ͬ����Ʒ,���ߵ�����Ʒ���ѳ���2��Ԫ��������¼Ϊ�����쳣�����
			if(count>5&&wholeprice>20000) {
			    //�쳣��־
			    Logger logger = Logger.getLogger("exception");
			    logger.info("�û�["+user.getUsername()+"](idΪ["+user.getId()+"])�Ѿ�������["+count+"]����Ʒ["+p.getId()+"]�������Ѵ�["+wholeprice+"]Ԫ����ע��������ѣ�");
			 // �����û�ע���������
				try {
				    String emailMsg = "���Ѿ�ͬһʱ�乺����Ʒ["+p.getId()+"]����["+count+"]�Σ����̵��ܹ�������[" +wholeprice+ "]Ԫ����ע��������ѣ�";
				    MailUtils.sendMail(user.getEmail(),emailMsg);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	
		}		
		// ��Ҫ�ύ�����ݵõ�
		// ���֧�������������
		// ��ȡLogger����	
		Logger logger = Logger.getLogger("onelogger");
		try{			
			String orderid = request.getParameter("orderid");
			String money = request.getParameter("money");
			// ����
			String bank = request.getParameter("yh");		
			request.setAttribute("bank", bank);
			request.setAttribute("orderid", orderid);	
			request.setAttribute("money", money);
			request.getRequestDispatcher("/orderstate").forward(request, response);	
			logger.info("���׳ɹ���ף�㹺�����"
					+ "����ӭ�ٴι��٣�");
		}catch(Exception e){
			logger.info("������Ϣ"+e.toString());
		}
	}
}
