package client;

import java.io.IOException;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Order;
import domain.Similar;
import service.OrderService;
import service.SimilarService;

public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	
		SimilarService service = new SimilarService();
		Similar similar = null;
		try {
			similar = service.findSimilarById(id);
		} catch (LoginException e) {
			e.printStackTrace();
		}
		System.out.println("recommend:"+similar);
		if(similar!=null) {
			String sid = similar.getSimi();
			System.out.println("recommend sid:"+sid);
			OrderService service3 = new OrderService();			
			//找到相似用户近期的三个订单 作为推荐
			List<Order> orders = service3.findOrderByIds(sid);
			System.out.println("recommend service3:"+orders);
			request.setAttribute("orders", orders);
		}		
		request.getRequestDispatcher("/client/like.jsp").forward(request, response);
	}
}