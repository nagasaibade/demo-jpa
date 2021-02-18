package com.naga.demo.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblEmployee")
public class tblEmployee {

	@Id
	private int id;
	
	private String LoginId;
	
	private String FName;
	private String MName;
	private String LName;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return LoginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		LoginId = loginId;
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
	@Override
	public String toString() {
		return "tblEmployee [id=" + id + ", LoginId=" + LoginId + ", FName=" + FName + ", MName=" + MName + ", LName="
				+ LName + ", getId()=" + getId() + ", getLoginId()=" + getLoginId() + ", getFName()=" + getFName()
				+ ", getMName()=" + getMName() + ", getLName()=" + getLName() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}
