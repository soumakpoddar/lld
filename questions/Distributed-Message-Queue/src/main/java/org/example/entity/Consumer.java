package org.example.entity;

import org.example.entity.builder.ConsumerBuilder;

import java.util.List;
import java.util.Map;

public class Consumer {
    private String id;
    private List<String> topics;
    private Map<String, Integer> topicOffset;

    public Consumer(ConsumerBuilder builder) {
        this.id = builder.getId();
        this.topics = builder.getTopics();
        this.topicOffset = builder.getTopicOffset();
    }

    public String getId() {
        return id;
    }

    public List<String> getTopics() {
        return topics;
    }

    public Map<String, Integer> getTopicOffset() {
        return topicOffset;
    }

    public void commitMessage(String topic) {
        this.topicOffset.put(topic, this.topicOffset.getOrDefault(topic, 0) + 1);
    }
}
