package com.vrapp.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int u_id;

	@NotBlank(message = "userName should not be null")
	@Email(message = "expecting Email for userName")
	private String userName;
	@NotBlank(message = "password field cannot be empty")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})", message = "Password should have atleast 1 digit, 1 lowercase, 1 uppercase and with a min length of 6 and max length of 10")
	private String password;
	@NotBlank(message = "first Name should not be null")
	private String fName;
	@NotBlank(message = "last Name should not be null")
	private String lName;
	private String mobile;
	private LocalDateTime createdAt;
	@Version
	private LocalDateTime modifiedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
		this.modifiedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.modifiedAt = LocalDateTime.now();
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "registeredUsers")
	private List<Course> courses;
	
	public User(){}

	public User(int u_id, String userName, String password, String fName, String lName, String mobile,
			LocalDateTime createdAt, LocalDateTime modifiedAt, List<Course> courses) {
		this.u_id = u_id;
		this.userName = userName;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.mobile = mobile;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.courses = courses;
	}

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(LocalDateTime modifiedAt) {
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
		return "User [u_id=" + u_id + ", userName=" + userName + ", password=" + password + ", fName=" + fName
				+ ", lName=" + lName + ", mobile=" + mobile + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt
				+ "]";
	}

}
