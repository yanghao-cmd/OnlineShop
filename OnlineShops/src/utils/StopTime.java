package utils;

import java.util.Date;

public class StopTime {
	private int h=0;
	private int m=0;
	private int s=0;
	public StopTime(){}
	public void counttime(Date start){
		Date end=new Date();		//获得当前时间
		long howmuch=end.getTime()-start.getTime();		//获得当前时间与登录时间相差的毫秒数
		h=(int)(howmuch/1000/60/60);			//计算小时
		howmuch=howmuch-h*60*60*1000;			
		m=(int)(howmuch/1000/60);				//计算分钟
		howmuch=howmuch-m*60*1000;
		s=(int)(howmuch/1000);					//计算停留的秒数
	}
	public int getH(){
		return this.h;
	}
	public int getM(){
		return this.m;
	}
	public int getS(){
		return this.s;
	}
}
