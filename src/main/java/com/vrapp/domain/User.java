package com.vrapp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int u_id;
private String userName;
private String password;
private String fName;
private String lName;
private String mobile;
private Timestamp createdAt;
private Timestamp modifiedAt;

@JsonIgnore
@ManyToMany(mappedBy = "registeredUsers")
private List<Course> courses;

public int getU_id() {
	return u_id;
}

public void setU_id(int u_id) {
	this.u_id = u_id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public Timestamp getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Timestamp createdAt) {
	this.createdAt = createdAt;
}

public Timestamp getModifiedAt() {
	return modifiedAt;
}

public void setModifiedAt(Timestamp modifiedAt) {
	this.modifiedAt = modifiedAt;
}

public List<Course> getCourses() {
	return courses;
}

public void setCourses(List<Course> courses) {
	this.courses = courses;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + u_id;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (u_id != other.u_id)
		return false;
	return true;
}

@Override
public String toString() {
	return "User [u_id=" + u_id + ", userName=" + userName + ", password=" + password + ", fName=" + fName + ", lName="
			+ lName + ", mobile=" + mobile + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
}


}
