package com.fidelity.smallChange.business;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Profile {
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String email;
	private String phone;
	private String username;
	private String password;
	private int risk;
	
	final String emailRegex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
    Pattern emailPattern = Pattern.compile(emailRegex);
    
	
	public Profile() {
		super();
	}

	public Profile(String firstName, String lastName, LocalDate dob, String email, String phone, String username,
				String password, int risk) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.dob = dob;
			this.email = email;
			this.phone = phone;
			this.username = username;
			this.password = password;
			this.risk = risk;
		}

//	public Profile(String fname, String lname, LocalDate date, String uname, String password, String email, String phone, int risk) {
//		
//		if(fname.equals("") || fname.equals(null)) {
//			throw new IllegalArgumentException("First Name cannot be empty or null.");
//		}
//		else {
//			this.firstName = fname;
//		}
//		
//		if(lname.equals("") || lname.equals(null)) {
//			throw new IllegalArgumentException("Last Name cannot be empty or null.");
//		}
//		else {
//			this.lastName = lname;
//		}
//		
//		if(uname.equals("") || uname.equals(null)) {
//			throw new IllegalArgumentException("Username cannot be empty or null.");
//		}
//		else {
//			this.username = uname;
//		}
//		
//		if(password.equals("") || password.equals(null)) {
//			throw new IllegalArgumentException("Password cannot be empty or null.");
//		}
//		else {
//			this.password = password;
//		}
//		
//		if(email.equals("") || email.equals(null)) {
//			throw new IllegalArgumentException("Email cannot be empty or null.");
//		}
//		else {
//			Matcher matcher = emailPattern.matcher(email);
//		    if (!matcher.matches()) {
//				throw new IllegalArgumentException("Email is invalid.");
//		    }
//			this.email = email;
//		}
//		
//		if(phone.substring(phone.indexOf('-') + 1, phone.length()).length() < 10 || phone.substring(phone.indexOf('-') + 1, phone.length()).length() > 10) {
//			throw new IllegalArgumentException("Phone number must be 10 digits.");
//		}
//		else {
//			this.phone = phone;
//		}
//		
//		if(date == null) {
//			throw new IllegalArgumentException("Date cannot be null.");
//		}
//		else {
//			this.dob = date;
//		}
//		
//		if(risk >= 1 && risk <= 5) {
//			this.risk = risk;
//		}
//		else {
//			throw new IllegalArgumentException("Risk must be between 1 & 5.");
//		}
//	}
	
	public boolean signup(String fname, String lname, LocalDate date, String uname, String email, String phone, int risk) {
		System.out.println("First Name : " + fname);
		System.out.println("Last Name : " + lname);
		System.out.println("UserName : " + uname);
		System.out.println("DOB : " + date);
		System.out.println("E-Mail : " + email);
		System.out.println("Phone : " + phone);
		System.out.println("Risk : " + risk);
		return true;
	}
	

	public boolean display(String fname, String lname, LocalDate date, String uname, String email, String phone, int risk) {
		System.out.println("First Name : " + fname);
		System.out.println("Last Name : " + lname);
		System.out.println("UserName : " + uname);
		System.out.println("DOB : " + date);
		System.out.println("E-Mail : " + email);
		System.out.println("Phone : " + phone);
		System.out.println("Risk : " + risk);
		return true;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPhone() {
		return phone;
	}
	public int getRisk() {
		return risk;
	}
	public String getPassword() {
		return password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	
}
