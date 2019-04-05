package cxd.blog.model;

public class User {
	private String username;
	private String password;
	private int userId;
	private String nickName;
	
	public User () {
		
	}
	
	public User(int userId, String username, String password, String nickName) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.nickName = nickName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getPassword() {
		return password;
	}

	public String getNickName() {
		return nickName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
