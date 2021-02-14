package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.*;






public class DBUtil {
	
	private static final String JDBC_Driver ="org.sqlite.JDBC";
	
	private static Connection c=null;
	
	private static final String connStr = "jdbc:sqlite:database.db";  

	public static void dbConnect() throws SQLException, ClassNotFoundException{
		try {
			Class.forName(JDBC_Driver);
		} catch(ClassNotFoundException e) {
			System.out.println("Where is driver?");
			e.printStackTrace();
			throw e;
		
		}
		System.out.println("Driver register");
		
		try {
			c = DriverManager.getConnection(connStr);
		}catch(SQLException e) {
			System.out.println("Connection failed" + e);
			throw e;
		}
	}
	public static void dbDisconnect() throws SQLException{
		try {
			if (c != null && !c.isClosed()) {
				c.close();
			}
		} catch(Exception e) {
			throw e;
		
		}
	}
	
	public static void dbExecuteQuery(String sqlStmt)  throws SQLException, ClassNotFoundException{
		Statement stmt = null;
		try {
			dbConnect();
			stmt= c.createStatement();
			stmt.executeUpdate(sqlStmt);
		}catch(SQLException e) {
			System.out.println("No more query" + e);
			throw e;
		}finally {
			if (stmt!=null) {
				stmt.close();				
			}
			dbDisconnect();
		}
	}
	
	public static ResultSet dbExecute(String sqlQuery)  throws SQLException, ClassNotFoundException{
		 
		
		
		Statement stmt = null;
		ResultSet rs = null;
		CachedRowSet crs=null;
		try {
			dbConnect();
			stmt= c.createStatement();
			rs =stmt.executeQuery(sqlQuery);
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.populate(rs);
			
					
		}catch(SQLException e) {
			System.out.println("Error in sql operation" + e);
			throw e;
		}finally {
			if (stmt!=null) {
				stmt.close();
			}
			if (rs!=null) {
				rs.close();	
			dbDisconnect();
		}
	}
	return crs;
	}
	
}
	