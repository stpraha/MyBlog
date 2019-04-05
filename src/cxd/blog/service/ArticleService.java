package cxd.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import cxd.blog.dao.ArticleDao;
import cxd.blog.daoImpl.ArticleDaoImpl;
import cxd.blog.model.Article;
import cxd.blog.model.AxisArticle;
import cxd.blog.utils.ArticleUtils;
import cxd.blog.utils.StringUtils;

public class ArticleService {
	private ArticleDao dao;
	
	private static ArticleService instance;
	
	private ArticleService() {
		dao = ArticleDaoImpl.getInstance();
	}
	
	public static final ArticleService getInstance() {
		if(instance == null) {
			try {
				instance = new ArticleService();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/*
	 * 
	 */
	public Article getPreviousArticle(String time) {
		return dao.getANearArticle(time, dao.LESS);
	}
	
	public Article getNextArticle(String time) {
		return dao.getANearArticle(time, dao.MORE);
	}
	
	public int getCount(String searchKey) {
		return dao.getCount(searchKey);
	}
	
	public List getAxisList() {
		List<Article> articles = dao.getAllArticleReversed();
		List<AxisArticle> axisList = new ArrayList<>();
		
		for(Article a: articles) {
			AxisArticle at = ArticleUtils.getAxisArticle(a);
			axisList.add(at);
		}
		
		AxisArticle tmp = null;
		List result = new LinkedList();
		
		if(!axisList.isEmpty()) {
			tmp = new AxisArticle();
			tmp.setId(0);
			tmp.setYear(axisList.get(0).getYear());
			result.add(tmp);
			result.add(axisList.get(0));
		}
		// 判断文章年份是不是不一样 不一样则塞一个year
		for (int i = 1; i < axisList.size(); i++) {
			int present_year = axisList.get(i).getYear();
			int past_year = axisList.get(i - 1).getYear();

			if (present_year < past_year) {
				tmp = new AxisArticle();
				tmp.setId(0);
				tmp.setYear(present_year);
				result.add(tmp);
			}
			result.add(axisList.get(i));
		}
		// 注意: 在list遍历里面动态修改了数组长度会出现内存溢出的情况
		return result;
	}
	
	public List<Article> getArticle(String column, String value) {
		return dao.getArticleByColumn(column, value);
	}

	/**
	 * 获取分类及该分类的文章数量
	 * 
	 * @return
	 */
	public Map getSortAndCount() {
		// TO DO
		// 需要重写这个方法
		return dao.getColumAndCount(dao.SEARCH_SORT);
	}

	/**
	 * 获取 所有文章 截取文章长度 截取一下时间 去掉时 分钟 秒
	 * 
	 * @return
	 */
	public List getArticle() {
		List<Article> list = dao.getAllArticle();
		for (Article a : list) {
			ArticleUtils.cutContent(list);
			ArticleUtils.cutTime(list);
		}
		return list;
	}
	
	public List<Article> getArticleList() {
		List<Article> list = dao.getAllArticleReversed();
		return list;
	}
	
	public Article getSingleArticle(String column, String id) {
		Article article = dao.getSingleArticle(column, id);
		return article;
	}
	

	/**
	 * 获取分类和它的文章
	 * 
	 * @return
	 */
	public Map getSortAndAirticle(String sort_name) {

		Map map = new HashMap();
		List<Article> articleBySort = null;

		// 获取所有分类
		if (sort_name.equals("all") || StringUtils.isEmpty(sort_name)) {
			List<String> sorts = dao.getAllSort();

			for (int i = 0; i < sorts.size(); i++) {
				String sort = sorts.get(i);
				articleBySort = dao.getArticleByColumn("sort", sort);
				ArticleUtils.cutTime(articleBySort);
				map.put(sort, articleBySort);
			}
		} else {
			// 获取单个分类
			articleBySort = dao.getArticleByColumn("sort", sort_name);
			ArticleUtils.cutTime(articleBySort);
			map.put(sort_name, articleBySort);
		}
		return map;
	}

	public List getVisitRank() {
		List list = dao.getVisitRank();
		if (list.size() > 10) {
			for (int i = 10; i < list.size(); i++) {
				list.remove(i);
			}
		}
		for (int y = 0; y < list.size(); y++) {

			Article a = (Article) list.get(y);
			if (a.getTitle().length() > 20) {
				a.setTitle(StringUtils.cutString(a.getTitle(), 0, 19) + "...");
			}

		}

		return list;

	}

	public List getAllSort() {
		return dao.getAllSort();
	}

	public int starArticle(int id) {
		return dao.starArticle(id);
	}

	public void addVisit(int article_id) {
		dao.addVisit(article_id);
	}
}

















