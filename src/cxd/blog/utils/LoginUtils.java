package cxd.blog.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cxd.blog.dao.ArticleDao;
import cxd.blog.dao.UserDao;
import cxd.blog.daoImpl.ArticleDaoImpl;
import cxd.blog.daoImpl.UserDaoImpl;
import cxd.blog.model.User;

public class LoginUtils {
	public static void login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null ||username == "" || password == null || password == "") return;
		
		System.out.println("User: " + username + " login" + password);
		
		User user = login(username, password);
		if(user == null) {
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("user", user);
	}
	
	
	public static User login(String username, String password) {
		UserDao userDao = UserDaoImpl.getInstance();
		User user = userDao.login(username, password);
		
		return user;
	}
}






