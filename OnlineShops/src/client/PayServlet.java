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
 * 付款（模拟支付）
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
			// 日志
			Logger logger1 = Logger.getLogger("onelogger");
			try{
				logger1.info("用户[" + user.getUsername() + "]花费了[" + p.getPrice() + "]元,购买了["+p.getCategory()+"]类商品[" + p.getId() + "]");
			}catch(Exception e){
				logger1.info("错误信息:"+e.toString());
			}
			int count = service.findAllOrderById(Integer.toString(user.getId()), p.getId());
			System.out.println("pay count:"+count);
			double wholeprice = p.getPrice()*count;
			System.out.println("wholeprice:"+wholeprice);
			//表示已购买了超过5次的同类商品,或者单个商品消费超过2万元，将被记录为销售异常的情况
			if(count>5&&wholeprice>20000) {
			    //异常日志
			    Logger logger = Logger.getLogger("exception");
			    logger.info("用户["+user.getUsername()+"](id为["+user.getId()+"])已经购买了["+count+"]次商品["+p.getId()+"]，消费已达["+wholeprice+"]元，请注意合理消费！");
			 // 提醒用户注意合理消费
				try {
				    String emailMsg = "您已经同一时间购买商品["+p.getId()+"]超过["+count+"]次，在商店总共消费了[" +wholeprice+ "]元，请注意合理消费！";
				    MailUtils.sendMail(user.getEmail(),emailMsg);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	
		}		
		// 将要提交的数据得到
		// 获得支付必须基本数据
		// 获取Logger对象	
		Logger logger = Logger.getLogger("onelogger");
		try{			
			String orderid = request.getParameter("orderid");
			String money = request.getParameter("money");
			// 银行
			String bank = request.getParameter("yh");		
			request.setAttribute("bank", bank);
			request.setAttribute("orderid", orderid);	
			request.setAttribute("money", money);
			request.getRequestDispatcher("/orderstate").forward(request, response);	
			logger.info("交易成功，祝你购物愉快"
					+ "，欢迎再次光临！");
		}catch(Exception e){
			logger.info("错误信息"+e.toString());
		}
	}
}
