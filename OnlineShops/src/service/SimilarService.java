package service;

import java.sql.SQLException;
import javax.security.auth.login.LoginException;
import dao.SimilarDao;
import domain.Similar;

public class SimilarService {
	SimilarDao dao = new SimilarDao();
	public void addSimilar(String user1,String user2,double score) throws SQLException{
    	try {
    		dao.addSimilar(user1, user2, score);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
	public void delSimilar() throws SQLException{
		try {
		    dao.delSimilar();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public Similar findSimilarById(int id) throws LoginException {
		//从数据库查找用户
		Similar si = null;
		try {
			si = dao.findSimilarById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return si;	
	}
}