package service;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.security.auth.login.LoginException;
import dao.UserDao;
import domain.User;
import exception.ActiveUserException;
import exception.RegisterException;
import utils.MailUtils;

public class UserService {
	private UserDao dao = new UserDao();
	// 注册操作
	public void register(User user) throws RegisterException {
		// 调用dao完成注册操作
		try {
			dao.addUser(user);
			// 发送激活邮件
			String emailMsg = "恭喜您，注册OnlineShop成功！";
			MailUtils.sendMail(user.getEmail(), emailMsg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RegisterException("注冊失败");
		}
	}
	// 激活用户
	public void activeUser(String activeCode) throws ActiveUserException {
		try {
			// 根据激活码查找用户
			User user = dao.findUserByActiveCode(activeCode);
			if (user == null) {
				throw new ActiveUserException("激活用户失败");
			}
			// 判断激活码是否过期 24小时内激活有效.
			// 1.得到注册时间
			Date registTime = user.getRegistTime();
			// 2.判断是否超时
			long time = System.currentTimeMillis() - registTime.getTime();
			if (time / 1000 / 60 / 60 > 24) {
				throw new ActiveUserException("激活码过期");
			}
			// 激活用户，就是修改用户的state状态
			dao.activeUser(activeCode);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ActiveUserException("激活用户失败");
		}
	}
	// 登录操作
	public User login(String username, String password) throws LoginException {
		try {
			//根据登录时表单输入的用户名和密码，查找用户
			User user = dao.findUserByUsernameAndPassword(username, password);
			//如果找到，还需要确定用户是否为激活用户
			if (user != null) {
				// 只有是激活才能登录成功，否则提示“用户未激活”
				/*if (user.getState() == 0) {
					return user;
				}
				throw new LoginException("用户未激活");*/
				return user;
			}
			throw new LoginException("用户名或密码错误");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登录失败");
		}
	}
	
	public List<User> findSaler(String id) throws SQLException{
    	List<User> list = null;
    	try {
			//从数据库查找用户
			list= dao.findSaler(id);
			//System.out.println("list"+list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;
    }
	
    public void editSaler(User user) throws SQLException{
    	try {
    	    boolean result = dao.editSaler(user);
    	    if(result == true)
    		{
    			System.out.print("执行成功");
    		}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    public void delSaler(String id) throws SQLException{
    	try {
    		boolean result = dao.delSaler(id);
    		if(result == false)
    		{
    			System.out.print("删除成功");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}    	
    }
    public void addSaler(User user) throws RegisterException{
    	try {
    		dao.addSaler(user);
    		System.out.print("add完成");
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw new RegisterException("注册失败");
    	}
    }
}
