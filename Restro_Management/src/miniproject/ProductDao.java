package miniproject;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import miniproject.ProductPojo;
import miniproject.Cp;


public class ProductDao 
{
	
	
	static Connection con = Cp.createCon();
	static PreparedStatement pstmt;
	
	static boolean flag=false;
	
	
	
	public static boolean insertBook(ProductPojo pojo1) throws SQLException
	{
		try
		{
			String insertQuery="INSERT INTO product(pId,pName,description,price) values(?,?,?,?)";
			pstmt=con.prepareStatement(insertQuery);
			pstmt.setInt(1, pojo1.getpId());
			pstmt.setString(2, pojo1.getpName());
			pstmt.setString(3, pojo1.getDescription());
			pstmt.setInt(4, pojo1.getPrice());
			
		
			pstmt.executeUpdate();
			flag=true;
		}
		catch(SQLException e1)
		{
			e1.printStackTrace();
		}
		
		return flag;
		
	}
	
	
	public static boolean deleteProduct(int pId)
	{
		String deleteQuery = "DELETE FROM product WHERE pId=?";
		try 
		{
			pstmt=con.prepareStatement(deleteQuery);
			pstmt.setInt(1, pId);
			pstmt.executeUpdate();
			flag=true;
		} 
		catch (SQLException e)
		{
				System.out.println("something went wrong try again later");
		}
		return flag;
		
	}
	
	public static void searchProduct(int pId)
	{
		ResultSet rs = null;
		
		try 
		{
			pstmt =con.prepareStatement("SELECT * FROM product WHERE pId=?");
			pstmt.setInt(1, pId);
			rs=pstmt.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
		
		System.err.println("pId                     "+"pName                    "+"description                      "+"price              ");
		System.err.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		try 
		{
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"                        "+rs.getString(2)+"                       "+rs.getString(3)+"                       "+rs.getInt(4));
		
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
	

	}
	
	
	public static boolean updateProduct(int pId,String pName1,String description1,int price1)
	{
		String updateQuery = "update product set pName = '"+pName1+"', description ='"+description1+"',price='"+price1+"'where pId='"+pId+"'";
		try 
		{
			pstmt=con.prepareStatement(updateQuery);
			//pstmt.setInt(1, bId);
			//pstmt.setString(2, bName1);
			//pstmt.setInt(3, price1);
			pstmt.executeUpdate();
			flag=true;
		} 
		catch (SQLException e)
		{
				System.out.println("something went wrong try again later");
		}
		return flag;
		
	}
	
	
	public static void displayProducts()
	{
		ResultSet rs = null;
		
		try {
			pstmt =con.prepareStatement("SELECT * FROM product");
			rs=pstmt.executeQuery();
			}
			catch (SQLException e2 ) 
			{
				e2.printStackTrace();
			
			}
		
		System.err.println("pId                     "+"pName                    "+"description                      "+"price                  ");
		System.err.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		try 
		{
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"                        "+rs.getString(2)+"                       "+rs.getString(3)+"                       "+rs.getInt(4));
		
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
	
	
	}
	
	
	
	

}
