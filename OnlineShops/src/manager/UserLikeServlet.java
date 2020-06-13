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
		//dict���{user1:{type:score}...}
		dict = up.getPortrait();
		
		SimilarService service = new SimilarService();
		//����ձ�
		try {
			service.delSimilar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��ȡ����
		Date date = new Date();
		String year = String.format("%tY", date);
		String month = String.format("%tm", date);
		String day = String.format("%te", date);
		
		
		//��¼���ļ�
		String fileName=year+"��"+month+"��"+day+"���û�����.csv";	

		response.setContentType(this.getServletContext().getMimeType(fileName));
		response.setHeader("Content-Disposition", "attachement;filename="+new String(fileName.getBytes("GBK"),"iso8859-1"));		
		response.setCharacterEncoding("gbk");

		PrintWriter out = response.getWriter();
		out.println("�û����,�����û�,���ƶ�");
		
		
		for(String u1:dict.keySet()) {
			HashMap<String,Double> score1 = dict.get(u1);
			//���ƶ����ֵΪ ����14
			double similar = 3.74165;
			String sim_user = null;
			for(String u2:dict.keySet()) {
				//ͬһ�û������Ƚ�
				if(!u1.equals(u2)) {
					HashMap<String,Double> score2 = dict.get(u2);
					//����������
					ComputeSimilar cs = new ComputeSimilar();
					double new_similar = cs.getSimilar(score1, score2);
					//�ҳ���С��ֵ����ʾ������С
					if(new_similar < similar) {
						similar = new_similar;
						sim_user = u2;
					}
				}
			}//for����
			//�������ݿ����
			try {
				service.addSimilar(u1, sim_user, similar);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//д���ļ�
			out.println(u1+","+sim_user+","+similar);
		}
		out.flush();
		out.close();
		System.out.println("dict:"+dict);
	}
}