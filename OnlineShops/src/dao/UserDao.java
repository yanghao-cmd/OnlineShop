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
	// ����û�
	public void addUser(User user) throws SQLException {
		String sql = "insert into user(username,password,email,activecode) values(?,?,?,?)";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		int row = runner.update(sql, user.getUsername(), user.getPassword(),
				user.getEmail(),user.getActiveCode());
		if (row == 0) {
			throw new RuntimeException();
		}
	}

	// ���ݼ���������û�
	public User findUserByActiveCode(String activeCode) throws SQLException {
		String sql = "select * from user where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), activeCode);

	}

	// �����Ñ�
	public void activeUser(String activeCode) throws SQLException {
		String sql = "update user set state=? where activecode=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, 1, activeCode);
	}
	
	//�����û�������������û�
	public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
		String sql="select * from user where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class),username,password);
	}
	// ������ͨ�û�
	public List<User> findNormalUser() throws SQLException{
    	//List<Object> list = new ArrayList<Object>();
		String sql = "select * from user where role=\"��ͨ�û�\"";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<User>(User.class));
    }
	// ����������Ա
    public List<User> findSaler(String id) throws SQLException{
    	List<Object> list = new ArrayList<Object>();
		String sql = "select * from user where role=\"�����û�\"";

		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

		if (id != null && id.trim().length() > 0) {
			sql += " and id=?";
			list.add(id);
		}
		Object[] params = list.toArray();
		return runner.query(sql, new BeanListHandler<User>(User.class), params);
    }
    public Boolean editSaler(User user) throws SQLException {
 		//1.�������ϲ�����Ʒ��Ϣ��ӵ�������
 		List<Object> obj = new ArrayList<Object>();
 		obj.add(user.getUsername());
 		obj.add(user.getPassword());
 		obj.add(user.getEmail());

 		//2.����sql��䣬��ƴ��sql
 		String sql  = "update user " +
 				      "set  username=?,password=?,email=? where id=?";

 		obj.add(user.getId());		
 		//System.out.println(sql);		
 		//System.out.println(obj);
 		//3.����QueryRunner����
 		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
 		//4.ʹ��QueryRunner�����update()������������
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

