package cxd.blog.utils;

import java.util.List;

import cxd.blog.dao.ArticleDao;
import cxd.blog.dao.UserDao;
import cxd.blog.daoImpl.ArticleDaoImpl;
import cxd.blog.daoImpl.UserDaoImpl;
import cxd.blog.model.Article;
import cxd.blog.model.User;

public class Main {
	public static void main(String[] args) {
		ArticleDao adi = ArticleDaoImpl.getInstance();
		UserDao ud = UserDaoImpl.getInstance();
		
		//User user = new User(21, "stpraha", "cxd123", "chenxd");
//		Article article = new Article(15, "testTitle2", "testAuthor2", "testSort2", "2019-04-03 20:56:12", 12, 11, 13, "testContent2");
//		adi.addArticle(article);
		
		//ud.register("stprahb", "cxd123", "chenxdd");
		User user = ud.login("stpraha", "cxd123");
		user = ud.login("stpraha", "cxd123");
		
		if(user == null) System.out.println("Login failed!");
		else {
			System.out.println(user.getNickName());
			System.out.println(user.getUserId());
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
		}
	}
}
