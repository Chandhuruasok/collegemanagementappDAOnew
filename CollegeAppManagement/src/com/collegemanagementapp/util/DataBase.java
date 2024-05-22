package com.collegemanagementapp.util;
import com.collegemanagementapp.util.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.collegemanagementapp.model.CollegeManagementApp;
import com.collegemanagementapp.model.StudentDetails;
public class DataBase 
{
	
        
        public static void update(int rollNo,int percentage,int paidFees,String userName ) throws ClassNotFoundException,SQLException
        {
        	Connection connection=Util.getConnection();
        	String updateTable="update collegeapp set attendance_percent=?,fees_paid=?,user_name=? where roll_no=?"; 
        	PreparedStatement prepare=connection.prepareStatement(updateTable);
        	prepare.setInt(4,rollNo);
        	prepare.setInt(1,percentage);
        	prepare.setInt(2,paidFees);
        	prepare.setString(3,userName);
        	int row=prepare.executeUpdate();
        	System.out.println("updated data:"+row);
        	connection.close();
        }
        public static void delete(int rollNo) throws ClassNotFoundException,SQLException
        {
        	Connection connection=Util.getConnection();
        	String deleteTable="delete from collegeapp where roll_no=?"; 
        	PreparedStatement prepare=connection.prepareStatement(deleteTable);
        	prepare.setInt(1,rollNo);
        	int row=prepare.executeUpdate();
        	System.out.println("Deleted data:"+row);
        	connection.close();
        }
        public static void insert(int rollNo,int attendancePercentage,int feesPaid,String userName) throws ClassNotFoundException,SQLException
        {
        	Connection connection=Util.getConnection();
        	String insertTable="insert into collegeapp values(?,?,?,?)";
        	PreparedStatement prepare=connection.prepareStatement(insertTable);
        	prepare.setInt(1,rollNo);
        	prepare.setInt(2,attendancePercentage);
        	prepare.setInt(3,feesPaid);
        	prepare.setString(4,userName);
        	int row=prepare.executeUpdate();
        	System.out.println("inserted data:"+row);
        	connection.close();
        }
        public static List<CollegeManagementApp> listofStudents() throws ClassNotFoundException, SQLException {
          Connection connection = Util.getConnection();
          String listOfInput = "select roll_no, attendance_Percent, fees_paid,user_name from collegeapp";
          PreparedStatement ps = connection.prepareStatement(listOfInput);
          ArrayList<CollegeManagementApp> list = new ArrayList<CollegeManagementApp>();
          ResultSet resultSet = ps.executeQuery();
          while (resultSet.next()) {
              int rollNo = resultSet.getInt("roll_no");
              int attendancePercentage = resultSet.getInt("attendance_percent");
              int feesPaid = resultSet.getInt("fees_paid"); 
              String userName=resultSet.getString("user_name");
              CollegeManagementApp collegemanage = new CollegeManagementApp();
              
              collegemanage.setRollNo(rollNo);
              collegemanage.setAttendancePercentage(attendancePercentage);
              collegemanage.setGetFeesPaid(feesPaid);
              collegemanage.setUserName2(userName);
              list.add(collegemanage);
              System.out.println(list);
          }
          return list;
      }
        public static boolean register(int rollNo,Scanner scanner) throws ClassNotFoundException, SQLException {
        	boolean flag=false;
            CollegeManagementApp collegemanage=new CollegeManagementApp();
            ArrayList existingList = new ArrayList();
            Connection connection =Util.getConnection();
            String query = "select rollNumber from adminUpdateTable1";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int userName3 = resultSet.getInt("rollNumber");
                existingList.add(userName3);
            }
            while(true) {
                if (existingList.contains(rollNo)) {
                    System.out.println("roll number already exists:");
                    System.out.println("Enter the roll number:");
                    rollNo = scanner.nextInt();
                    StudentDetails.setRollNumber(rollNo);
                    flag = false;
                } else {
                    System.out.println("user name available for Registration");
                    flag = true;
                    break;
                }
            }
            return flag;
        }
        public static boolean adminCheck(String adminName,String adminPassword) throws ClassNotFoundException, SQLException
        {
        	Connection connection=Util.getConnection();
        	String query="select admin_name from admin where admin_name=? and admin_password =?";
        	PreparedStatement ps=connection.prepareStatement(query);
        	ps.setString(1, adminName);
        	ps.setString(2, adminPassword);
            ResultSet rs=ps.executeQuery();
        	if(!rs.next())
        	{
        		System.out.println("username and password doesn't match");
        		return false;
        	}
        	else 
        	{
                System.out.println("username and password matches");
        		return true;
        		
        	}
        }	
        	public static void insertStudent(int rollNumber,String studentName,String course,String department,String yearOfPursuing,int attendancePercentage,long remainingCollegeFees,long remainingBookFees,int remainingExamFees) throws ClassNotFoundException,SQLException
            {
            	Connection connection=Util.getConnection();
            	String insertTable="insert into adminUpdateTable1 values(?,?,?,?,?,?,?,?,?)";
            	PreparedStatement prepare=connection.prepareStatement(insertTable);
            	prepare.setInt(1,rollNumber);
            	prepare.setString(2,studentName);
            	prepare.setString(3,course);
            	prepare.setString(4,department);
            	prepare.setString(5,yearOfPursuing);
            	prepare.setInt(6,attendancePercentage);
            	prepare.setLong(7,remainingCollegeFees);
            	prepare.setLong(8,remainingBookFees);
            	prepare.setInt(9,remainingExamFees);
            	int row=prepare.executeUpdate();
            	System.out.println("inserted data:"+row);
            	connection.close();
            }
   
        	public static void updateStudent(int rollNumber,String studentName,String course,String department,String yearOfPursuing,int attendancePercentage,long remainingCollegeFees,long remainingBookFees,int remainingExamFees ) throws ClassNotFoundException,SQLException
            {
            	Connection connection=Util.getConnection();
            	String updateTable="update adminUpdateTable1  set studentName=?,course=?,department=?,yearOfPursuing=?,attendancePercentage=?,remainingCollegeFees=?,remainingBookFees=?,remainingExamFees=? where rollNumber=?";
            	PreparedStatement prepare=connection.prepareStatement(updateTable);
            	prepare.setInt(9,rollNumber);
            	prepare.setString(1,studentName);
            	prepare.setString(2,course);
            	prepare.setString(3,department);
            	prepare.setString(4,yearOfPursuing);
            	prepare.setInt(5,attendancePercentage);
            	prepare.setLong(6,remainingCollegeFees);
            	prepare.setLong(7,remainingBookFees);
            	prepare.setInt(8,remainingExamFees);
            	int row=prepare.executeUpdate();
            	System.out.println("updated data:"+row);
            	connection.close();
            }
        	
        	public static void deleteStudent(int rollNumber) throws ClassNotFoundException,SQLException
            {
            	Connection connection=Util.getConnection();
            	String deleteTable="delete from adminUpdateTable1 where rollNumber=?"; 
            	PreparedStatement prepare=connection.prepareStatement(deleteTable);
            	prepare.setInt(1,rollNumber);
            	int row=prepare.executeUpdate();
            	System.out.println("Deleted data:"+row);
            	connection.close();
            }
        	public static void studentDetails(int rollNo) throws ClassNotFoundException, SQLException
            {
                Connection connection=Util.getConnection();
                String query="select studentName,course,department,yearOfPursuing,attendancePercentage,remainingCollegeFees,remainingBookFees,remainingExamFees from adminUpdateTable1 where rollNumber=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, rollNo);
                ResultSet resultSet = ps.executeQuery();
                java.sql.ResultSetMetaData rsmd=resultSet.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    System.out.printf("%-21s", rsmd.getColumnName(i)); 
                }
                System.out.println(); 

                
                while (resultSet.next()) {
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String value = resultSet.getString(i);
                        System.out.printf("%-23s", value); 
                    }
                    System.out.println(); 
                }
}
   public static void updateCollegeFees(int rollNo, String name,long fee) throws ClassNotFoundException, SQLException {
	   
       Connection connection=Util.getConnection();
       long remainingFees=0;
       long balanceFee=0;
       String query="select remainingCollegeFees from adminUpdateTable1 where studentName=? and rollNumber=? ";
       PreparedStatement ps = connection.prepareStatement(query);
       ps.setString(1, name);
       ps.setInt(2, rollNo);
       ResultSet resultSet = ps.executeQuery();
       while(resultSet.next()) {
    	   remainingFees= resultSet.getLong("remainingCollegeFees");
    	   balanceFee =remainingFees-fee;
       }
       String query1="update adminUpdateTable1 set remainingCollegeFees=? where studentName=? and rollNumber=? ";
       ps = connection.prepareStatement(query1);
       ps.setLong(1, balanceFee);
       ps.setString(2, name);
       ps.setInt(3, rollNo);
       int row = ps.executeUpdate();
       System.out.println("Fees updated : "+row );
   }
public static void updateBookFees(int rollNo, String name,long bookFee) throws ClassNotFoundException, SQLException {
	   
       Connection connection=Util.getConnection();
       long remainingBookFees=0;
       long balanceBookFees=0;
       String query="select remainingBookFees from adminUpdateTable1 where studentName=? and rollNumber=? ";
       PreparedStatement ps = connection.prepareStatement(query);
       ps.setString(1, name);
       ps.setInt(2, rollNo);
       ResultSet resultSet = ps.executeQuery();
       while(resultSet.next()) {
    	   remainingBookFees= resultSet.getLong("remainingBookFees");
    	   balanceBookFees =remainingBookFees-bookFee;
       }
       String query1="update adminUpdateTable1 set remainingBookFees=? where studentName=? and rollNumber=? ";
       ps = connection.prepareStatement(query1);
       ps.setLong(1, balanceBookFees);
       ps.setString(2, name);
       ps.setInt(3, rollNo);
       int row = ps.executeUpdate();
       System.out.println("Fees updated : "+row );
   }
public static void updateExamFees(int rollNo, String name,int bookFee) throws ClassNotFoundException, SQLException {
	   
    Connection connection=Util.getConnection();
    long remainingExamFees=0;
    long balanceExamFees=0;
    String query="select remainingExamFees from adminUpdateTable1 where studentName=? and rollNumber=? ";
    PreparedStatement ps = connection.prepareStatement(query);
    ps.setString(1, name);
    ps.setInt(2, rollNo);
    ResultSet resultSet = ps.executeQuery();
    while(resultSet.next()) {
 	   remainingExamFees= resultSet.getLong("remainingExamFees");
 	   balanceExamFees =remainingExamFees-bookFee;
    }
    String query1="update adminUpdateTable1 set remainingExamFees=? where studentName=? and rollNumber=? ";
    ps = connection.prepareStatement(query1);
    ps.setLong(1, balanceExamFees);
    ps.setString(2, name);
    ps.setInt(3, rollNo);
    int row = ps.executeUpdate();
    System.out.println("Fees updated : "+row );
}
public static void collegeDetailsInsert(int placement, int collegeRanking,int companiesVisited,int year) throws ClassNotFoundException, SQLException {
	   
       Connection connection=Util.getConnection();
       String insertTable="insert into collegeDetails values(?,?,?,?)";
   	PreparedStatement prepare=connection.prepareStatement(insertTable);
   	prepare.setInt(1,placement);
   	prepare.setInt(2,collegeRanking);
   	prepare.setInt(3,companiesVisited);
   	prepare.setInt(4,year);
   	int row=prepare.executeUpdate();
   	System.out.println("inserted data:"+row);
   	connection.close();
   }

	public static void collegeDetailsupdate(int placement, int collegeRanking,int companiesVisited,int year) throws ClassNotFoundException,SQLException
   {
   	Connection connection=Util.getConnection();
   	String updateTable="update collegeDetails  set placement=?,collegeRanking=? ,totalCompaniesVisited=? where YearUpdated=?";
   	PreparedStatement prepare=connection.prepareStatement(updateTable);
   	
   	prepare.setInt(1,placement);
   	prepare.setInt(2,collegeRanking);
   	prepare.setInt(3,companiesVisited);
   	prepare.setInt(4,year);
   	
   	int row=prepare.executeUpdate();
   	System.out.println("updated data:"+row);
   	connection.close();
   }
	public static void collegeDetailsView() throws ClassNotFoundException, SQLException
    {
        Connection connection=Util.getConnection();
        String query="select placement,collegeRanking,totalCompaniesVisited,YearUpdated from collegeDetails";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        java.sql.ResultSetMetaData rsmd=resultSet.getMetaData();
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-21s", rsmd.getColumnName(i)); 
        }
        System.out.println(); 

        
        while (resultSet.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                String value = resultSet.getString(i);
                System.out.printf("%-23s", value); 
            }
            System.out.println(); 
        }
}
}

