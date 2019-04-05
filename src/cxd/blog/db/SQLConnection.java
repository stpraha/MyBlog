package cxd.blog.db;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class SQLConnection {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
	
	private static final String USER = "root";
	private static final String PASS_WORD = "a13757407965b";
	
	private static SQLConnection instance;
	
	private static Connection conn;
	
	public static final SQLConnection getInstance() {
		if(instance == null) {
			try {
				instance = new SQLConnection();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public synchronized final Connection getConnection() {
		if(conn == null) {
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER, PASS_WORD);
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("获取数据库连接出错");
			}
		}
		return conn;
	}
}	