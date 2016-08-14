package com.vrapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vrapp.domain.Course;

public interface CourseRepository extends JpaRepository <Course, Integer>{

}
