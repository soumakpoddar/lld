package org.example.dao;

import org.example.entity.Consumer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConsumerDao {
    public static Map<String, Consumer> consumerMap = new ConcurrentHashMap<>();
}