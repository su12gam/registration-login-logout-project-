package com.servlet.model;

public class Student {

	private int userId;
	private String userName;
	private String password;
	private String address;
	private String emailId;
	private String contactNo;

	public Student(int userId, String userName, String password, String address, String emailId, String contactNo) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.emailId = emailId;
		this.contactNo = contactNo;
	}

	public Student() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Student [userId=" + userId + ", userName=" + userName + ", password=" + password + ", address="
				+ address + ", emailId=" + emailId + ", contactNo=" + contactNo + "]";
	}

}
