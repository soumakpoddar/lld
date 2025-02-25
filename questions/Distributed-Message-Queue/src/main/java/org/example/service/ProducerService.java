package org.example.service;

import org.example.dao.ProducerDao;
import org.example.entity.Producer;
import org.example.entity.Topic;
import org.example.entity.builder.ProducerBuilder;

import java.util.ArrayList;

public class ProducerService {
    private final ProducerBuilder producerBuilder;

    public ProducerService(ProducerBuilder producerBuilder) {
        this.producerBuilder = producerBuilder;
    }

    public Producer createProducer(String producerId) {
        Producer producer = producerBuilder
                .id(producerId)
                .topics(new ArrayList<>())
                .build();
        ProducerDao.producerMap.put(producerId, producer);
        return producer;
    }

    public boolean publishMessage(Producer producer, Topic topic, Object message) {
        if (!producer.getTopics().contains(topic.getTopicName())) {
            producer.getTopics().add(topic.getTopicName());
        }
        topic.getMessages().add(message);
        System.out.println("Message published successfully on topic: " + topic.getTopicName() + " by producer: " + producer.getId());
        return true;
    }
}
