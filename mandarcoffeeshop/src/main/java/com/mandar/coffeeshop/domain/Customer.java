package com.mandar.coffeeshop.domain;


import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue

    private Long idc;

    private String fname;

    private String lname;

	
	public Long getIdc() {
		return idc;
	}

	public void setIdc(Long idc) {
		this.idc = idc;
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
}
