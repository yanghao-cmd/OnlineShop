package client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import service.OrderService;
/**
 * 删除订单
 *
 */
public class DelOrderByIdServlet extends HttpServlet {
	private static final long serialVersionUID = -742965707205621644L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 订单id
		String id = request.getParameter("id");
		// 已支付的订单带有type值为client的参数
		String type = request.getParameter("type");
		OrderService service = new OrderService();
		if (type != null && type.trim().length() > 0) {
			Logger logger = Logger.getLogger("salelogger");
			service.delOrderById(id);
			logger.info("销售人员删除了一份已支付的订单");
			if ("admin".equals(type)) {
				request.getRequestDispatcher("/findOrders").forward(request, response);
				return;
			}
		} else {
			// 调用service层方法删除相应订单
			service.delOrderByIdWithClient(id);
		}
		request.getRequestDispatcher("/findOrderByUser").forward(request, response);
		return;
	}
}
