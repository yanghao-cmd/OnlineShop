package domain;
import java.util.HashMap;
import java.util.Map;

public class RegisterForm {
    private String id;
    private String password;
    private String password2;
    private String name;
    private String email;
    private Map<String, String> errors = new HashMap<String, String>();
    
    public String getId() {
    	return id;
    }
    public void setId(String id) {
    	this.id = id;
    }
    
    public String getPassword() {
    	return password;
    }
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public String getPassword2() {
    	return password2;
    }
    public void setPassword2(String password2) {
    	this.password2 = password2;
    }
    
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getEmail() {
    	return email;
    }
    public void setEmail(String email) {
    	this.email = email;
    }
    
    
    public boolean validate() {
    	boolean flag = true;
    	
    	if(id == null || id.trim().equals("")) {
    		errors.put("id","请输入用户名.");
    		flag = false;
    	}else if(id != null && id.length() > 20) {
    		errors.put("id", "用户长度小于20.");
    		flag = false;
    	}
    	if(name == null || name.trim().equals("")) {
    		errors.put("name","请输入昵称.");
    		flag = false;
    	}
    	if(password == null || password.trim().equals("")) {
    		errors.put("password", "密码不能为空.");
    		flag = false;
    	}else if(password.length() < 5 || password.length() > 20) {
    		errors.put("password", "密码长度要大于5位小于20位.");
    		flag = false;
    	}
    	if(password != null && !password.equals(password2)) {
    		errors.put("password2", "两次输入密码不一致.");
    		flag = false;
    	}

    	if(email == null || email.trim().equals("")) {
    		errors.put("email", "请输入邮箱.");
    		flag = false;
    	}else if(!email.matches("[a-zA-Z0-9]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+")) {
    		errors.put("email", "邮箱格式不正确.");
    		flag = false;
    	}
    	
    	return flag;
    }
    
    
    public void setErrorMsg(String err, String errMsg) {
    	if((err != null) && (errMsg != null)) {
    		errors.put(err, errMsg);
    	}
    }
    
    
    public Map<String, String> getErrors(){
    	return errors;
    }
}
