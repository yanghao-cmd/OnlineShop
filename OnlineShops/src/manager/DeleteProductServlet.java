package manager;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ProductService;
import org.apache.log4j.Logger;

/**
 * ��̨ϵͳ
 * ɾ����Ʒ��Ϣ��servlet
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Logger logger = Logger.getLogger("salelogger");
		// ��ȡ�����������Ʒid
		String id = request.getParameter("id");
		ProductService service = new ProductService();
		// ����service���ɾ����Ʒ����
		service.deleteProduct(id);
		logger.info("������Աɾ����һ����Ʒ");
		response.sendRedirect(request.getContextPath() + "/listProduct");
		return;
	}
}