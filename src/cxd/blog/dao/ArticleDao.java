package cxd.blog.dao;

import java.util.List;
import java.util.Map;

import cxd.blog.model.Article;

public interface ArticleDao {
	static final String SEARCH_ARTICLE = "article";
	static final String SEARCH_SORT = "sort";
	
	static final int LESS = 1;
	static final int MORE = 2;
	
	/*
	 * add article view times
	 */
	void addVisit(int articleId);
	
	void addStar(int articleId);
	
	/*
	 * get previous article / next article
	 */
	Article getANearArticle(String time, int lessOrMore);
	
	/*
	 * ????
	 */
	Map getColumAndCount(String searchColumn);
	
	/*
	 * get all ���
	 */
	List getAllSort();
	
	/*
	 * new article
	 */
	Article addArticle(Article a);
	
	/*
	 * delete article
	 */
	Boolean deleteArticle(String id);
	
	/*
	 * get all articles
	 */
	List getAllArticle();
	
	/*
	 * get visit rank
	 */
	List getVisitRank();
	
	
	List<Article> getArticleByColumn(String column, String value);
	
	int getCount(String searchKey);
	
	int starArticle(int id);
	
	boolean updateSort(String oldSort, String newSort);
	
	boolean deleteSort(String sort);


	List getAllArticleReversed();


	Article getSingleArticle(String column, String id);
}
