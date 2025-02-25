package org.example.entity;

import org.example.entity.builder.ProducerBuilder;
import org.example.entity.builder.TopicBuilder;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String topicName;
    private List<Object> messages;

    public String getTopicName() {
        return topicName;
    }

    public List<Object> getMessages() {
        return messages;
    }

    public Topic(TopicBuilder builder) {
        this.topicName = builder.getTopicName();
        this.messages = builder.getMessages();
    }
}
