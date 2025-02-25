package org.example.entity.builder;

import org.example.entity.Producer;
import org.example.entity.Topic;

import java.util.List;

public class ProducerBuilder extends BaseBuilder<Producer> {
    private String id;
    private List<String> topics;

    public String getId() {
        return id;
    }

    public ProducerBuilder id(String id) {
        this.id = id;
        return this;
    }

    public List<String> getTopics() {
        return topics;
    }

    public ProducerBuilder topics(List<String> topics) {
        this.topics = topics;
        return this;
    }

    @Override
    public Producer build() {
        return new Producer(this);
    }
}
