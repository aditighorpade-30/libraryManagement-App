package com.library;

import java.sql.ResultSet;
import java.util.Scanner;

import com.library.dao.LibraryEmployeesDBOperation;
import com.library.dao.BorrowersDBOperation;
import com.library.entities.Books;
import com.library.entities.Borrowers;
public class App
{
    public static void main( String[] args )
    {
    	System.out.println("==================================================================================");
    	System.out.println("                             WELCOME TO LIBRARY                                  ");
    	System.out.println("==================================================================================");
    	
    	boolean status=true;
    	do
    	{
       try
       {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("=====================================================================");
    	System.out.println("\t press 1-> Library Employee");
    	System.out.println("\t press 2-> Book Borrower");
    	System.out.println("=====================================================================");
    	int userType=scan.nextInt();
    	LibraryEmployeesDBOperation bo=new LibraryEmployeesDBOperation();
    	
    	if(userType==1)
    	{
    		System.out.println("\t Enter Employee Id:");
    		long eId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String password=scan.next();
    		boolean validUser=bo.login(eId, password);
    		if(validUser)
    		{
    			System.out.println("==========================================================================");
    			System.out.println("                             login successfull!!                          ");
    			System.out.println("==========================================================================");
    			System.out.println("\t 1.Open Account\r\n" 
    	       		            	+ "2.Close Account\r\n"
    	       		             	+ "3.Check Borrowers Information\r\n"
    	       		            	+ "4.Password Change\r\n"
    	       		            	+ "5.Logout");
    		//for closing	
    			int operation=scan.nextInt();
    			if(operation==1)
    			{
    				
    				System.out.println("=====================================================================");
					System.out.println("                              Account Open!!                       ");
					System.out.println("=====================================================================");
    				
    				System.out.println("Enter account Id for the borrowers:");
    				long accId=scan.nextLong();
    				System.out.println("Enter account holder name:");
    				String accName=scan.next();
    				System.out.println("Enter account holder address:");
    				String accAddress=scan.next();
    				System.out.println("Enter account holder password:");
    				String accPassword=scan.next();
    				System.out.println("Enter phone number:");
    				long accPhone=scan.nextLong();
    				System.out.println("Enter email address:");
    				String accEmail=scan.next();
    				System.out.println("Enter book name:");
    				String bookName=scan.next();
    				
    				Borrowers u=new Borrowers(accId,accName,accAddress,accPassword,accPhone,accEmail,bookName);
    				if(bo.openAccount(u))
    				{
    					System.out.println("=====================================================================");
    					System.out.println("                              Acount created!!                       ");
    					System.out.println("=====================================================================");
    				}
    				else
    				{
    					System.out.println("====================================================================");
    					System.out.println("                              problem acount                        ");
    					System.out.println("====================================================================");
    				}
    				
    			}
    			
    			else if(operation==2)
    			{
    				
    				System.out.println("Enter account Id for closing account:");
    				long accId=scan.nextLong();
    				if(bo.accountClose(accId))
    				{
    					System.out.println("=====================================================================");
    					System.out.println("                        Account closed Successfully!!                ");
    					System.out.println("=====================================================================");
    				}
    				else
    				{
    					System.out.println("=====================================================================");
    					System.out.println("                         Problem in  account closing!!                ");
    					System.out.println("=====================================================================");
    				}
    			}
    			else if(operation==3)
    			{

    				System.out.println("=====================================================================");
					System.out.println("                            Borrower Information!!                       ");
					System.out.println("=====================================================================");
    				
				 	System.out.println("Enter the account Id for the User:");
        	       	long accId=scan.nextLong();
        	       	ResultSet result=bo.checkBorrowersinfo(accId);
        	       	if(result!=null)
        	       	{
                      while(result.next())
        	       		{
        	       		System.out.println("Borrower Name:"+result.getString(3));
        	       		System.out.println("Address:"+result.getString(4));
        	       		System.out.println("Phone number:"+result.getLong(5));
        	       		System.out.println("Email:"+result.getString(6));
        	       		System.out.println("Book Borrowed:"+result.getString(7));
        	       		}
        	       	}
        	       	else
        	       	{
        	       		System.out.println("=====================================================================");
        	       		System.out.println("                  Account Id does not exist!!                        ");
        	       		System.out.println("=====================================================================");
        	       	}
					
    			}
    			
    			else if(operation==4)
    	       	{
    	       		System.out.println("Enter your Staff Id:");
    	       		long eid=scan.nextLong();
    	       		System.out.println("Set new Password:");
    	       		String newPassword=scan.next();
    	       		if(bo.changePassword(eid, newPassword))
    	       		{
    	       			System.out.println("=====================================================================");
    	       			System.out.println("                       Password Changed!!                            ");
    	       			System.out.println("=====================================================================");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("=====================================================================");
    	       			System.out.println("                         Error occurred!!                            ");
    	       			System.out.println("=====================================================================");
    	       		}
    	       	}
    			
    			
    			else if(operation==5)
    	       	{
    	       		bo.logout();
    	       		System.out.println("========================================================================");
        			System.out.println("                               Logged Out!!                             ");
        	       	System.out.println("========================================================================");

    	       	}
    			
    			
    		}
    		else
    		{
    			System.out.println("============================================================================");
    			System.out.println("                                  incorrect                                 ");
    			System.out.println("============================================================================");
    		}
    	}
    	else if(userType==2)
    	{
    		BorrowersDBOperation ob=new BorrowersDBOperation();
    		System.out.println("\t Enter Borrower Id:");
    		long uId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String password=scan.next();
    		
    	
			if(ob.login(uId, password))
    		{
    			System.out.println("============================================================================");
    			System.out.println("                               logged in!!                                  ");
    			System.out.println("============================================================================");
    		
    			
    			System.out.println("\t\n"
    					+ "1.List of Books \r\n"
    	    			+ "2.Add Books \r\n"
    	    			+"3.change Password \r\n"
    	    			+"4.Logout");
    				

        		int operation=scan.nextInt();
  
    				if(operation==1)   //List of books
    				{
    				System.out.println("=====================================================================");
					System.out.println("                            List Of Books!!                       ");
					System.out.println("=====================================================================");
					System.out.println("Enter the Book Id for the User:");
        	       	long accId=scan.nextLong();
					ResultSet result=ob.booksList(accId);
        	       	if(result!=null)
        	       	{
                      while(result.next())
        	       		{
        	       		System.out.println("Book Name:"+result.getString(2));
        	       		System.out.println("Book Author:"+result.getString(3));
        	       		System.out.println("Book Type:"+result.getString(4));
        	       		System.out.println("Quantity:"+result.getLong(5));        	     
        	       	}
        	       	}
        	       	else
        	       	{
        	       		System.out.println("=====================================================================");
        	       		System.out.println("                  Book Id does not exist!!                        ");
        	       		System.out.println("=====================================================================");
        	       	}
					
    			}
    				
    				
    				
    				
    				
    		else if(operation==2)
			{
				
				System.out.println("=====================================================================");
				System.out.println("                               Add Books!!                       ");
				System.out.println("=====================================================================");
				
				System.out.println("Enter book Id for the book:");
				long accId=scan.nextLong();
				System.out.println("Enter book name:");
				String accName=scan.next();
				System.out.println("Enter book author:");
				String accAuthor=scan.next();
				System.out.println("Enter book type:");
				String acctype=scan.next();
				System.out.println("Enter quantity:");
				long quantity=scan.nextLong();
				

				Books u=new Books(accId,accName,accAuthor,acctype,quantity);
				if(ob.addBooks(u))
				{
					System.out.println("=====================================================================");
					System.out.println("                              Book Added!!                       ");
					System.out.println("=====================================================================");
				}
				else
				{
					System.out.println("====================================================================");
					System.out.println("                              Problem In Adding Books                        ");
					System.out.println("====================================================================");
				}
				
			}
    	
    			 else if(operation==3)  //change password
    	       	{
    	    		System.out.println("Enter new password:");
    	    		String newPassword=scan.next();
    	       		if(ob.changePassword(uId, newPassword))
    	       		{
    	       			System.out.println("====================================================================");
    	    			System.out.println("                        Password changed successfully!!             ");
    	    	       	System.out.println("====================================================================");

    	       		}
    	       		else
    	       		{
    	       			System.out.println("=====================================================================");
    	    			System.out.println("                   Problem in password change!!                      ");
    	    	       	System.out.println("=====================================================================");

    	       		}
    	       	}
  
               else if(operation==4)
    	       	{
    	       		ob.logout();
    	       		status=false;
    	       		System.out.println("=======================================================================");
        			System.out.println("                                      Logged Out!!                     ");
        	       	System.out.println("=======================================================================");

    	       	}
    	    	else 
    	       	{
    	    		System.out.println("=======================================================================");
        			System.out.println("                           Wrong Input!!                               ");
        	       	System.out.println("=======================================================================");

    	       	}
    	       	
    	       
    		}
   
    		
  		
    		else
    		{
    			System.out.println("============================================================================");
    			System.out.println("                     Borrower Id or Password Incorrect!!!                       ");
    			System.out.println("============================================================================");

    		}
    		
    	}
    	else
    	{
    	   System.out.println("\t Please enter a correct input!!");
    	}
       
    }
       catch(Exception e)
       {
    	   System.out.println(e.getMessage());
    	   System.out.println("\t Wrong Input!!");
    	   System.out.println("\t Provide Number Input!!");
    	   System.out.println("===============================================================================");
       }
    }
    	while(status);

    }
}

