package analyze;

import java.util.HashMap;

public class ComputeSimilar {
    public double getSimilar(HashMap<String,Double> score1,HashMap<String,Double> score2) {
    	double similar = 0;
    	//score1 �� score2��key��һ����
    	for(String str:score1.keySet()) {
    		double value1 = score1.get(str);
    		double value2 = score2.get(str);
    		
    		//�����NaNֵ��ʱ��Ϊ0
    		if(Double.isNaN(value1)) {
    			value1 = 0.0;
    		}
    		if(Double.isNaN(value2)) {
    			value2 = 0.0;
    		}
    		//������ָ��������������û�ÿ�����Ĳ��ֵ
    		similar += Math.pow(score1.get(str) - score2.get(str),2);
    	}
    	similar = Math.sqrt(similar);
    	return similar;
    }
}
