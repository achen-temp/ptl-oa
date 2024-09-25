package com.ptl.exercise.caspex.glider;

import java.util.*;

/**
 * SOLUTION WILL PASS ALL TESTS, if you fail, its your problem, you figure it out.
 */

//define node for LRU cache to use.
//LRU Cache is implemented by doubly linked list
class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache{
    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }else{
            if(map.size() == capacity){
                Node node = tail.prev;
                deleteNode(node);
                map.remove(node.key);
            }
            Node temp = new Node(key, value);
            map.put(key, temp);
            addToHead(temp);
        }
    }
}

public class Outcome_LRUCache {

    //method definition given, but logic you need to implement
    //N sometimes is appeared as 'capacity'
    public static List<Integer> solve(int N, List<String> ar){
        //write your implementation here
        List<Integer> result = new ArrayList<>();
        if(ar == null || ar.size() == 0 || N <= -1){
            result.add(-1);
            return result;
        }

        LRUCache lruCache = new LRUCache(N);
        for(String input : ar){
            if(input.contains("GET")){
                String[] entries = input.split(",");
                int key = Integer.valueOf(entries[1]);
                int value = lruCache.get(key);
                result.add(value);
            }
            if(input.contains("PUT")){
                String[] entries = input.split(",");
                int key = Integer.valueOf(entries[1]);
                int value = Integer.valueOf(entries[2]);
                lruCache.put(key, value);
            }
        }
        return result;
    }


    //no need to do this, just my test code
    public static void main(String[] args) {
        Outcome_LRUCache outcome = new Outcome_LRUCache();
        List<String> ar1 = Arrays.asList();
        int capacity1 = 2;
        System.out.println(outcome.solve(capacity1, ar1)); //-1,-1,150

        List<String> ar2 = Arrays.asList("PUT,11,25", "PUT,22,50", "PUT,11,75","GET,11", "GET,22");
        int capacity2 = 3;
        System.out.println(outcome.solve(capacity2, ar2)); //75,50
    }
}
