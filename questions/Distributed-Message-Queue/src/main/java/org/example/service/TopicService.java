package org.example.service;

import org.example.dao.TopicDao;
import org.example.entity.Topic;
import org.example.entity.builder.TopicBuilder;

import java.util.ArrayList;

public class TopicService {
    private final TopicBuilder topicBuilder;

    public TopicService(TopicBuilder topicBuilder) {
        this.topicBuilder = topicBuilder;
    }

    public Topic createTopic(String topicName) {
        Topic topic = topicBuilder
                .topicName(topicName)
                .messages(new ArrayList<>())
                .build();
        TopicDao.topicMap.put(topicName, topic);
        return topic;
    }
}
