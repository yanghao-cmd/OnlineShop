package manager;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Product;
import service.OrderService;

public class SaleTrendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		// ����SimpleDateFormat���Ͷ��� "yyyy-MM-dd HH:ss:mm.SSS"������ʽ���ֱ��ʾ������ʱ�������
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date endDate = new Date();
		String endtime = df.format(endDate);
		//ʵ�����ڼӼ�
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endDate);
		calendar.add(Calendar.MONTH,-1);
		Date startDate=calendar.getTime();
		String starttime = df.format(startDate);
		System.out.println("end:"+endtime+",start:"+starttime);
		OrderService service = new OrderService();
		List<Product> list = null;
		try {
			list = service.SaleTrend(startDate, endDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println("saletrend:"+list);
		request.setAttribute("list", list);
		if(type==null){
		    request.getRequestDispatcher("/manager/sale/trend.jsp").forward(request, response);	
		}
		else {
			request.getRequestDispatcher("/manager/sale/admintrend.jsp").forward(request, response);
		}
	}
}