package com.vrapp.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int t_id;

	@NotBlank(message = "please enter a topic name")
	private String topicName;
	private LocalDateTime topicDuration;
	private LocalDateTime createdAt;

	@Version
	private LocalDateTime modifiedAt;

	@PrePersist
	protected void onCreate() {
		this.setCreatedAt(LocalDateTime.now());
		this.modifiedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		this.modifiedAt = LocalDateTime.now();
	}

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "c_id")
	private Course course;
	
	public Topic(){}

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

	public LocalDateTime getTopicDuration() {
		return topicDuration;
	}

	public void setTopicDuration(LocalDateTime topicDuration) {
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
		return "Topic [t_id=" + t_id + ", topicName=" + topicName + ", topicDuration=" + topicDuration + ", createdAt="
				+ createdAt + ", modifiedAt=" + modifiedAt + ", course=" + course + "]";
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

	public Topic(int t_id, String topicName, LocalDateTime topicDuration, LocalDateTime createdAt,
			LocalDateTime modifiedAt, Course course) {
		this.t_id = t_id;
		this.topicName = topicName;
		this.topicDuration = topicDuration;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.course = course;
	}

}
