package client;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Order;
import domain.User;
import service.OrderService;
import utils.MailUtils;
public class FindPaidOrderByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取名为“user”的session
		User user = (User) request.getSession().getAttribute("user");		
		// 调用service中的方法,根据用户信息查找订单
		OrderService service = new OrderService();
		List<Order> orders = service.findOrderByUser(user);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("/client/orderlist.jsp").forward(request, response);
		try{
			String emailMsg = "恭喜您，订单完成支付，购买成功！";
		    MailUtils.sendMail(user.getEmail(), emailMsg);
		}catch (Exception e) {
			e.printStackTrace();
			}
		return;
	}
}
