package miniproject;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import miniproject.UserPojo;
import miniproject.Cp;

public class UserDao 
{
	
	static Connection con = Cp.createCon();
	static PreparedStatement pstmt;
	static PreparedStatement pstmt1;
	
	static boolean flag=false;
	
	public static boolean insertUser(UserPojo u) throws SQLException
	{
		try
		{
			String insertQuery="INSERT INTO user(uId,uName,pwd,type) values(?,?,?,?)";
			pstmt=con.prepareStatement(insertQuery);
			pstmt.setInt(1, u.getuId());
			pstmt.setString(2, u.getuName());
			pstmt.setString(3, u.getPwd());
			pstmt.setString(4, u.getType());
			pstmt.executeUpdate();
			flag=true;
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		return flag;
		
	}
	
	public boolean Login(int uId,String uName,String pwd) throws SQLException
	{
		ResultSet rs = null;
		boolean isValid = false;
		
		try {
				pstmt =con.prepareStatement("SELECT * FROM user WHERE uId=? AND uName=? AND pwd=?");
				pstmt.setInt(1, uId);
				pstmt.setString(2, uName);
				pstmt.setString(3, pwd);
				rs=pstmt.executeQuery();
			}
			catch (SQLException e2 ) 
			{
				e2.printStackTrace();
			
			}
		
			while(rs.next())
			{
				if(rs.getInt("uId")==uId && rs.getString("uName").equals(uName) && rs.getString("pwd").equals(pwd))
				{
					isValid=true;
					
				}
				
			}
			return isValid;
	}
	
	public boolean LoginUser(String type) throws SQLException
	{
		ResultSet rs = null;
		boolean isValid1 = false;
		
		try {
				pstmt =con.prepareStatement("SELECT * FROM user WHERE type='user'");
				rs=pstmt.executeQuery();
			}
			catch (SQLException e2 ) 
			{
				e2.printStackTrace();
			
			}
		
			while(rs.next())
			{
					if(rs.getString("type").equals(type))
					{
						isValid1=true;
					}
				
			}
			return isValid1;
	}

	public boolean LoginAdmin(String type) throws SQLException
	{
		ResultSet rs = null;
		boolean isValid2 = false;
		
		try {
				pstmt =con.prepareStatement("SELECT * FROM user WHERE type='admin'");
				rs=pstmt.executeQuery();
			}
			catch (SQLException e2 ) 
			{
				e2.printStackTrace();
			
			}
		
			while(rs.next())
			{
				if(rs.getString("type").equals(type))
				{
					isValid2=true;
				}
			}
			return isValid2;
	}
}
