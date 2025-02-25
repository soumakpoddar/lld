package org.example.dao;

import org.example.entity.Producer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProducerDao {
    public static Map<String, Producer> producerMap = new ConcurrentHashMap<>();
}
