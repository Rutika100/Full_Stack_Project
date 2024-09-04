package com.model;

import java.util.List;

public class Recharge {

	private int regNo;
	private String mobNo;
	private String ser;
	private Float ramt;
	public Recharge(int regNo, String mobNo, String ser, Float ramt) {
		super();
		this.regNo = regNo;
		this.mobNo = mobNo;
		this.ser = ser;
		this.ramt = ramt;
	}
	public int getRegNo() {
		return regNo;
	}
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getSer() {
		return ser;
	}
	public void setSer(String ser) {
		this.ser = ser;
	}
	public Float getRamt() {
		return ramt;
	}
	public void setRamt(Float ramt) {
		this.ramt = ramt;
	}
	
}
