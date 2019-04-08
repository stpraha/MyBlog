package cxd.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cxd.blog.dao.CommentDao;
import cxd.blog.daoImpl.CommentDaoImpl;
import cxd.blog.model.Article;
import cxd.blog.model.AxisArticle;
import cxd.blog.model.Comment;
import cxd.blog.utils.ArticleUtils;
import cxd.blog.utils.StringUtils;

public class CommentService {
private CommentDao dao;
	
	private static CommentService instance;
	
	private CommentService() {
		dao = CommentDaoImpl.getInstance();
	}
	
	public static final CommentService getInstance() {
		if(instance == null) {
			try {
				instance = new CommentService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public Comment getSingleComment(String column, String id) {
		Comment comment = dao.getSingleComment(column, id);
		return comment;
	}
	
	public List getAllComment() {
		return dao.getAllComment();
	}
	
	public List getArticleComment(String articleId) {
		int id = Integer.parseInt(articleId);
		return dao.getArticleComment(id);
	}
	
	public void addComment(Comment comment) {
		dao.addComment(comment);
	}
}




