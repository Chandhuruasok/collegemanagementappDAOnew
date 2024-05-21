package com.collegemanagementapp.dao;
import java.sql.SQLException;
import java.util.Scanner;

import com.collegemanagementapp.model.StudentDetails;
import com.collegemanagementapp.util.DataBase;
public class CollegeAppImplement implements CollegeAppInterface{

	@Override
	public void welcome() {
		System.out.println("---Welcome to this portal---");
		
	}

	@Override
	public void thankYou() {
		// TODO Auto-generated method stub
		System.out.println("---Thank you---");
	}
	public void collegeFeatures() throws ClassNotFoundException, SQLException
	{
		StudentDetails details=new  StudentDetails();
		Scanner s=new Scanner(System.in);
		System.out.println("please enter the current year overall placement percentage:");
			   details.placementPercentage=s.nextInt();
			   if(details.placementPercentage<0)
			   {
				   System.err.println("please enter the current year overall placement percentage:");
				   details.placementPercentage=s.nextInt();
				  
			   }
			   
			   details.setPlacementPercentage(details.placementPercentage);
			  
			   System.out.println("please enter the updated new ranking of the college:");
			   details.collegeRanking=s.nextInt();
			   if(details.collegeRanking<0)
			   {
				   System.err.println("please enter the  updated new ranking of the college:");
				   details.collegeRanking=s.nextInt();
				  
			   }
			   details.setCollegeRanking(details.collegeRanking);
			  
		   
			   System.out.println("please enter the total number of companies visited at our college:");
			   details.companies=s.nextInt();
			   if(details.companies<0)
			   {
				   System.err.println("please enter the total number of companies visited at our college:");
				   details.companies=s.nextInt();
			   }
			   details.setCollegeRanking(details.companies);
			   System.out.println("please enter the year to update details:");
			   details.year=s.nextInt();
			   if(details.year<0)
			   {
				   System.err.println("please enter the year to update details:");
				   details.year=s.nextInt();
			   }
			   details.setYear(details.year);
			   System.out.println("please enter 1.insert college details into table \n 2. update college details into table");
			   int option=s.nextInt();
			   switch(option)
			   {
			   case 1:
				   DataBase.collegeDetailsInsert(details.getPlacementPercentage(), details.getCollegeRanking(), details.getCompanies(), details.getYear());
			       break;
			   case 2:
				   DataBase.collegeDetailsupdate(details.getPlacementPercentage(), details.getCollegeRanking(), details.getCompanies(), details.getYear());
				   break;
			   }
		   }
		   
		  
	}
	

