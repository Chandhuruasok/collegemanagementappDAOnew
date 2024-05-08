package com.collegemanagementapp.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.collegemanagementapp.model.CollegeManagementApp;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
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
            String query = "select roll_no from collegeapp";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int userName3 = resultSet.getInt("roll_no");
                existingList.add(userName3);
            }
            while(true) {
                if (existingList.contains(rollNo)) {
                    System.out.println("roll number already exists:");
                    System.out.println("Enter the roll number:");
                    rollNo = scanner.nextInt();
                    collegemanage.setRollNo(rollNo);
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
    
        		return true;
        		
        	}
        		
        		
        	
        	
        }
}

