package org.example.dao;

import org.example.entity.Topic;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TopicDao {
    public static Map<String, Topic> topicMap = new ConcurrentHashMap<>();
}
