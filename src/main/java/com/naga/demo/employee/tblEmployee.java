package com.naga.demo.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblEmployee1")
//need to research about camel-case table names in mysql DB
public class tblEmployee {

	@Id
	private int Id;
	
	
	private String FName;
	private String MName;
	private String LName;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the fName
	 */
	public String getFName() {
		return FName;
	}
	/**
	 * @param fName the fName to set
	 */
	public void setFName(String fName) {
		FName = fName;
	}
	/**
	 * @return the mName
	 */
	public String getMName() {
		return MName;
	}
	/**
	 * @param mName the mName to set
	 */
	public void setMName(String mName) {
		MName = mName;
	}
	/**
	 * @return the lName
	 */
	public String getLName() {
		return LName;
	}
	/**
	 * @param lName the lName to set
	 */
	public void setLName(String lName) {
		LName = lName;
	}
	
	
	
	
}
