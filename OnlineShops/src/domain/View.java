package domain;

public class View {
	private String vNo;
	private String id;
	private String type;
	private int time;
	
	
	public String getvNo() {
		return vNo;
	}
	public void setvNo(String vNo) {
		this.vNo = vNo;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
}

