package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import domain.Product;
import domain.Order;
import domain.User;
import utils.DataSourceUtils;
/**
 * ����
 * @author admin
 *
 */
public class OrderDao {
	/**
	 *  ���ɶ���
	 * @param order
	 * @throws SQLException
	 */
	public void addProduct(Order order) throws SQLException {
		// 1.����Sql���
		String sql = "insert into orders values(?,?,?,?,?,0,null,?)";
		// 2.����ִ��sql����QueryRunner,�����ݲ���
		QueryRunner runner = new QueryRunner();
        // 3.ִ��update()������������
		runner.update(DataSourceUtils.getConnection(), sql, order.getId(),
				order.getMoney(), order.getReceiverAddress(), order
						.getReceiverName(), order.getReceiverEmail(), order
						.getUser().getId());
	}
	/**
	 * �����û���������
	 */
	public List<Order> findOrderByUser(final User user) throws SQLException {
		String sql = "select * from orders where user_id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getString("id"));
					order.setMoney(rs.getDouble("money"));
					order.setOrdertime(rs.getDate("ordertime"));
					order.setPaystate(rs.getInt("paystate"));
					order.setReceiverAddress(rs.getString("receiverAddress"));
					order.setReceiverName(rs.getString("receiverName"));
					order.setReceiverEmail(rs.getString("receiverEmail"));
					order.setUser(user);
					orders.add(order);
				}
				return orders;
			}
		}, user.getId());
	}
	/**
	 * ����id���Ҷ�����Ϣ
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Order findOrderById(String id) throws SQLException {
		String sql = "select * from orders,user where orders.user_id=user.id and orders.id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ResultSetHandler<Order>() {
			public Order handle(ResultSet rs) throws SQLException {
				Order order = new Order();
				while (rs.next()) {
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setReceiverAddress(rs.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverEmail(rs.getString("orders.receiverEmail"));

					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setActiveCode(rs.getString("user.activecode"));
					user.setPassword(rs.getString("user.password"));
					user.setRegistTime(rs.getDate("user.registtime"));
					user.setRole(rs.getString("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);
				}
				return order;
			}
		}, id);
	}
	
	public int findAllOrderById(String id,String gNo) throws SQLException {

		String sql = "select orderitem.buynum from orders,user,products,orderitem "
				+ "where user.id=orders.user_id and orders.id=orderitem.order_id and products.id=orderitem.product_id and user.id=? and products.id=?";		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int count = (int) runner.query(sql, new ScalarHandler(), id, gNo);
		return count;
	}
	
	public List<Order> findOrderByIds(String id)
			throws SQLException {
		List<Object> objs = new ArrayList<Object>();
		String sql = "select orders.*,user.*,products.* from orders,user,products,orderitem "
				+ "where user.id=orders.user_id and orders.id=orderitem.order_id and products.id=orderitem.product_id and orders.user_id=? "
				+ "order by ordertime desc LIMIT 0,5";
		objs.add(id);	
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());		
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();             
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setReceiverAddress(rs.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverEmail(rs.getString("orders.receiverEmail"));
					orders.add(order);
					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setActiveCode(rs.getString("user.activecode"));
					user.setPassword(rs.getString("user.password"));
					user.setRegistTime(rs.getDate("user.registtime"));
					user.setRole(rs.getString("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);					
					Product product=new Product();
					product.setId(rs.getString("products.id"));
					product.setName(rs.getString("products.name"));
					product.setPrice(rs.getDouble("products.price"));
					product.setCategory(rs.getString("products.category"));
					product.setPnum(rs.getInt("products.pnum"));
					product.setImgurl(rs.getString("products.imgurl"));
					order.setProduct(product);
				}
				return orders;
			}
		}, objs.toArray());
	}
	
	public List<Product> SaleTrend(Date starttime,Date endtime) throws SQLException {
		String sql = "select products.id,products.name,COUNT(products.id) number from orders,products,orderitem " + 
				"where orders.id=orderitem.order_id and products.id=orderitem.product_id and orders.ordertime>=? and orders.ordertime<=? " + 
				"GROUP BY products.id,products.name " + 
				"order by number desc LIMIT 0,10";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new ResultSetHandler<List<Product>>() {
			public List<Product> handle(ResultSet rs) throws SQLException {
				List<Product> ps = new ArrayList<Product>();               
				while (rs.next()) {
					Product p = new Product();
					p.setId(rs.getString("products.id"));
					p.setName(rs.getString("products.name"));
					p.setNum(rs.getInt("number"));
					ps.add(p);					
				}
				return ps;
			}
		}, starttime, endtime);
	}
	/**
	 *  �������ж���
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findAllOrder() throws SQLException {
		//1.����sql
		String sql = "select orders.*,user.* from orders,user where user.id=orders.user_id order by orders.user_id";
		//2.����QueryRunner����
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        //3.����QueryRunner����query()�����Ĳ�ѯ���
		return runner.query(sql, new ResultSetHandler<List<Order>>() {			
			public List<Order> handle(ResultSet rs) throws SQLException {
				//������������
				List<Order> orders = new ArrayList<Order>();
                //ѭ�������������û���Ϣ
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setReceiverAddress(rs.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverEmail(rs.getString("orders.receiverEmail"));
					orders.add(order);
					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setActiveCode(rs.getString("user.activecode"));
					user.setPassword(rs.getString("user.password"));
					user.setRegistTime(rs.getDate("user.registtime"));
					user.setRole(rs.getString("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);
				}
				return orders;
			}
		});
	}
	/**
	 *  ���ݶ������޸Ķ���״̬
	 * @param id
	 * @throws SQLException
	 */
	public void updateOrderState(String id) throws SQLException {
		String sql = "update orders set paystate=1 where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
		System.out.println(runner.update(sql, id));
	}
	/**
	 *  ��������ѯ
	 * @param id
	 * @param receiverName
	 * @return
	 * @throws SQLException
	 */
	public List<Order> findOrderByManyCondition(String id, String receiverName)
			throws SQLException {
		//1.�������϶���
		List<Object> objs = new ArrayList<Object>();
		//2.�����ѯsql
		String sql = "select orders.*,user.* from orders,user where user.id=orders.user_id ";
		//3.���ݲ���ƴ��sql���
		if (id != null && id.trim().length() > 0) {
			sql += " and orders.id=?";
			objs.add(id);
		}
		if (receiverName != null && receiverName.trim().length() > 0) {
			sql += " and receiverName=?";
			objs.add(receiverName);
		}
		sql += " order by orders.user_id";
		//4.����QueryRunner����
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		//5.����QueryRunner����query������ִ�н��
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();
               //ѭ���������������û���Ϣ
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setReceiverAddress(rs
							.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverEmail(rs.getString("orders.receiverEmail"));
					orders.add(order);
					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setActiveCode(rs.getString("user.activecode"));
					user.setPassword(rs.getString("user.password"));
					user.setRegistTime(rs.getDate("user.registtime"));
					user.setRole(rs.getString("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);
				}
				return orders;
			}
		}, objs.toArray());
	}
	/**
	 * ����idɾ������
	 * @param id
	 * @throws SQLException
	 */
	public void delOrderById(String id) throws SQLException {
		String sql="delete from orders where id=?";		
		QueryRunner runner = new QueryRunner();		
		runner.update(DataSourceUtils.getConnection(),sql,id);		
	}
	
	public List<Order> findOrderByManyConditions(String id, String category)
			throws SQLException {

		List<Object> objs = new ArrayList<Object>();
		String sql = "select orders.*,user.*,products.* from orders,user,products,orderitem where user.id=orders.user_id and orders.id=orderitem.order_id and products.id=orderitem.product_id ";

		if (id != null && id.trim().length() > 0) {
			sql += " and orders.id=?";
			objs.add(id);
		}
		if (category != null && category.trim().length() > 0) {
			sql += " and products.category=?";
			objs.add(category);
		}

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		return runner.query(sql, new ResultSetHandler<List<Order>>() {
			public List<Order> handle(ResultSet rs) throws SQLException {
				List<Order> orders = new ArrayList<Order>();
               
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getString("orders.id"));
					order.setMoney(rs.getDouble("orders.money"));
					order.setOrdertime(rs.getDate("orders.ordertime"));
					order.setPaystate(rs.getInt("orders.paystate"));
					order.setReceiverAddress(rs.getString("orders.receiverAddress"));
					order.setReceiverName(rs.getString("orders.receiverName"));
					order.setReceiverEmail(rs.getString("orders.receiverEmail"));
					orders.add(order);
					User user = new User();
					user.setId(rs.getInt("user.id"));
					user.setEmail(rs.getString("user.email"));
					user.setActiveCode(rs.getString("user.activecode"));
					user.setPassword(rs.getString("user.password"));
					user.setRegistTime(rs.getDate("user.registtime"));
					user.setRole(rs.getString("user.role"));
					user.setState(rs.getInt("user.state"));
					user.setUsername(rs.getString("user.username"));
					order.setUser(user);
					
					Product product=new Product();
					product.setId(rs.getString("products.id"));
					product.setName(rs.getString("products.name"));
					product.setPrice(rs.getDouble("products.price"));
					product.setCategory(rs.getString("products.category"));
					product.setPnum(rs.getInt("products.pnum"));
					product.setImgurl(rs.getString("products.imgurl"));
					order.setProduct(product);
				}
				return orders;
			}
		}, objs.toArray());
	}
}
