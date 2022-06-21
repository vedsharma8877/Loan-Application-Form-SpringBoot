package com.example.LoanApplication.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "loan_borrower_detail")
public class LoanApplicationModel {
	  @Id
	  private String id;
	  private Integer lamount;
	  private String lpurpose;
	  private String fname;
	  private String mname;
	  private String lname;
	  private String dob;
	  private String email;
	  private String hphone;
	  private String mphone;
	  private String ssn;
	  private String sa1;
	  private String sa2;
	  private String city;
	  private String statess;
	  private String zip;
	  private String rd;
	  private String rt;
	  private String status;
	  public LoanApplicationModel() {
		  
	  }
      public LoanApplicationModel(Integer lamount,String lpurpose, String fname,
    		  String mname, String lname,String dob,String email, String hphone, String mphone,
    		  String ssn, String sa1, String sa2, String city, String statess, String zip, String rd,
    		  String rt,String status) {
		  this.lamount = lamount;
		  this.lpurpose = lpurpose;
		  this.fname = fname;
		  this.mname = mname;
		  this.lname = lname;
		  this.dob = dob;
		  this.email = email;
		  this.hphone = hphone;
		  this.mphone = mphone;
		  this.ssn = ssn;
		  this.sa1 = sa1;
		  this.sa2 = sa2;
		  this.city= city;
		  this.statess = statess;
		  this.zip = zip;
		  this.rd = rd;
		  this.rt = rt;
		  this.status = status;
	  }
	public String getId() {
		return id;
	}
	public Integer getLamount() {
		return lamount;
	}
	public void setLamount(Integer lamount) {
		this.lamount = lamount;
	}
	public String getLpurpose() {
		return lpurpose;
	}
	public void setLpurpose(String lpurpose) {
		this.lpurpose = lpurpose;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSa1() {
		return sa1;
	}
	public void setSa1(String sa1) {
		this.sa1 = sa1;
	}
	public String getSa2() {
		return sa2;
	}
	public void setSa2(String sa2) {
		this.sa2 = sa2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatess() {
		return statess;
	}
	public void setStatess(String statess) {
		this.statess = statess;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getRd() {
		return rd;
	}
	public void setRd(String rd) {
		this.rd = rd;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}  