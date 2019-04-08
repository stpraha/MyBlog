package cxd.blog.dao;

import java.util.List;
import java.util.Map;

import cxd.blog.model.Comment;

public interface CommentDao {

	
	/*
	 * new article
	 */
	void addComment(Comment c);
	
	/*
	 * delete article
	 */
	
	/*
	 * get all articles
	 */
	List getAllComment();

	Comment getSingleComment(String column, String id);
	
	List getArticleComment(int articleId);
}
