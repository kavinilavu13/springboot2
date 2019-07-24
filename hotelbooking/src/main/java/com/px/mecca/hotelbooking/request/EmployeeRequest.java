package com.px.mecca.hotelbooking.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
public class EmployeeRequest {
private int EmployeeId;

@NotNull
@NotEmpty
@Size(min = 1, max = 5, message="Name should have atleast 2 characters")
private String Name;

@NotNull(message="Please provide Emailid")
private String Emailid;

@NotNull(message="Please provide Password")
private String Password;

@Size(min = 1, max = 10, message="phonenumber should have a 10 numberd")
@NotNull(message="Please provide Phonenumber")
private String Phonenumber;

private AddressRequest address;

public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getEmailid() {
	return Emailid;
}
public void setEmailid(String emailid) {
	Emailid = emailid;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getPhonenumber() {
	return Phonenumber;
}
public void setPhonenumber(String phonenumber) {
	Phonenumber = phonenumber;
}
public AddressRequest getAddress() {
	return address;
}
public void setAddress(AddressRequest address) {
	this.address = address;
}

}
