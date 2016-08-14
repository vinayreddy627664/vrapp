package com.vrapp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int c_id;

private String cName;
private String cDescription;
private String preReqs;

@Enumerated(EnumType.STRING)
private SkillLevel level;


@JsonIgnore
@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
@JoinTable(name = "course_user", joinColumns = @JoinColumn(name = "c_id", referencedColumnName = "c_id"), inverseJoinColumns = @JoinColumn(name = "u_id", referencedColumnName = "u_id"))
private List<User> registeredUsers = new ArrayList<>(); 

@JsonIgnore
@OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
private List<Topic> topics = new ArrayList<>();

private Timestamp createdAt;

private Timestamp modifiedAt;

public Course(){}

public Course(int c_id, String cName){
	this.c_id = c_id;
	this.cName = cName;
}

public int getC_id() {
	return c_id;
}

public void setC_id(int c_id) {
	this.c_id = c_id;
}

public String getcName() {
	return cName;
}

public void setcName(String cName) {
	this.cName = cName;
}

public String getcDescription() {
	return cDescription;
}

public void setcDescription(String cDescription) {
	this.cDescription = cDescription;
}

public String getPreReqs() {
	return preReqs;
}

public void setPreReqs(String preReqs) {
	this.preReqs = preReqs;
}

public SkillLevel getLevel() {
	return level;
}

public void setLevel(SkillLevel level) {
	this.level = level;
}

public List<User> getRegisteredUsers() {
	return registeredUsers;
}

public void setRegisteredUsers(List<User> registeredUsers) {
	this.registeredUsers = registeredUsers;
}

public List<Topic> getTopics() {
	return topics;
}

public void setTopics(List<Topic> topics) {
	this.topics = topics;
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



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + c_id;
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
	Course other = (Course) obj;
	if (c_id != other.c_id)
		return false;
	return true;
}

@Override
public String toString() {
	return "Course [c_id=" + c_id + ", cName=" + cName + ", cDescription=" + cDescription + ", preReqs=" + preReqs
			+ ", level=" + level + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
}



}
