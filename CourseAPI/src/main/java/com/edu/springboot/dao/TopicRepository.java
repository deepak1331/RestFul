package com.edu.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edu.springboot.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String> {
	
}
