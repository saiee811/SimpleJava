package miniproject;

import java.sql.SQLException;
import java.util.Scanner;


public class AdminThread extends Thread
{
	Scanner sc = new Scanner(System.in);
	
	UserPojo p1;
	public AdminThread(UserPojo u1)
	{
		this.p1=u1;
	}
	
	public void run()
	{
		try {
			ValidUser(p1.getuName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ValidUser(String uName) throws SQLException
	{
		int ch1=0;
		
		do
		{
			
			System.out.println("-------------MENU FOR ADMIN---------------");
			System.out.println("1.Add Items");
			System.out.println("2.Delete Item");
			System.out.println("3.Search Item");
			System.out.println("4.Update Item");
			System.out.println("5.Show Total bill");
			System.out.println("6.Show Total sales");
			System.out.println("7.Press 0 to LogOut");
			
			System.out.println("Enter your choice as a Admin: ");
			ch1 = sc.nextInt();
			
			
			switch(ch1)
			{
			
				case 1:
				{
					System.out.println("Enter ProductId: ");
					int pId=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter product Name: ");
					String pName =sc.nextLine();
					System.out.println("Enter Description: ");
					String description = sc.nextLine();
					System.out.println("Enter price: ");
					int price = sc.nextInt();
					
					ProductPojo pojo1 = new ProductPojo(pId,pName,description,price);
					
					boolean flag = ProductDao.insertBook(pojo1);
					
					if(flag)
					{
						System.out.println("Product added successfully");
					}
					else
					{
						System.out.println("something went wrong please try again");
						
					}
					
					
					
					
					
					break;
				}
				
				case 2:
				{
					
					
					System.out.println("Enter Product Id to Delete the Product: ");
					int pId = sc.nextInt();
					
					boolean flag = ProductDao.deleteProduct(pId);
					if(flag)
					{
						System.out.println("Book deleted Successfully");
					}
					else
					{
						System.out.println("Something went wrong");
					}
					
					
					break;
				}
				
				case 3:
				{
					System.out.println("Enter Product Id: ");
					int pId = sc.nextInt();
					ProductDao.searchProduct(pId);
					break;
					
				
				}
				case 4:
				{
					System.out.println("Enter ProductId: ");
					int pId=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter product Name: ");
					String pName1 =sc.nextLine();
					System.out.println("Enter Description: ");
					String description1 = sc.nextLine();
					System.out.println("Enter price: ");
					int price1 = sc.nextInt();
					
					ProductDao.updateProduct(pId, pName1, description1, price1);
					
					break;
				}
				case 5:
				{
					System.out.println("Bills Generated by each User");
					OrderDao.getBill1();
					System.out.println("----------------------------------------");
					break;
				}
				
				case 6:
				{
					System.out.println("----------------------------------------");
					OrderDao.getTotalSales();
					System.out.println("----------------------------------------");
					break;
				}
			
			
			
			
			
			
			
			}
			
			
			
			
			
			
			
		}
		while(ch1!=0);
		
		
		
		
	}

}
