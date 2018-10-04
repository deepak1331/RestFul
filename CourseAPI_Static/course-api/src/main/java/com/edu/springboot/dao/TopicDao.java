package com.edu.springboot.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.springboot.model.Topic;

@Repository
public class TopicDao {

	private List<Topic> topicList;

	public TopicDao() {

		System.out.println("Topic Dao called...");
		topicList = new ArrayList<Topic>();
		topicList.add(new Topic(1, "Spring Framework", "Spring FrameWork Desc"));
		topicList.add(new Topic(2, "J2EE", "J2EE Description"));
		topicList.add(new Topic(3, "Oracle", "Oracle Desc"));
		topicList.add(new Topic(4, "Linux Redhat", "Linux Redhat Desc"));
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

}
