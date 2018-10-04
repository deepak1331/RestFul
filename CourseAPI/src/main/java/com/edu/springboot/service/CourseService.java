package com.edu.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springboot.dao.CourseRepository;
import com.edu.springboot.model.Course;
import com.edu.springboot.model.Topic;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	List<Course> list = new ArrayList<Course>();

	public List<Course> getAllCourse(String topicId) {
		return courseRepository.findByTopicId(topicId);
//		return list;
	}

	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);

	}

	public List<Course> getCourseByName(String courseName) {
//		return list.stream().filter(p -> p.getName().equalsIgnoreCase(courseName)).findFirst().orElse(null);
		return courseRepository.findByName(courseName);
	}

	public void addCourse(String topicId, Course course) {
		course.setTopic(new Topic(topicId,"",""));
		courseRepository.save(course);
	}

	public void updateCourse(String topicId, Course course) {
		course.setTopic(new Topic(topicId,"",""));
		courseRepository.save(course);
	}

	public void deleteCourse(String courseId) {
		courseRepository.deleteById(courseId);
	}
}
