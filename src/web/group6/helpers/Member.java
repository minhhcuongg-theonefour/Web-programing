package web.group6.helpers;

public class Member {
	private String uname, password, email;
	private int userId, role;
	public Member(String uname, String password, String email) {
		super();
		this.uname = uname;
		this.password = password;
		this.email = email;
	}
	public Member(int userId, String uname, String email,int role) {
		super();
		this.userId = userId;
		this.uname = uname;
		this.email = email;
		this.role = role;
	}
	public Member(String email, String password) {
		super();
		this.password = password;
		this.email = email;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUname() {
		return uname;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public int getRole() {
		return role;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
	
	public void setUserId(int id) {
		this.userId = id;
	}
	public void setRole(int role) {
		this.role = role;
	}
}
