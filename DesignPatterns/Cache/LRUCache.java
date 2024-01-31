package Cache;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    HashMap<Integer, ListNode> hm;
    ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
    }

    public int get(int key) {
        if(key == 1)
            System.out.println("start");
        if(!hm.containsKey(key))
            return -1;
        ListNode node = hm.get(key);
        if(node != head)
            markAsMostRecentlyUsed(node);
        if(tail == null)
            System.out.println("tail null for key: " + node.key + ", " + node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if(key == 1)
            System.out.println("start");
        if(hm.containsKey(key)) {
            ListNode node = hm.get(key);
            markAsMostRecentlyUsed(node);
            if(tail == null)
                System.out.println("tail null for key: " + node.key + ", " + node.val);
            node.val = value;
        }
        else {
            if(key == 12 && value == 17)
                System.out.println("here");
            if(hm.size() == capacity)
                removeLeastRecentlyUsed(key, value);
            ListNode node = new ListNode(key, value);
            if(tail == null)
                tail = node;
            else {
                head.prev = node;
                node.next = head;
            }
            head = node;
            hm.put(key, node);
            if(tail == null)
                System.out.println("tail null for key: " + key + ", " + value);
        }
    }

    private void markAsMostRecentlyUsed(ListNode node) {
        if(hm.size() == 1 || node.prev == null)
            return;
        if(node.prev != null)
            node.prev.next = node.next;
        if(node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
        head.prev = node;
        node.next = head;
        node.prev = null;
        head = node;
        if(tail == null)
            System.out.println("tail null for node: " + node);
    }

    private void removeLeastRecentlyUsed(int key, int val) {
        hm.remove(tail.key);
        if(tail.prev != null) {
            tail = tail.prev;
            tail.next = null;
        }
        if(tail == null)
            System.out.println("tail null for key: " + key + ", " + val);
    }
}


class ListNode {
    int key, val;
    ListNode prev;
    ListNode next;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}