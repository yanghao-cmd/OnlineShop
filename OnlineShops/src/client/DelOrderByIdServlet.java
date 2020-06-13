package client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import service.OrderService;
/**
 * ɾ������
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
		// ����id
		String id = request.getParameter("id");
		// ��֧���Ķ�������typeֵΪclient�Ĳ���
		String type = request.getParameter("type");
		OrderService service = new OrderService();
		if (type != null && type.trim().length() > 0) {
			Logger logger = Logger.getLogger("salelogger");
			service.delOrderById(id);
			logger.info("������Աɾ����һ����֧���Ķ���");
			if ("admin".equals(type)) {
				request.getRequestDispatcher("/findOrders").forward(request, response);
				return;
			}
		} else {
			// ����service�㷽��ɾ����Ӧ����
			service.delOrderByIdWithClient(id);
		}
		request.getRequestDispatcher("/findOrderByUser").forward(request, response);
		return;
	}
}
