package com.edu.springboot.controller;

import java.util.List;

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
	public Topic getTopicsById(@PathVariable int id) {
		System.out.println("Get Topic Controller called...");
		return service.getTopicById(id);
	}

	@RequestMapping("/topics/name/{topicName}")
	public Topic getTopicsById(@PathVariable String topicName) {
		System.out.println("Get Topic Controller called...");
		return service.getTopicByName(topicName);
	}

	@RequestMapping(value = "/topics", method = RequestMethod.POST)
	public String addTopic(@RequestBody Topic topic) {
		return service.addTopic(topic);
	}

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
	public String putTopic(@RequestBody Topic topic, @PathVariable int id) {
		return service.updateTopic(id, topic);
	}
	

	@RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
	public String deleteTopic(@PathVariable int id) {
		return service.deleteTopic(id);
	}
}
