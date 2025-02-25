package org.example;

import org.example.entity.Consumer;
import org.example.entity.Producer;
import org.example.entity.Topic;
import org.example.entity.builder.ConsumerBuilder;
import org.example.entity.builder.ProducerBuilder;
import org.example.entity.builder.TopicBuilder;
import org.example.service.ConsumerService;
import org.example.service.ProducerService;
import org.example.service.TopicService;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------START-----------------");

        TopicService topicService = new TopicService(new TopicBuilder());
        Topic topic1 = topicService.createTopic("topic1");
        Topic topic2 = topicService.createTopic("topic2");

        ProducerService producerService = new ProducerService(new ProducerBuilder());
        Producer producer1 = producerService.createProducer("producer1");
        Producer producer2 = producerService.createProducer("producer2");

        ConsumerService consumerService = new ConsumerService(new ConsumerBuilder());
        Consumer consumer1 = consumerService.createConsumer("consumer1");
        Consumer consumer2 = consumerService.createConsumer("consumer2");
        Consumer consumer3 = consumerService.createConsumer("consumer3");
        Consumer consumer4 = consumerService.createConsumer("consumer4");
        Consumer consumer5 = consumerService.createConsumer("consumer5");

        consumerService.subscribeToTopic(consumer1, topic1);
        consumerService.subscribeToTopic(consumer2, topic1);
        consumerService.subscribeToTopic(consumer3, topic1);
        consumerService.subscribeToTopic(consumer4, topic1);
        consumerService.subscribeToTopic(consumer5, topic1);
        consumerService.subscribeToTopic(consumer1, topic2);
        consumerService.subscribeToTopic(consumer3, topic2);
        consumerService.subscribeToTopic(consumer4, topic2);

        producerService.publishMessage(producer1, topic1, "message1");
        producerService.publishMessage(producer1, topic1, "message2");
        producerService.publishMessage(producer2, topic1, "message3");
        producerService.publishMessage(producer1, topic2, "message4");
        producerService.publishMessage(producer2, topic2, "message5");

        Runnable job = consumerService::pullMessage;
        Thread t1 = new Thread(job);
        t1.start();

        producerService.publishMessage(producer2, topic1, "hello soumak!!");
        producerService.publishMessage(producer1, topic2, "hello aman!!");

        System.out.println("-----------------END-----------------");
    }
}