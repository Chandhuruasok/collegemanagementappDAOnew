package com.collegemanagementapp.test;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.collegemanagementapp.dao.CollegeApp;
import com.collegemanagementapp.dao.CollegeAppImplement;
import com.collegemanagementapp.model.CollegeManagementApp;
import com.collegemanagementapp.model.StudentDetails;
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
			StudentDetails details=new  StudentDetails();
		abstractextend.welcome();
		System.out.println("------------    Welcome Admin ------------");
		System.out.println("------------ LOGIN SUCCESSFUL ------------");
		System.out.println("whether you need to add extra features(1.yes \n 2.no \n 3.insert data into database \n 4.update data from database \n 5.delete data from database):");
		int option=s.nextInt();
		if(option<0)
		{
			System.out.println("whether you need to add extra features(1.yes \n 2.no \n 3.insert data into database \n 4.update data from database \n 5.delete data from database):");
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
			   System.out.println("insert any data into database:");
			   System.out.println("Please enter the roll number to insert into database:");
			   details.rollNumber=s.nextInt();
			   if(details.rollNumber<0)
			   {
				   System.err.println("Please enter the roll number again to insert into database:");
				   details.rollNumber=s.nextInt(); 
			   }
			   details.setRollNumber(details.rollNumber);
			   System.out.println("Please enter the  student name to insert into database:");
			   details.studentName=s.next();
			   details.setStudentName(details.studentName);
			   System.out.println("Please enter the course to insert into database:");
			   details.course=s.next();
			   details.setCourse(details.course);
			   System.out.println("Please enter the department to insert into database:");
			   details.department=s.next();
			   details.setDepartment(details.department);
			   System.out.println("Please enter the year of pursuing to insert into database:");
			   details.yearOfPursuing=s.next();
			   details.setYearOfPursuing(details.yearOfPursuing);
			   System.out.println("Please enter the attendance percentage to insert into database:");
			   details.attendancePercentage=s.nextInt();
			   if(details.attendancePercentage<0)
			   {
				   System.err.println("Please enter the attendance percentage again to insert into database:");
				   details.attendancePercentage=s.nextInt(); 
			   }
			   details.setAttendancePercentage(details.attendancePercentage);
			   System.out.println("Please enter the remaining college fees to insert into database:");
			   details.remainingCollegeFees=s.nextLong();
			   details.setRemainingCollegeFees(details.remainingCollegeFees);
			   System.out.println("Please enter the remaining book fees to insert into database:");
			   details.remainingBookFees=s.nextLong();
			   details.setRemainingBookFees(details.remainingBookFees);
			   System.out.println("Please enter the remaining exam fees to insert into database:");
			   details.remainingExamFees=s.nextInt();
			   details.setRemainingExamFees(details.remainingExamFees);
			   DataBase.insertStudent(details.getRollNumber(),details.getStudentName(), details.getCourse(), details.getDepartment(),details.getYearOfPursuing(), details.getAttendancePercentage(), details.getRemainingCollegeFees(), details.getRemainingBookFees(),details.getRemainingExamFees());	
			   break;
		  case 4:
			   System.out.println("update any data into database:");
			   System.out.println("Please enter the roll number to update into database:");
			   details.rollNumber=s.nextInt();
			   if(details.rollNumber<0)
			   {
				   System.err.println("Please enter the roll number again to update into database:");
				   details.rollNumber=s.nextInt(); 
			   }
			   details.setRollNumber(details.rollNumber);
			   System.out.println("Please enter the  student name to update into database:");
			   details.studentName=s.next();
			   details.setStudentName(details.studentName);
			   System.out.println("Please enter the course to update into database:");
			   details.course=s.next();
			   details.setCourse(details.course);
			   System.out.println("Please enter the department to update into database:");
			   details.department=s.next();
			   details.setDepartment(details.department);
			   System.out.println("Please enter the year of pursuing to update into database:");
			   details.yearOfPursuing=s.next();
			   details.setYearOfPursuing(details.yearOfPursuing);
			   System.out.println("Please enter the attendance percentage to update into database:");
			   details.attendancePercentage=s.nextInt();
			   if(details.attendancePercentage<0)
			   {
				   System.err.println("Please enter the attendance percentage again to update into database:");
				   details.attendancePercentage=s.nextInt(); 
			   }
			   details.setAttendancePercentage(details.attendancePercentage);
			   System.out.println("Please enter the remaining college fees to update into database:");
			   details.remainingCollegeFees=s.nextLong();
			   details.setRemainingCollegeFees(details.remainingCollegeFees);
			   System.out.println("Please enter the remaining book fees to update into database:");
			   details.remainingBookFees=s.nextLong();
			   details.setRemainingBookFees(details.remainingBookFees);
			   System.out.println("Please enter the remaining exam fees to update into database:");
			   details.remainingExamFees=s.nextInt();
			   details.setRemainingExamFees(details.remainingExamFees);
			   DataBase.updateStudent(details.getRollNumber(),details.getStudentName(), details.getCourse(), details.getDepartment(),details.getYearOfPursuing(), details.getAttendancePercentage(), details.getRemainingCollegeFees(), details.getRemainingBookFees(),details.getRemainingExamFees());		
			   break;
		  case 5:
			  System.out.println("delete any data from database:");
			   System.out.println("Please enter the roll number to delete from database:");
			   details.rollNumber=s.nextInt();
			   if(details.rollNumber<0)
			   {
				   System.err.println("Please enter the roll number again to delete from database:");
				   details.rollNumber=s.nextInt(); 
			   }
			   details.setRollNumber(details.rollNumber);
			   DataBase.deleteStudent(details.getRollNumber());
			   break;
			default:
				System.out.println("Enter correct choice");
		
		abstractextend.thankYou();
		}
		
		}	
	public static void psnaUser() throws ClassNotFoundException, SQLException
	{
		CollegeManagementApp cm=new CollegeManagementApp();
		CollegeAppImplement abstractextend=new CollegeAppImplement();
		TestRollNumber testRollNumber=new TestRollNumber();
		StudentDetails student=new StudentDetails();
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
		
		System.out.println("Enter the choice 1.view student details \n 2.pay college fees");
		cm.selectOption=scan.nextInt();
		switch(cm.selectOption)
		{
		case 1:
			System.out.println("Enter the roll number:");
			student.rollNumber=scan.nextInt();
			student.setRollNumber(student.rollNumber);
		DataBase.studentDetails(student.getRollNumber());
		break;
		case 2:
			System.out.println("Enter the roll number:");
			student.rollNumber=scan.nextInt();
			student.setRollNumber(student.rollNumber);
			System.out.println("Enter the student name:");
			student.studentName=scan.next();
			student.setStudentName(student.studentName);
			System.out.println("Enter the college fees you wish to pay:");
			long fees=scan.nextLong();
			DataBase.updateFees(student.getRollNumber(),student.getStudentName() ,fees);
			break;
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
