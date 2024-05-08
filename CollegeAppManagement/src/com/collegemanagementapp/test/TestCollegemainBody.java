package com.collegemanagementapp.test;
import java.sql.SQLException;
import java.util.Scanner;

import com.collegemanagementapp.dao.CollegeApp;
import com.collegemanagementapp.model.CollegeManagementApp;

public class TestCollegemainBody {
    
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner=new Scanner(System.in);
		CollegeManagementApp collegeManage=new CollegeManagementApp();
		CollegeApp collegeApp=new CollegeApp();
		System.out.println("---COLLEGE MANAGEMENT APP---");
		System.out.println("select \n 1.admin\n 2.user\n 3.exit");
		collegeManage.selectOption=scanner.nextInt();
		if(collegeManage.selectOption<0)
		{
			System.out.println("select \n 1.admin\n 2.user\n 3.exit");
			collegeManage.selectOption=scanner.nextInt();
		}
		while(true)
		{
		 if(collegeManage.selectOption==1||collegeManage.selectOption==2||collegeManage.selectOption==3)
		 {
		switch(collegeManage.selectOption)
		{
			case 1:
			CollegeAdminUser.psnaAdmin();
			return;
			case 2:
				CollegeAdminUser.psnaUser();
				return;
			case 3:
				System.out.println("Exited sucessfully");
				System.out.println("select \n 1.admin\n 2.user\n 3.exit");
				collegeManage.selectOption=scanner.nextInt();
				
			
				
		}
		 }
		 else
		 {
			 System.out.println("enter the valid data:");
			 collegeManage.selectOption=scanner.nextInt();
		 }
		
		
}
}
}
