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
 * 根据商品id查找指定商品信息的servlet
 */
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 得到商品的id
		String id = request.getParameter("id");
		// 获取type参数值，此处的type用于区别普通用户和超级用户
		String type = request.getParameter("type");		
		ProductService service = new ProductService();	
		Logger logger = Logger.getLogger("onelogger");
		try{
			try {
				// 调用service层方法，通过id查找商品
				Product p = service.findProductById(id);
				request.setAttribute("p", p);
				// 普通用户默认不传递type值，会跳转到info.jsp页面
				if (type == null) {	
					HttpSession session = request.getSession();
					User user = (User) session.getAttribute("user");
					
					//日志
					switch(p.getCategory()) {
					case "mobilephone":
						Logger logger1 = Logger.getLogger("onelogger");
						try{
							logger1.info("用户[" + user.getUsername() + "]正在查询商品[" + p.getName() + "] 商品编号为[" + p.getId() + "]");
						}catch(Exception e){
							logger1.info("错误信息:"+e.toString());
						}
						break;
					case "computer":
						Logger logger2 = Logger.getLogger("onelogger");
						try{
							logger2.info("用户[" + user.getUsername() + "]正在查询商品[" + p.getName() + "] 商品编号为[" + p.getId() + "]");
						}catch(Exception e){
							logger2.info("错误信息:"+e.toString());
						}
						break;
					case "television":
						Logger logger3 = Logger.getLogger("onelogger");
						try{
							logger3.info("用户[" + user.getUsername() + "]正在查询商品[" + p.getName() + "] 商品编号为[" + p.getId() + "]");
						}catch(Exception e){
							logger3.info("错误信息:"+e.toString());
						}
						break;
					case "game":
						Logger logger4 = Logger.getLogger("onelogger");
						try{
							logger4.info("用户[" + user.getUsername() + "]正在查询商品[" + p.getName() + "] 商品编号为[" + p.getId() + "]");
						}catch(Exception e){
							logger4.info("错误信息:"+e.toString());
						}
						break;
					case "camera":
						Logger logger5 = Logger.getLogger("onelogger");
						try{
							logger5.info("用户[" + user.getUsername() + "]正在查询商品[" + p.getName() + "] 商品编号为[" + p.getId() + "]");
						}catch(Exception e){
							logger5.info("错误信息:"+e.toString());
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
			logger.info("错误信息"+e.toString());
		}
	}
}
