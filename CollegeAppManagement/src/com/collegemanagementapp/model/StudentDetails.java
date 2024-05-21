package com.collegemanagementapp.model;

public class StudentDetails {
	public int rollNumber;
	public String studentName;
	public String course;
	public String department;
	public String yearOfPursuing;
	public int attendancePercentage;
	public long remainingCollegeFees,remainingBookFees;
	public int remainingExamFees;
	public int placementPercentage;
	public int collegeRanking;
	public int companies;
	public int year;
	public StudentDetails()
	{
		
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public static  void setRollNumber(int rollNumber) {
		rollNumber = rollNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYearOfPursuing() {
		return yearOfPursuing;
	}
	public void setYearOfPursuing(String yearOfPursuing2) {
		this.yearOfPursuing = yearOfPursuing2;
	}
	public int getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(int attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	public long getRemainingCollegeFees() {
		return remainingCollegeFees;
	}
	public void setRemainingCollegeFees(long remainingCollegeFees) {
		this.remainingCollegeFees = remainingCollegeFees;
	}
	public long getRemainingBookFees() {
		return remainingBookFees;
	}
	public void setRemainingBookFees(long remainingBookFees) {
		this.remainingBookFees = remainingBookFees;
	}
	public int getRemainingExamFees() {
		return remainingExamFees;
	}
	public void setRemainingExamFees(int remainingExamFees) {
		this.remainingExamFees = remainingExamFees;
	}
	public int getPlacementPercentage() {
		return placementPercentage;
	}
	public void setPlacementPercentage(int placementPercentage) {
		this.placementPercentage = placementPercentage;
	}
	public int getCollegeRanking() {
		return collegeRanking;
	}
	public void setCollegeRanking(int collegeRanking) {
		this.collegeRanking = collegeRanking;
	}
	public int getCompanies() {
		return companies;
	}
	public void setCompanies(int companies) {
		this.companies = companies;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public StudentDetails(int rollNumber, String studentName, String course, String department, String yearOfPursuing,
			int attendancePercentage, long remainingCollegeFees, long remainingBookFees, int remainingExamFees,
			int placementPercentage, int collegeRanking, int companies, int year) {
		super();
		this.rollNumber = rollNumber;
		this.studentName = studentName;
		this.course = course;
		this.department = department;
		this.yearOfPursuing = yearOfPursuing;
		this.attendancePercentage = attendancePercentage;
		this.remainingCollegeFees = remainingCollegeFees;
		this.remainingBookFees = remainingBookFees;
		this.remainingExamFees = remainingExamFees;
		this.placementPercentage = placementPercentage;
		this.collegeRanking = collegeRanking;
		this.companies = companies;
		this.year = year;
	}
	@Override
	public String toString() {
		return "StudentDetails [rollNumber=" + rollNumber + ", studentName=" + studentName + ", course=" + course
				+ ", department=" + department + ", yearOfPursuing=" + yearOfPursuing + ", attendancePercentage="
				+ attendancePercentage + ", remainingCollegeFees=" + remainingCollegeFees + ", remainingBookFees="
				+ remainingBookFees + ", remainingExamFees=" + remainingExamFees + ", placementPercentage="
				+ placementPercentage + ", collegeRanking=" + collegeRanking + ", companies=" + companies + ", year="
				+ year + "]";
	}
	
	
}
