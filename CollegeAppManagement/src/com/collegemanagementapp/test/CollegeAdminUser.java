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
			CollegeAppImplement interfaceExtend=new CollegeAppImplement();
			CollegeManagementApp collegeManagementApp=new CollegeManagementApp();
			StudentDetails details=new  StudentDetails();
		interfaceExtend.welcome();
		System.out.println("------------    Welcome Admin ------------");
		System.out.println("------------ LOGIN SUCCESSFUL ------------");
		System.out.println("whether you need to add extra features(1.college features \n 2.no \n 3.insert student data into database \n 4.update student data from database \n 5.delete student data from database):");
		int option=s.nextInt();
		if(option<0)
		{
			System.out.println("whether you need to add extra features(1.college features \n 2.no \n 3.insert data into database \n 4.update student data from database \n 5.delete student data from database):");
			option=s.nextInt();
		}
		switch(option)
		{
		   case 1:
			   System.out.println("---Features can be added---");
			   interfaceExtend.collegeFeatures();
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
			   while(!(details.studentName.matches("^[a-zA-Z]{4,}$")))
			   {
				   System.err.println("Please enter the  student name  again to insert into database:");
				   details.studentName=s.next();
			   }
			   details.setStudentName(details.studentName);
			   System.out.println("Please enter the course to insert into database:");
			   details.course=s.next();
			   while(!(details.course.matches("^[a-zA-Z]{1,}$")))
			   {
				   System.err.println("Please enter the course again to  insert into database:");
				   details.course=s.next();
			   }
			   details.setCourse(details.course);
			   
			   System.out.println("Please enter the department to insert into database:");
			   details.department=s.next();
			   while(!(details.department.matches("^[a-zA-Z]{2,}$")))
			   {
				   System.out.println("Please enter the department again to insert into database:");
				   details.department=s.next();
			   }
			   details.setDepartment(details.department);
			   System.out.println("Please enter the year of pursuing to insert into database:");
			   details.yearOfPursuing=s.next();
			   while(!(details.yearOfPursuing.matches("^[a-zA-Z]{1,}$")))
			   {
				   System.err.println("Please enter the year of pursuing to insert into database:");
				   details.yearOfPursuing=s.next();   
			   }
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
			   if(details.remainingCollegeFees<0)
			   {
				   System.err.println("Please enter the remaining college fees again to insert into database:");
				   details.remainingCollegeFees=s.nextLong();
			   }
			   details.setRemainingCollegeFees(details.remainingCollegeFees);
			   System.out.println("Please enter the remaining book fees to insert into database:");
			   details.remainingBookFees=s.nextLong();
			   if(details.remainingBookFees<0)
			   {
				   System.err.println("Please enter the remaining book fees again to insert into database:");
				   details.remainingBookFees=s.nextLong();
			   }
			   details.setRemainingBookFees(details.remainingBookFees);
			   System.out.println("Please enter the remaining exam fees to insert into database:");
			   details.remainingExamFees=s.nextInt();
			   if(details.remainingExamFees<0)
			   {
				   System.err.println("Please enter the remaining exam fees again to insert into database:");
				   details.remainingExamFees=s.nextInt();
			   }
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
			   while(!(details.studentName.matches("^[a-zA-Z]{4,}$")))
			   {
				   System.err.println("Please enter the  student name  again to insert into database:");
				   details.studentName=s.next();
			   }
			   details.setStudentName(details.studentName);
			   System.out.println("Please enter the course to update into database:");
			   details.course=s.next();
			   while(!(details.course.matches("^[a-zA-Z]{2,}$")))
			   {
				   System.err.println("Please enter the course again to  insert into database:");
				   details.course=s.next();
			   }
			   details.setCourse(details.course);
			   System.out.println("Please enter the department to update into database:");
			   details.department=s.next();
			   while(!(details.department.matches("^[a-zA-Z]{2,}$")))
			   {
				   System.out.println("Please enter the department again to insert into database:");
				   details.department=s.next();
			   }
			   details.setDepartment(details.department);
			   System.out.println("Please enter the year of pursuing to update into database:");
			   details.yearOfPursuing=s.next();
			   while(!(details.yearOfPursuing.matches("^[a-zA-Z]{1,}$")))
			   {
				   System.err.println("Please enter the year of pursuing to insert into database:");
				   details.yearOfPursuing=s.next();   
			   }
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
			   if(details.remainingCollegeFees<0)
			   {
				   System.err.println("Please enter the remaining college fees again to insert into database:");
				   details.remainingCollegeFees=s.nextLong();
			   }
			   details.setRemainingCollegeFees(details.remainingCollegeFees);
			   System.out.println("Please enter the remaining book fees to update into database:");
			   details.remainingBookFees=s.nextLong();
			   if(details.remainingBookFees<0)
			   {
				   System.err.println("Please enter the remaining book fees again to insert into database:");
				   details.remainingBookFees=s.nextLong();
			   }
			   details.setRemainingBookFees(details.remainingBookFees);
			   System.out.println("Please enter the remaining exam fees to update into database:");
			   details.remainingExamFees=s.nextInt();
			   if(details.remainingExamFees<0)
			   {
				   System.err.println("Please enter the remaining exam fees again to insert into database:");
				   details.remainingExamFees=s.nextInt();
			   }
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
		
		interfaceExtend.thankYou();
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
		
		System.out.println("Enter the choice 1.view student details \n 2.pay college fees \n 3.pay book fees \n 4.pay exam fees \n 5.placement and other related details");
		cm.selectOption=scan.nextInt();
		switch(cm.selectOption)
		{
		case 1:
			System.out.println("Enter the roll number:");
			student.rollNumber=scan.nextInt();
			if(student.rollNumber<0)
			{
				System.err.println("Enter the roll number:");
				student.rollNumber=scan.nextInt();
			}
			student.setRollNumber(student.rollNumber);
		DataBase.studentDetails(student.getRollNumber());
		break;
		case 2:
			System.out.println("Enter the roll number:");
			student.rollNumber=scan.nextInt();
			if(student.rollNumber<0)
			{
				System.err.println("Enter the roll number:");
				student.rollNumber=scan.nextInt();
			}
			student.setRollNumber(student.rollNumber);
			System.out.println("Enter the student name:");
			student.studentName=scan.next();
			while(!(student.studentName.matches("^[a-zA-Z]{4,}$")))
			{
				System.err.println("Enter the student name:");
				student.studentName=scan.next();
			}
			student.setStudentName(student.studentName);
			System.out.println("Enter the college fees you wish to pay:");
			long fees=scan.nextLong();
			if(fees<0)
			{
				System.out.println("Enter the college fees you wish to pay:");
				 fees=scan.nextLong();
			}
			DataBase.updateCollegeFees(student.getRollNumber(),student.getStudentName() ,fees);
			break;
		case 3:
			System.out.println("Enter the roll number:");
			student.rollNumber=scan.nextInt();
			if(student.rollNumber<0)
			{
				System.err.println("Enter the roll number:");
				student.rollNumber=scan.nextInt();
			}
			student.setRollNumber(student.rollNumber);
			System.out.println("Enter the student name:");
			student.studentName=scan.next();
			while(!(student.studentName.matches("^[a-zA-Z]{4,}$")))
			{
				System.err.println("Enter the student name:");
				student.studentName=scan.next();
			}
			student.setStudentName(student.studentName);
			System.out.println("Enter the book fees you wish to pay:");
			long bookFees=scan.nextLong();
			if(bookFees<0)
			{
				System.out.println("Enter the book fees you wish to pay:");
				 bookFees=scan.nextLong();
			}
			
			DataBase.updateBookFees(student.getRollNumber(),student.getStudentName() ,bookFees);
			break;
		case 4:
			System.out.println("Enter the roll number:");
			student.rollNumber=scan.nextInt();
			if(student.rollNumber<0)
			{
				System.err.println("Enter the roll number:");
				student.rollNumber=scan.nextInt();
			}
			student.setRollNumber(student.rollNumber);
			System.out.println("Enter the student name:");
			student.studentName=scan.next();
			while(!(student.studentName.matches("^[a-zA-Z]{4,}$")))
			{
				System.err.println("Enter the student name:");
				student.studentName=scan.next();
			}
			student.setStudentName(student.studentName);
			System.out.println("Enter the book fees you wish to pay:");
			int examFees=scan.nextInt();
			if(examFees<0)
			{
				System.out.println("Enter the book fees you wish to pay:");
				 bookFees=scan.nextLong();
			}
			
			DataBase.updateExamFees(student.getRollNumber(),student.getStudentName() ,examFees);
			break;
		case 5:
			DataBase.collegeDetailsView();
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
