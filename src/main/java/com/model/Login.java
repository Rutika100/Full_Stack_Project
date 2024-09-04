package com.model;

import java.util.List;

public class Login {
	private int regno;
 private String lemail;
 private String lpass;
 private List<Register> rls;
 

public Login() {
	 
 }


public Login(int regno, String lemail, String lpass) {
	super();
	this.regno = regno;
	this.lemail = lemail;
	this.lpass = lpass;

}


public int getRegno() {
	return regno;
}


public void setRegno(int regno) {
	this.regno = regno;
}


public String getLemail() {
	return lemail;
}


public void setLemail(String lemail) {
	this.lemail = lemail;
}


public String getLpass() {
	return lpass;
}


public void setLpass(String lpass) {
	this.lpass = lpass;
}


public List<Register> getRls() {
	return rls;
}


public void setRls(List<Register> rls) {
	this.rls = rls;
}

 
}
