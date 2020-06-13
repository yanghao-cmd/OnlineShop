package analyze;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
//import com.sun.javafx.collections.MappingChange.Map;
import dao.OrderDao;
import dao.UserDao;
import domain.Order;
import domain.User;


public class UserPortrait {
    private static List<Order> orders = null;
    private static List<User> us = null;
	
	private static void readData(String uid, String category) {
		OrderDao o_dao = new OrderDao();
		UserDao u_dao = new UserDao();
		
		try {
			orders = o_dao.findOrderByManyConditions(uid, category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			us = u_dao.findNormalUser();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static HashMap<String,Double> getScore(HashMap<String,Double> score) {
		double total = 0;
		//πÈ“ªªØ
		for(String str:score.keySet()) {
			total += score.get(str);
		}
		
		for(String str:score.keySet()) {
			double point = score.get(str)/total;
			score.put(str, point);
		}
		
		return score;
	}
	
	public HashMap<String, HashMap<String,Double>> getPortrait() {
		readData(null, null);
		HashMap<String, HashMap<String,Double>> dict = new HashMap<String, HashMap<String,Double>>();
		
		for(int i=0;i<us.size();i++) {
			User user = us.get(i);
			HashMap<String,Double> score =  new HashMap<String,Double>();
			score.put("mobilephone", 0.0);
			score.put("computer", 0.0);
			score.put("television", 0.0);
			score.put("game", 0.0);
			score.put("camera", 0.0);
			
			for(int j=0;j<orders.size();j++) {
				Order order = orders.get(j);
				if(order.getUser().getId()==user.getId()) {
					String key = order.getProduct().getCategory();
					double value = score.get(key)+1;
					score.put(key, value);
				}
			}			
			score = getScore(score);
			dict.put(Integer.toString(user.getId()), score);
		}
		return dict;
	}
	
	

}

