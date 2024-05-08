package com.collegemanagementapp.test;
import java.util.*;

import com.collegemanagementapp.model.CollegeManagementApp;
public class CollegeAppAbout {
	static Scanner scan=new Scanner(System.in);
    public static void view()
    {
    	System.out.println("|-----  MNK COLLEGE OF ENGINEERING AND TECHNOLOGY------ |");
    	System.out.println("|-----             MADURAI      --------------------    |");
    	System.out.println("|-----        35 YEARS OF EXCELLENCE -----------------  |");
    	
    }
    public static void motto()
    {
    	System.out.println("******Motto of our college is*******");
    	System.out.println( "|------     I CAN AND I WILL  ------------------------ |");
    }
	public static void department()
	{
		System.out.println(" *********     List Of Departments in our college       ***********");
		System.out.println(" |-----------        ELECTRONICS AND COMMUNICATION ENGINEERING          ----------- |");
		System.out.println(" |-----------        COMPUTER SCIENCE ENGINEERING                       ------------|");
		System.out.println(" |-----------        CHEMICAL ENGINEERING                               ------------|");
		System.out.println(" |-----------        MECHANICAL ENGINEERING                             ------------|");
		System.out.println(" |-----------        CIVIL ENGINEERING                                  ------------|");
		System.out.println(" |-----------        ELECTRICAL AND ELECTRONICS ENGINEERING             ------------|");
		System.out.println(" |-----------        INFORMATION TECHNOLOGY                             ------------|");
		System.out.println(" |-----------        ROBOTICS AND AUTOMATION                            ------------|");
		System.out.println(" |-----------        ARTIFICIAL INTELLIGENCE                            ------------|");
		System.out.println(" |-----------        PETROCHEMICAL               ENGINEERING            ------------|");
		System.out.println(" |-----------        ELECTRICAL AND ELECTRONICS ENGINEERING             ------------|");
		System.out.println(" |-----------        BIOMEDICAL     ENGINEERING                         ------------|");
		System.out.println(" |-----------        TEXTILE ENGINEERING                                ------------|");
		System.out.println(" |-----------        ELECTRONICS AND INSTRUMENTATION ENGINEERING        ------------|");
	}
	public static void feedback()
	{
		CollegeManagementApp collegeapp=new CollegeManagementApp();
    	System.out.println("enter the roll number:");
    	collegeapp.rollNo=scan.nextInt();
    	if(collegeapp.rollNo<0)
    	{
    		System.out.println("enter the roll number:");
        	collegeapp.rollNo=scan.nextInt();
    	}
		System.out.println("Enter 1.Rating\n 2.Review\n ");
		int choice=scan.nextInt();
		if(choice<0)
		{
			System.out.println("Enter 1.Rating\n 2.Review\n ");
			 choice=scan.nextInt();
		}
		switch(choice)
		{
		case 1:
			System.out.println("  --------Rating for college----------- ");
			System.out.println("your rating for our college(*) :");
			String ratingCollege=scan.next();
			while(true)
			{
			if(ratingCollege.matches("[*]{1,5}"))
			{
			System.out.println("Roll number "+collegeapp.rollNo+" your rating for our college out of 5 is: "+ratingCollege);
			break;
			}
			else
			{
				System.out.println("enter valid rating(*)");
				ratingCollege=scan.next();
			}
			}
			break;
		
		case 2:
			 		System.out.println("  ----------  Review for college  ------------- ");
					System.out.println("please write some review about our college:");
					scan.nextLine();
					String reviewCollege=scan.nextLine();
					System.out.println("Roll number "+collegeapp.rollNo+" your review for our college is: "+reviewCollege);
					break;
		
	}
	}
}
