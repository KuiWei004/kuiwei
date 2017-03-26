package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
		static{
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://localhost/addr","root","");
		}
		
		public static void close(Statement stmt,Connection conn) throws SQLException{
			stmt.close();
			conn.close();
		}
		
		public static void close(ResultSet rs,Statement stmt,Connection conn) throws SQLException{
			rs.close();
			stmt.close();
			conn.close();
		}
}
