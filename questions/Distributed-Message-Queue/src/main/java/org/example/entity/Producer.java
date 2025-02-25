package org.example.entity;

import org.example.entity.builder.ProducerBuilder;

import java.util.List;

public class Producer {
    private String id;
    private List<String> topics;

    public Producer(ProducerBuilder builder) {
        this.id = builder.getId();
        this.topics = builder.getTopics();
    }

    public String getId() {
        return id;
    }

    public List<String> getTopics() {
        return topics;
    }
}
