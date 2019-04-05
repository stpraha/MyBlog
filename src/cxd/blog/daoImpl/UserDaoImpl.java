package cxd.blog.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cxd.blog.dao.UserDao;
import cxd.blog.db.SQLConnection;
import cxd.blog.model.User;
import cxd.blog.utils.DBUtils;;

public class UserDaoImpl implements UserDao {
	private Connection conn;

	private static UserDao instance;
	
	UserDaoImpl() throws SQLException {
//		String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//		String DB_URL = "jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
//		String USER = "root";
//		String PASS_WORD = "a13757407965b";
//		
//		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS_WORD);
		conn = SQLConnection.getInstance().getConnection();
		System.out.println("get conn !");
	}
	
	public static final UserDao getInstance() {
		if(instance == null) {
			try {
				instance = new UserDaoImpl();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	@Override
	public boolean register(String username, String password, String nickName) {
		String sql = " INSERT INTO t_user values(null, ?, ?, ?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, nickName);
			result = ps.executeUpdate();
			
			DBUtils.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
			result = -1;
		}
		
		System.out.println(result);
		return result > 0;
	}

	@Override
	public User login(String username, String password) {
		User user = null;
		String sql = " SELECT * FROM t_user WHERE username=? and password=? ";
		
		try {			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user = new User(rs.getInt("userid"), rs.getString("username"),
								rs.getString("password"), rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}











