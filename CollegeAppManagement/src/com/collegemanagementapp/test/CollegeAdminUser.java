package com.collegemanagementapp.test;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.collegemanagementapp.dao.CollegeApp;
import com.collegemanagementapp.dao.CollegeAppImplement;
import com.collegemanagementapp.model.CollegeManagementApp;
import com.collegemanagementapp.util.DataBase;
public class CollegeAdminUser {
	
	static Scanner s=new Scanner(System.in);
	public static void psnaAdmin() throws ClassNotFoundException, SQLException
	{	
		CollegeManagementApp collegeManagementApp=new CollegeManagementApp();
	    CollegeAppImplement abstractextend=new CollegeAppImplement();
		
	
		while(true)
		{
		System.out.println("Enter the admin name:");
		collegeManagementApp.setAdminName(s.next());
		System.out.println("Enter the admin password:");
		collegeManagementApp.setAdminPassword(s.next());
		
		if(DataBase.adminCheck(collegeManagementApp.getAdminName(),collegeManagementApp.getAdminPassword() )) 
		{
			CollegeAdminUser.admin();
			break;
		
		}
	
		else
		{
			System.out.println("please enter valid admin name and password");
		}
		
		}
	}
		public static void admin() throws ClassNotFoundException, SQLException
		{
			CollegeAppImplement abstractextend=new CollegeAppImplement();
			CollegeManagementApp collegeManagementApp=new CollegeManagementApp();
		abstractextend.welcome();
		System.out.println("------------    Welcome Admin ------------");
		System.out.println("------------ LOGIN SUCCESSFUL ------------");
		System.out.println("whether you need to add extra features(1.yes/2.no/3.delete data from database):");
		int option=s.nextInt();
		if(option<0)
		{
			System.out.println("whether you need to add extra features(1.yes/2.no/3.delete data from database):");
			option=s.nextInt();
		}
		switch(option)
		{
		   case 1:
			   System.out.println("---Features can be added---");
			   System.out.println("select option to add features(1.Placement 2.Ranking 3.companies)");
			   int o=s.nextInt();
			   if(o<0)
			   {
				   System.out.println("select option to add features(1.Placement 2.Ranking 3.companies)");
				    o=s.nextInt();
			   }
			   
			   switch(o)
			   {
			   case 1:
				   System.out.println("please enter the current year overall placement percentage:");
				   double percent=s.nextDouble();
				   if(percent<0)
				   {
					   System.err.println("please enter the current year overall placement percentage:");
					   percent=s.nextDouble();
					  
				   }
				   System.out.println("current overall placement percentage of our college is:"+percent);
				   System.out.println("---Thank you features are updated---");
				   break;
			   case 2:
				   System.out.println("please enter the updated new ranking of the college:");
				   int rank=s.nextInt();
				   if(rank<0)
				   {
					   System.err.println("please enter the  updated new ranking of the college:");
					   rank=s.nextInt();
					  
				   }
				   System.out.println("current ranking of our college is:"+rank);
				   System.out.println("---Thank you features are updated---");
				   break;
			   case 3:
				   System.out.println("please enter the total number of companies visited at our college:");
				   int company=s.nextInt();
				   if(company<0)
				   {
					   System.err.println("please enter the total number of companies visited at our college:");
					   company=s.nextInt();
				   }
				   System.out.println("Total number of companies visited at our college for current year:"+company);
				   System.out.println("---Thank you features are updated---");
				   break;
			   }
			   
			   break;
		   case 2:
			   System.out.println("---Thank you No features are added---");
			   break;
		   case 3:
			   System.out.println("delete any datas from database:");
			   System.out.println("please enter the roll number to delete from the database:");
			   collegeManagementApp.rollNo=s.nextInt();
			   if(collegeManagementApp.rollNo<0)
			   {
				   System.err.println("please enter the roll number to delete from the database:");
				   collegeManagementApp.rollNo=s.nextInt();
			   }
			   collegeManagementApp.setRollNo( collegeManagementApp.rollNo);
			   DataBase.delete( collegeManagementApp.getRollNo());
			   break;
		}
		
		
		abstractextend.thankYou();
		
	}
		
	public static void psnaUser() throws ClassNotFoundException, SQLException
	{
		CollegeManagementApp cm=new CollegeManagementApp();
		CollegeAppImplement abstractextend=new CollegeAppImplement();
		TestRollNumber testRollNumber=new TestRollNumber();
	    Scanner scan=new Scanner(System.in);
	    String userNamePsna="^[a-zA-Z]{4,}$";
		String userPasswordPsna="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
	    abstractextend.welcome();
		System.out.println("Whether you are 1.new user\n 2.existing user\n 3.view college details\n 4.available courses\n 5.feedback");
		try {
	    int option=scan.nextInt();
	    if(option<0)
	    {
	    	System.out.println("Whether you are 1.new user\n 2.existing user\n 3.view college details\n 4.available courses");
		    option=scan.nextInt();
	    }
	    if(option==1)
	    {
	    	
	    	System.out.println("------------ SIGN UP PAGE --------------");
	    	System.out.println("create userName:");
	    	cm.userName1=scan.next();
	    	System.out.println("enter the roll number:");
	    	cm.rollNo=scan.nextInt();
	    	if(DataBase.register(cm.rollNo, scan))
	    	{
	    	
	    	
	    	System.out.println("create userPassword:");
	    	cm.userPassword1=scan.next();
	    	while(!(cm.userPassword1.matches(userPasswordPsna)))
	    	{
	    		System.out.println("create userPassword:");
		    	 cm.userPassword1=scan.next();
	    	}
	    	System.out.println("---SIGN UP SUCCESSFUL---");
	    	}
	    	
	    }
	    else if(option==2)
	    {
	    	System.out.println("---LOGIN PAGE---");
	    	System.out.println("Enter the user name:");
	        cm.userName2=scan.next();
	        
	    	while(!(cm.userName2.matches(userNamePsna)))
	    	{
	    		System.err.println("Enter the user name:");
		    	 cm.userName2=scan.next();
	    	}
	    	while(true)
	    	{
	    		System.out.println("enter the roll number:");
		    	cm.rollNo=scan.nextInt();
	    		try
	    		{
	    		  testRollNumber.validate(cm.rollNo);
	    	      break;
	    		}
	    		catch(Exception e)
	    		{
	    			System.out.println(e);
	    		}
	    	}
	    	System.out.println("Enter the user password:");
	    	 cm.userPassword2=scan.next();
	    	 while(!(cm.userPassword2.matches(userPasswordPsna)))
		    	{
		    		System.out.println("Enter the user name:");
			    	 cm.userName2=scan.next();
		    	}
	    	 System.out.println("---LOGIN SUCCESSFUL---");
	    		
	    }
	    else if(option==3)
	    {
	    	CollegeAppAbout.view();
	    	CollegeAppAbout.motto();
	    	CollegeApp.collegeDetails();
	    	System.exit(0);
	    }
	    else if(option==4)
	    {
	    	CollegeAppAbout.department();
	    	System.exit(0);
	    } 
	    else if(option==5)
	    {
	    	CollegeAppAbout.feedback();
	    	System.exit(0);
	    }
	    else
	    {
	    	System.out.println("wrong option");
	    }
	   
		System.out.println("---Welcome User---");
		System.out.println("enter your roll number:");
		
		int rollNo=scan.nextInt();
		if(rollNo<0)
		{
			System.err.println("Enter your roll number:");
			rollNo=scan.nextInt();
		}
		
		System.out.println("Enter your attendance percentage:");
		int percent=scan.nextInt();
		if(percent<0)
		{
			System.err.println("Enter your attendance percentage:");
			 percent=scan.nextInt();
		}
		if(percent>70)
		{
			System.out.println("you are eligible to write the exam");
		}
		else
		{
			System.out.println("pay Rs.100 to attend the exam");
		}
		
		System.out.println("Enter the college fees you have paid already:");
		int paidFees=scan.nextInt();
		if(paidFees<0)
		{
			System.err.println("Enter the college fees you have paid already:");
			paidFees=scan.nextInt();
		}
		CollegeApp.CollegeDetails(rollNo,paidFees);
		System.out.println("select 1.insert\n 2.update:");
		int choice=scan.nextInt();
		if(choice<0)
		{
			System.out.println("select 1.insert\n 2.update:");
			choice=scan.nextInt();
		}
		switch(choice)
		{
		case 1:
			DataBase.insert(rollNo, percent, paidFees,cm.userName2);
			break;
		case 2:
			DataBase.update(rollNo, percent,paidFees,cm.getUserName2());
			break;
		
		
			default:
				System.out.println("wrong choice");
		}
		abstractextend.thankYou();		
	}
		catch(InputMismatchException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
class TestRollNumber
{
	void validate(int rollNo) throws InvalidRollNumber
	{
		if(rollNo<0)
		{
			throw new InvalidRollNumber("not valid number");
		}
		else
		{
			System.out.println("valid number");
		}
	}
}
