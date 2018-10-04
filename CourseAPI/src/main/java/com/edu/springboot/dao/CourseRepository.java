package com.edu.springboot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.springboot.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByName(String name);
	public List<Course> findByDescription(String description);
	public List<Course> findByTopicId(String topicId);
}
