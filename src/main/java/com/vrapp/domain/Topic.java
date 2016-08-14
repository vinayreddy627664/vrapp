package com.vrapp.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Topic implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int t_id;
	
	private String topicName;
	private Timestamp topicDuration;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="c_id")
	private Course course;

	public int getT_id() {
		return t_id;
	}

	public void setT_id(int t_id) {
		this.t_id = t_id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Timestamp getTopicDuration() {
		return topicDuration;
	}

	public void setTopicDuration(Timestamp topicDuration) {
		this.topicDuration = topicDuration;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + t_id;
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
		Topic other = (Topic) obj;
		if (t_id != other.t_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topic [t_id=" + t_id + ", topicName=" + topicName + ", topicDuration=" + topicDuration + "]";
	}
	
	
	

}
