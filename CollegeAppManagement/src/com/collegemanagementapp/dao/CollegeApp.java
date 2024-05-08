package com.collegemanagementapp.dao;
import java.util.Scanner;

import com.collegemanagementapp.test.CollegeAdminUser;
public  class CollegeApp {
	CollegeAdminUser collegeAdmin=new CollegeAdminUser();
	public static void collegeDetails()
	{
		
			
			System.out.println("|------   Number of staffs working in our college is:500      -------|");
			System.out.println("|------   Number of students pursuing in our college is:5000  -------|");
			System.out.println("|------   Hostel facility is available                        -------|");
			System.out.println("|------   Bus facility is available for dayscholars           -------|");
		
		
		
		}
	
	public static void CollegeDetails(int rollNo,long paidFees)
	{
		Scanner scan=new Scanner(System.in);
		long collegeFees=100000;
		
		long remFees=collegeFees-paidFees;
		System.out.println(rollNo+" remaining college fees to be paid by you is:"+remFees);
		
	}
	
}
	
		
		
	
	
	
