package com.collegemanagementapp.dao;

import java.sql.SQLException;

public interface CollegeAppInterface {
	public  void welcome(); 
	public void thankYou();
	public void collegeFeatures() throws ClassNotFoundException, SQLException;
}
