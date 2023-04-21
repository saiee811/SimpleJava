package miniproject;

import java.sql.SQLException;


import java.util.Scanner;

import miniproject.UserDao;
import miniproject.UserPojo;



public class Main 
{
	
	
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		int choice=0;
		UserDao d1 = new UserDao();
		AdminThread t1;
		UserThread t2;
		UserPojo u = new UserPojo();
		
		do
		{
			System.out.println("-------Menu---------");
			System.out.println("1 Register");
			System.out.println("2 Login");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					System.out.println("Enter User Id: ");
					int uId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter User Name: ");
					String uName = sc.nextLine();
					
					System.out.println("Enter password: ");
					String pwd = sc.nextLine();
					
					System.out.println("Enter Type: ");
					String type=sc.nextLine();
					
					 u=new UserPojo(uId,uName,pwd,type);
					
					boolean flag = UserDao.insertUser(u);
					if(flag)
					{
						System.out.println("employee updated successfully");
					}
					else
					{
						System.out.println("something went wrong please try again");
						
					}
					break;
				}
				case 2:
				{
					System.out.println("Enter UID: ");
					int uId = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter User Name: ");
					String uName = sc.nextLine();
					sc.nextLine();
					
					System.out.println("Enter password: ");
					String pwd = sc.nextLine();
					
					
					
					if(d1.Login(uId,uName,pwd))
					{
						System.out.println("You Have Logged In SuccessFully");
						
						System.out.println("Enter Type: ");
						String type = sc.nextLine();
						
						if(d1.LoginUser(type))
						{
							
							
							t2 = new UserThread(u);   //CreatingThreadIfTheUserIsValid
							t2.start();
							
							try 
							{
								t2.join();
							} 
							catch (InterruptedException e) 
							{
							// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							
						}
						else if(d1.LoginAdmin(type))
						{
							System.out.println("You are admin");
							
							t1 = new AdminThread(u);   //CreatingThreadIfTheUserIsValid
							t1.start();
							
							try 
							{
								t1.join();
							} 
							catch (InterruptedException e) 
							{
							// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
						}
					}
					else
					{
						try
						{
							throw new InValidUserException("Please Enter Valid Credentials!!!");
						}
						catch(InValidUserException re)
						{
							re.getMessage();
						}
					}
					break;
				}
				
			}
			
		}
		while(choice!=0);
		
	}
}
