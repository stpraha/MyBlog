package cxd.blog.dao;

import cxd.blog.model.User;

public interface UserDao {
	boolean register(String username, String password, String nickName);
	
	User login(String username, String password);
}
