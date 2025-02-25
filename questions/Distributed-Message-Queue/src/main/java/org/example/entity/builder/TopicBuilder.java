package org.example.entity.builder;

import org.example.entity.Topic;

import java.util.List;

public class TopicBuilder  extends BaseBuilder<Topic> {
    private String topicName;
    private List<Object> messages;

    public TopicBuilder topicName(String topicName) {
        this.topicName = topicName;
        return this;
    }

    public TopicBuilder messages(List<Object> messages) {
        this.messages = messages;
        return this;
    }

    public String getTopicName() {
        return topicName;
    }

    public List<Object> getMessages() {
        return messages;
    }

    @Override
    public Topic build() {
        return new Topic(this);
    }
}