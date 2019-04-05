package cxd.blog.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtils {

	public static void close(PreparedStatement ps, ResultSet rs) {
		try {
			ps.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
