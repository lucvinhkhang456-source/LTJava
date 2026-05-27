package data;
import java.sql.*;
public class JavaConnection 
{
	private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_ltjava?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER="root";
	private static final String JDBC_PASSWORD = "123456";
	private static Driver driver;

	public static synchronized Connection getConnection() throws SQLException
	{
		if(driver==null)
		{
			try {
				Class jdbcDriverClass=Class.forName(JDBC_DRIVER);
				driver =(Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			}catch(Exception ex)
			{
				System.out.println("Failure to load the JDBC driver");
			}
			
		}
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
	}
	
	public static void close(ResultSet rs)
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
			}
		}catch(SQLException sqle)
		{
			sqle.printStackTrace(System.out);
		}
	}
	
	public static void close(PreparedStatement stmt)
	{
		try
		{
			if(stmt !=null)
			{
				stmt.close();
			}
		}catch(SQLException sqle)
		{
			sqle.printStackTrace(System.out);
		}
		
		
	}
	
	public static void close(Connection conn)
	{
		try
		{
			if(conn!=null)
			{
				conn.close();
			}
		}catch(SQLException sqle)
		{
			sqle.printStackTrace(System.out);
		}
	}
}

