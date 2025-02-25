package org.example.service;

import org.example.dao.ConsumerDao;
import org.example.dao.TopicDao;
import org.example.entity.Consumer;
import org.example.entity.builder.ConsumerBuilder;
import org.example.entity.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConsumerService {
    private final ConsumerBuilder consumerBuilder;

    public ConsumerService(ConsumerBuilder consumerBuilder) {
        this.consumerBuilder = consumerBuilder;
    }


    public Consumer createConsumer(String consumerId) {
        Consumer consumer = consumerBuilder
                .id(consumerId)
                .topics(new ArrayList<>())
                .topicOffset(new HashMap<>())
                .build();
        ConsumerDao.consumerMap.put(consumerId, consumer);
        return consumer;
    }

    public void consumeMessage(Consumer consumer) {
        List<String> topics = consumer.getTopics();
        for(String topicId : topics) {
            int currentOffset = consumer.getTopicOffset().get(topicId);
            Topic topic = TopicDao.topicMap.get(topicId);
            if (currentOffset > topic.getMessages().size() - 1) {
                continue;
            }
            Object message = topic.getMessages().get(currentOffset);
            // commit the message...
            consumer.commitMessage(topicId);
            System.out.println("Consumer " + consumer.getId() + " consumed message: " + message.toString());
        }
    }

    public void subscribeToTopic(Consumer consumer, Topic topic) {
        consumer.getTopics().add(topic.getTopicName());
        consumer.getTopicOffset().put(topic.getTopicName(), 0);
        System.out.println("Consumer " + consumer.getId() + " subscribed to topic " + topic.getTopicName());
    }

    public  void pullMessage() {
        while (true) {
            for (Consumer consumer : ConsumerDao.consumerMap.values()) {
                consumeMessage(consumer);
            }
        }
    }
}