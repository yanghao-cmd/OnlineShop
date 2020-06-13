package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.User;
import utils.DataSourceUtils;

public class UserDao {
	// 添加用户
	public void addUser(User user) throws SQLException {
		String sql = "insert into user(username,password,email,activecode) values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, user.getUsername(), user.getPassword(),
				user.getEmail(),user.getActiveCode());
		if (row == 0) {
			throw new RuntimeException();
		}
	}

	// 根据激活码查找用户
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), activeCode);

	}

	// 激活用戶
	public void activeUser(String activeCode) throws SQLException {
		String sql = "update user set state=? where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, 1, activeCode);
	}
	
	//根据用户名与密码查找用户
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		String sql="select * from user where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}
	// 查找普通用户
	public List<User> findNormalUser() throws SQLException{
    	//List<Object> list = new ArrayList<Object>();
		String sql = "select * from user where role=\"普通用户\"";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<User>(User.class));
    }
	// 查找销售人员
    public List<User> findSaler(String id) throws SQLException{
    	List<Object> list = new ArrayList<Object>();
		String sql = "select * from user where role=\"超级用户\"";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if (id != null && id.trim().length() > 0) {
			sql += " and id=?";
			list.add(id);
		}
		Object[] params = list.toArray();
		return runner.query(sql, new BeanListHandler<User>(User.class), params);
    }
    public Boolean editSaler(User user) throws SQLException {
 		//1.创建集合并将商品信息添加到集合中
 		List<Object> obj = new ArrayList<Object>();
 		obj.add(user.getUsername());
 		obj.add(user.getPassword());
 		obj.add(user.getEmail());

 		//2.创建sql语句，并拼接sql
 		String sql  = "update user " +
 				      "set  username=?,password=?,email=? where id=?";

 		obj.add(user.getId());		
 		//System.out.println(sql);		
 		//System.out.println(obj);
 		//3.创建QueryRunner对象
 		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
 		//4.使用QueryRunner对象的update()方法更新数据
 		int count = runner.update(sql, obj.toArray());
 		
 		if(count > 0)
    		return true;
    	return false;
 	}
    public Boolean delSaler(String id) throws SQLException{
    	String sql = "delete from user where id=?";
    	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    	int count = runner.update(sql, id);
    	if(count > 0)
    		return true;
    	return false;
    }
    public void addSaler(User user) throws SQLException{
    	String sql = "insert into user(username,password,email,activecode) values(?,?,?,?)";
    	QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
    	int row = runner.update(sql, user.getUsername(), user.getPassword(),
				user.getEmail(),user.getActiveCode());
		if (row == 0) {
			throw new RuntimeException();
		}

    }
	
}

