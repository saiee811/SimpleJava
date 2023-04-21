package miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao 
{
	

	static Connection con = Cp.createCon();
	static PreparedStatement pstmt;
	static PreparedStatement pstmt1;
	
	static boolean flag=false;
	
	
	public static boolean insertOrder(OderPojo o) throws SQLException
	{
		try
		{
			String insertQuery="INSERT INTO order1(oId,quantity,uId,pId) values(?,?,?,?)";
			pstmt=con.prepareStatement(insertQuery);
			pstmt.setInt(1, o.getoId());
			pstmt.setInt(2, o.getQuantity());
			pstmt.setInt(3, o.getuId());
			pstmt.setInt(4, o.getpId());
			pstmt.executeUpdate();
			flag=true;
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		return flag;
		
	}



	public static void getBill(int uId)
	{
		ResultSet rs = null;
		
		try 
		{
			pstmt =con.prepareStatement("select c.uId,(a.price * b.quantity) as total from product a, order1 b, user c where a.pId = b.pId and b.uId = c.uId");
			//pstmt.setInt(1, uId);
			rs=pstmt.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
		System.out.println("Total bill");
		System.err.println("pId                     "+"total                ");
		System.err.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		try 
		{
			while(rs.next())
			{
				if(rs.getInt("uId")==uId)
				{
				System.out.println(rs.getInt(1)+"                        "+rs.getInt(2));
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
	}
		public static void getTotalSales() throws SQLException
		{
			ResultSet rs = null;
			
			try 
			{
				pstmt =con.prepareStatement("select sum((a.price * b.quantity)) as total from product a, order1 b, user c where a.pId = b.pId and b.uId = c.uId");
				//pstmt.setInt(1, uId);
				rs=pstmt.executeQuery();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				
			}
			rs.next();
			
			int TotalSales = rs.getInt(1);
			System.out.println("Total Sales: "+TotalSales);
	}


		public static void getBill1()
		{
			ResultSet rs = null;
			
			try 
			{
				pstmt =con.prepareStatement("select c.uId,(a.price * b.quantity) as total from product a, order1 b, user c where a.pId = b.pId and b.uId = c.uId");
				//pstmt.setInt(1, uId);
				rs=pstmt.executeQuery();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				
			}
			System.out.println("Total bill");
			System.err.println("pId                     "+"total                ");
			System.err.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			try 
			{
				while(rs.next())
				{
					
					System.out.println(rs.getInt(1)+"                        "+rs.getInt(2));
					
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				
			}
		}









}
