package com.nitinraj.hotelbooking.model;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="userprofile")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="authority")
	private String userRole;
	
	@Size(max=11)
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	
	@Column(name="date_of_birth")
	private String date_of_birth;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="country")
	private String country;
	
	@Column(name="pin_code")
	private String pin_code;
	
	@Lob
	@Column(name="userImage")
	private byte[] userImage;
	

	public UserProfile() {
		super();
		
	}

	public UserProfile(String userRole, @Size(max = 11) String phoneNumber, String date_of_birth, String gender,
			String address1, String address2, String city, String state, String country, String pin_code,
			byte[] userImage) {
		super();
		this.userRole = userRole;
		this.phoneNumber = phoneNumber;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pin_code = pin_code;
		this.userImage = userImage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setUserImage(byte[] filename) {
		this.userImage = filename;
	}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userRole=" + userRole + ", phoneNumber=" + phoneNumber + ", date_of_birth="
				+ date_of_birth + ", gender=" + gender + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", country=" + country + ", pin_code=" + pin_code + ", userImage="
				+ userImage + "]";
	}


	
	
	
	
	
	
	
}
