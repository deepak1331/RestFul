package com.edu.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.springboot.dao.TopicDao;
import com.edu.springboot.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicDao dao;
	List<Topic> list;

	public TopicService() {
		System.out.println("Topic Service called...");
		dao = new TopicDao();
		list = dao.getTopicList();
	}

	public List<Topic> getAllTopic() {
		return list;
	}

	public Topic getTopicById(int id) {
		return list.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
	}

	public Topic getTopicByName(String topicName) {
		return list.stream().filter(t -> t.getName().equalsIgnoreCase(topicName.trim())).findFirst()
				.orElse(new Topic(0, "Not found", "Topic you have requested for, doesn't exist."));
	}

	public String addTopic(Topic topic) {
		int size=list.size();
		list.add(topic);
		return list.size()>size ? "Topic added successfully.":"Unable to add";
	}

	public String updateTopic(int id, Topic topic) {
		boolean found = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == topic.getId()) {
				list.set(i, topic);
				found=true;
				break;
			}
		}
		return found==true ?"Topic Updated successfully":"Element not found in the list";
	}

	public String deleteTopic(int id) {
		boolean isRemoved = list.removeIf(t-> t.getId()==id);
		return isRemoved==true ? "Element deleted successfully" : "Element not found";
	}
}
