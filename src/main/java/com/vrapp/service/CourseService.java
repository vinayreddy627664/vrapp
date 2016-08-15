package com.vrapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vrapp.domain.Course;
import com.vrapp.domain.User;
import com.vrapp.repositories.CourseRepository;
import com.vrapp.repositories.UserRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Course saveCourse(Course course) throws Exception{
    return courseRepository.save(course);
	}
	
	public Course getCourseById(int c_id) throws Exception{
		return courseRepository.findOne(c_id);
	}
	
	public void deleteCourse(int c_id) throws Exception{
		Course course = courseRepository.findOne(c_id);
		if(course == null){
			throw new Exception("Course not found");
		}
		courseRepository.delete(course);
	}
	
	public Course addUserToCourse(int c_id, int u_id)throws Exception{
		Course course = getCourseById(c_id);
		User user = userRepository.findOne(u_id);
		course.getRegisteredUsers().add(user);
		return courseRepository.save(course);
	}
	
	public Course removeUserFromCourse(int c_id, int u_id) throws Exception{
		Course course = getCourseById(c_id);
		User user = userRepository.findOne(u_id);
		course.getRegisteredUsers().remove(user);
		return courseRepository.save(course);
	}
	
	

}
