package com.edu.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.springboot.model.Topic;
import com.edu.springboot.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService service;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		System.out.println("Get Topic Controller called...");
		return service.getAllTopic();
	}

	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopicsById(@PathVariable String id) {
		System.out.println("Get Topic Controller called...");
		return service.getTopic(id);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic) {
		service.addTopic(topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public void putTopic(@RequestBody Topic topic, @PathVariable String id) {
		 service.updateTopic(id, topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id) {
		 service.deleteTopic(id);
	}
}
