package com.collegemanagementapp.model;

public class CollegeManagementApp {
	public String adminName;
	String adminPassword;
	public String userName1;
	public String userPassword1;
	public String userName2;
	public String userPassword2;
	public int selectOption;
	public long collegeCode;
	public int rollNo;
	public long getFeesPaid;
	public int attendancePercentage;
	public CollegeManagementApp()
	{
		
	}

	

	public CollegeManagementApp(String adminName, String adminPassword, String userName1, String userPassword1,
			String userName2, String userPassword2, int selectOption, long collegeCode, int rollNo, long getFeesPaid,
			int attendancePercentage) {
		super();
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.userName1 = userName1;
		this.userPassword1 = userPassword1;
		this.userName2 = userName2;
		this.userPassword2 = userPassword2;
		this.selectOption = selectOption;
		this.collegeCode = collegeCode;
		this.rollNo = rollNo;
		this.getFeesPaid = getFeesPaid;
		this.attendancePercentage = attendancePercentage;
	}



	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	public String getUserPassword1() {
		return userPassword1;
	}

	public void setUserPassword1(String userPassword1) {
		this.userPassword1 = userPassword1;
	}

	public String getUserName2() {
		return userName2;
	}

	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}

	public String getUserPassword2() {
		return userPassword2;
	}

	public void setUserPassword2(String userPassword2) {
		this.userPassword2 = userPassword2;
	}

	public int getSelectOption() {
		return selectOption;
	}

	public void setSelectOption(int selectOption) {
		this.selectOption = selectOption;
	}

	public long getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(long collegeCode) {
		this.collegeCode = collegeCode;
	}
	

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	public long getGetFeesPaid() {
		return getFeesPaid;
	}

	public void setGetFeesPaid(long getFeesPaid) {
		this.getFeesPaid = getFeesPaid;
	}
	

	public int getAttendancePercentage() {
		return attendancePercentage;
	}

	public void setAttendancePercentage(int attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}

	@Override
	public String toString() {
		return "CollegeManagementApp [adminName=" + adminName + ", adminPassword=" + adminPassword + ", userName1="
				+ userName1 + ", userPassword1=" + userPassword1 + ", userName2=" + userName2 + ", userPassword2="
				+ userPassword2 + ", selectOption=" + selectOption + ", collegeCode=" + collegeCode + ", rollNo="
				+ rollNo + ", getFeesPaid=" + getFeesPaid + ", attendancePercentage=" + attendancePercentage + "]";
	}
}
	
