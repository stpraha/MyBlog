package cxd.blog.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cxd.blog.dao.ArticleDao;
import cxd.blog.model.Article;
import cxd.blog.utils.DBUtils;
import cxd.blog.db.SQLConnection;;


public class ArticleDaoImpl implements ArticleDao{

	private Connection conn;
	private static ArticleDao instance;
	
	private ArticleDaoImpl() {
		conn = SQLConnection.getInstance().getConnection();
	}
	
	public static final ArticleDao getInstance() {
		if(instance == null) {
			try {
				instance = new ArticleDaoImpl();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	/*
	 * (non-Javadoc)
	 * need to be rewrite
	 * @see cxd.blog.dao.ArticleDao#addVisit(int)
	 */
	@Override
	public void addVisit(int articleId) {
		String sql = "update t_article set visit = visit+1 where id =" + articleId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addStar(int articleId) {
		String sql = "update t_article set star = star+1 where id =" + articleId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Article getANearArticle(String time, int lessOrMore) {
		Article article = null;
		String sql = "";
		if(lessOrMore == this.LESS) {
			sql = " SELECT * FROM t_article WHERE TIME<'" + time + "' ORDER BY TIME DESC ";
		}
		else if(lessOrMore == this.MORE) {
			sql = " SELECT * FROM t_article WHERE TIME<'" + time + "' ORDER BY TIME ";
		}
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
									  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
									  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
			}
			DBUtils.close(ps, rs);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public Map<String, Integer> getColumAndCount(String searchColumn) {
		String sql = " SELECT " + searchColumn + " , COUNT(" + searchColumn + ") as counts FROM t_article GROUP BY " + searchColumn;
		Map<String, Integer> map = new HashMap<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				map.put(rs.getString(searchColumn), rs.getInt("counts"));
			}
			DBUtils.close(ps, rs);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllSort() {
		String sql = " SELECT distinct(sort) FROM t_article order by sort";
		List<String> list = new ArrayList<>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getString(1));	//getString(1)??
			}
			DBUtils.close(ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Article addArticle(Article article) {
		String sql = " INSERT INTO t_article values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getAuthor());
			ps.setString(3, article.getSort());
			ps.setString(4, article.getTime());
			ps.setInt(5, article.getStar());
			ps.setInt(6, article.getComment());
			ps.setInt(7, article.getVisit());
			ps.setString(8, article.getContent());
			result = ps.executeUpdate();
			DBUtils.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.getLastArticle();
	}
	
	private boolean addArticleDelete(Article article) {
		String sql = " INSERT INTO t_article_delet values(null, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getAuthor());
			ps.setString(3, article.getSort());
			ps.setString(4, article.getTime());
			ps.setInt(5, article.getStar());
			ps.setInt(6, article.getComment());
			ps.setInt(7, article.getVisit());
			ps.setString(8, article.getContent());
			result = ps.executeUpdate();
			DBUtils.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0;
	}
	
	private Article getLastArticle() {
		String sql = " SELECT * FROM t_article ORDER BY TIME DESC LIMIT 1";
		Article article = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
						  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				DBUtils.close(ps, rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}
	
	@Override
	public Boolean deleteArticle(String id) {
		String sql = "DELETE FROM t_article WHERE id = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			
			DBUtils.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result != 0;
	}

	@Override
	public List<Article> getAllArticle() {
		List<Article> list = new ArrayList<>();
		Article article = null;
		String sql = "SELECT * FROM t_article";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						  			  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
						  			  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
			DBUtils.close(ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Article> getAllArticleReversed() {
		List<Article> list = new ArrayList<>();
		Article article = null;
		String sql = "SELECT * FROM t_article ORDER BY time DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
						  			  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
						  			  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
			DBUtils.close(ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public List<Article> getVisitRank() {
		List<Article> list = new ArrayList<>();
		Article article = null;
		String sql = "SELECT * FROM t_article ORDER BY visit DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
			  			  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
			  			  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Article> getArticleByColumn(String column, String value) {
		List<Article> list = new ArrayList<>();
		Article article = null;
		String sql = "SELECT * FROM t_article where " + column + " = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
			  			  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
			  			  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getCount(String searchKey) {
		int count = 0;
		String sql = "";
		if(searchKey == SEARCH_ARTICLE) sql = "SELECT COUNT(id) FROM t_article";
		else if(searchKey == SEARCH_SORT) sql = "SELECT COUNT(sort) FROM t_article";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			DBUtils.close(ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public int starArticle(int id) {
		String sql1 = "UPDATE t_article set star=star+1 WHERE id=" + id;
		String sql2 = "SELECT star FROM t_article WHERE id=" + id;
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.executeQuery();

			ps = conn.prepareStatement(sql2);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			DBUtils.close(ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public boolean updateSort(String oldSort, String newSort) {
		String sql = "UPDATE t_article SET sort = ? WHERE sort = ?";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newSort);
			ps.setString(2, oldSort);
			ps.executeUpdate();
			DBUtils.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0;
	}

	@Override
	public boolean deleteSort(String sort) {
		List<Article> list = new ArrayList<>();
		Article article = null;
		int result = 0;
		String sql1 = "SELECT * FROM t_article WHERE sort = ?";
		String sql2 = "DELETE FROM t_article WHERE sort = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, sort);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
			  			  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
			  			  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				list.add(article);
			}
			
			for(Article articl : list) {
				this.addArticleDelete(articl);
			}
			
			ps = conn.prepareStatement(sql2);
			ps.setString(1, sort);
			result = ps.executeUpdate();
			DBUtils.close(ps, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result > 0;
	}

	@Override
	public Article getSingleArticle(String column, String id) {
		Article article = null;
		String sql = "SELECT * FROM t_article where " + column + " = " + id;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				article = new Article(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
			  			  rs.getString("sort"), rs.getString("time"), rs.getInt("star"),
			  			  rs.getInt("comment"), rs.getInt("visit"), rs.getString("content"));
				//list.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(article == null) {
			article = new Article(999, "���ͱ��Ե�����", "NoBody", "�����з��డ", "1970-01-01 00:00:00", 9, 9, 9, "��������û�в��͵Ļ�ԭ������ϵ����Ա��������̲裡");
		}
		return article;
	}
	
}










