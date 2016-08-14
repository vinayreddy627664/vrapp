package com.vrapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vrapp.service.CourseService;

@RestController
@RequestMapping(value="course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	

}
