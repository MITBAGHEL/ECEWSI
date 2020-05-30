package com.ecewsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "register_master")
public class RegisterVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "registerId")
	private int registerId;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "mobileNumber")
	private String mobileNumber;
	
	@Column(name="address")
	private String address;

	@Column(name="profileEditedOrNot")
	private boolean profileEditedOrNot=false;

	@ManyToOne
	@JoinColumn(name = "loginId")
	private LoginVO loginVO;

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LoginVO getLoginVO() {
		return loginVO;
	}

	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isProfileEditedOrNot() {
		return profileEditedOrNot;
	}

	public void setProfileEditedOrNot(boolean profileEditedOrNot) {
		this.profileEditedOrNot = profileEditedOrNot;
	}

}
