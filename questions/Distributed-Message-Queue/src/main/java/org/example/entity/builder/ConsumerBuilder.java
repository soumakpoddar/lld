package org.example.entity.builder;

import org.example.entity.Consumer;

import java.util.List;
import java.util.Map;

public class ConsumerBuilder extends BaseBuilder<Consumer> {
    private String id;
    private List<String> topics;
    private Map<String, Integer> topicOffset;

    public String getId() {
        return id;
    }

    public ConsumerBuilder id(String id) {
        this.id = id;
        return this;
    }

    public List<String> getTopics() {
        return topics;
    }

    public ConsumerBuilder topics(List<String> topics) {
        this.topics = topics;
        return this;
    }

    public Map<String, Integer> getTopicOffset() {
        return topicOffset;
    }

    public ConsumerBuilder topicOffset(Map<String, Integer> topicOffset) {
        this.topicOffset = topicOffset;
        return this;
    }

    @Override
    public Consumer build() {
        return new Consumer(this);
    }
}
