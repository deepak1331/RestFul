package com.edu.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springboot.dao.TopicRepository;
import com.edu.springboot.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	List<Topic> list = new ArrayList<Topic>();

	public List<Topic> getAllTopic() {
		topicRepository.findAll().forEach(list::add);
		return list;
	}

	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);

	}

	public Topic getTopicByName(String topicName) {
		if (list.size() == 0)
			getAllTopic();
		return list.stream().filter(p -> p.getName().equalsIgnoreCase(topicName)).findFirst().orElse(null);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
