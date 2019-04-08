package cxd.blog.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cxd.blog.dao.ArticleDao;
import cxd.blog.dao.CommentDao;
import cxd.blog.db.SQLConnection;
import cxd.blog.model.Article;
import cxd.blog.model.Comment;
import cxd.blog.utils.DBUtils;

public class CommentDaoImpl implements CommentDao{
	
	private Connection conn;
	private static CommentDao instance;
	
	private CommentDaoImpl() {
		conn = SQLConnection.getInstance().getConnection();
	}
	
	public static final CommentDao getInstance() {
		if(instance == null) {
			try {
				instance = new CommentDaoImpl();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	
	@Override
	public void addComment(Comment comment) {
		String sql = " INSERT INTO t_comment values(null, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, comment.getCommenderNickName());
			ps.setString(2, comment.getCommenderEmail());
			ps.setString(3, comment.getCommentContent());
			ps.setInt(4, comment.getCommentArticleId());
			ps.setString(5, comment.getCommentArticleTitle());
			ps.setString(6, comment.getCommentTime());
			result = ps.executeUpdate();
			DBUtils.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Comment> getAllComment() {
		List<Comment> list = new ArrayList<>();
		Comment comment = null;
		String sql = "SELECT * FROM t_comment ORDER BY time DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				comment = new Comment(rs.getInt("id"), rs.getString("nickname"), rs.getString("email"),
									  rs.getString("content"), rs.getInt("articleid"), rs.getString("articletitle"), rs.getString("time"));
				list.add(comment);
			}
			DBUtils.close(ps, rs);
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Comment getSingleComment(String column , String id) {
		String sql = "SELECT * FROM t_comment WHERE " + column +  "= " + id;
		Comment comment = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				comment = new Comment(rs.getInt("id"), rs.getString("nickname"), rs.getString("email"),
									  rs.getString("contnet"), rs.getInt("articleid"), rs.getString("articletitle"), rs.getString("time"));
			}
			DBUtils.close(ps);
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return comment;
	}

	@Override
	public List<Comment> getArticleComment(int articleId) {
		List<Comment> list = new ArrayList<>();
		Comment comment = null;
		String sql = "SELECT * FROM t_comment WHERE articleid = " + articleId;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				comment = new Comment(rs.getInt("id"), rs.getString("nickname"), rs.getString("email"),
									  rs.getString("content"), rs.getInt("articleid"), rs.getString("articletitle"), rs.getString("time"));
				list.add(comment);
			}
			DBUtils.close(ps, rs);
		} catch(Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return list;
	}

	
}
