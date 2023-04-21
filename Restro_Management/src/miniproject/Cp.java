package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cp 
{
	private Cp()
	{
		
	}
	private final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static private final String DB_URL = "jdbc:mysql://localhost:3306/miniproject";
	static final String USERNAME = "root";
	static final String PASSWORD = "very";
	
	public static Connection createCon()
	{
		try 
		{
			Class.forName(JDBC_DRIVER);
		} 
		catch (ClassNotFoundException e3) 
		{
			e3.printStackTrace();
			
		}
		Connection con=null;
		try
		{
			con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		}
		catch(Exception e3)
		{
			System.out.println("something went wrong try again later");
		}
		return con;

}

}
