package com.model;
public class Register {
	private int regNo;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private float amt;
	public Register() {
		
	}
	public Register(int regNo, String fname, String lname, String email, String pass, float amt) {
		super();
		this.regNo = regNo;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.amt = amt;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	
}
