package manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import analyze.ComputeSimilar;
import analyze.UserPortrait;
import service.SimilarService;


public class UserLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserPortrait up = new UserPortrait();
		HashMap<String, HashMap<String,Double>> dict = new HashMap<String, HashMap<String,Double>>();
		//dict存放{user1:{type:score}...}
		dict = up.getPortrait();
		
		SimilarService service = new SimilarService();
		//先清空表
		try {
			service.delSimilar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取日期
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tm", date);
		String day = String.format("%te", date);
		
		
		//记录到文件
		String fileName=year+"年"+month+"月"+day+"日用户画像.csv";	

		response.setContentType(this.getServletContext().getMimeType(fileName));
		response.setHeader("Content-Disposition", "attachement;filename="+new String(fileName.getBytes("GBK"),"iso8859-1"));		
		response.setCharacterEncoding("gbk");

		PrintWriter out = response.getWriter();
		out.println("用户编号,相似用户,相似度");
		
		
		for(String u1:dict.keySet()) {
			HashMap<String,Double> score1 = dict.get(u1);
			//相似度最大值为 根号14
			double similar = 3.74165;
			String sim_user = null;
			for(String u2:dict.keySet()) {
				//同一用户不做比较
				if(!u1.equals(u2)) {
					HashMap<String,Double> score2 = dict.get(u2);
					//计算向量差
					ComputeSimilar cs = new ComputeSimilar();
					double new_similar = cs.getSimilar(score1, score2);
					//找出最小的值，表示差异最小
					if(new_similar < similar) {
						similar = new_similar;
						sim_user = u2;
					}
				}
			}//for结束
			//加入数据库表中
			try {
				service.addSimilar(u1, sim_user, similar);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//写入文件
			out.println(u1+","+sim_user+","+similar);
		}
		out.flush();
		out.close();
		System.out.println("dict:"+dict);
	}
}