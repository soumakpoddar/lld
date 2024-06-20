package org.example;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> mp  = new MyHashMap<>(10);
        mp.put("a", 1);
        mp.put("b", 2);
        mp.put("c", 3);
        System.out.println(mp.get("a"));
        System.out.println(mp.size());
    }
}