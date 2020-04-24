package lk.avix.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/lfu-cache/
 */
class Q460_LfuCache {

    private Map<Integer, Node> cache;
    private PriorityQueue<Node> queue;
    private int capacity;
    private static int timer;

    public Q460_LfuCache(int capacity) {
        this.cache = new HashMap<>();
        this.queue = new PriorityQueue<>((a, b) -> (a.count == b.count ? (a.timer - b.timer) : (a.count - b.count)));
        this.capacity = capacity;
        timer = 0;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(new Node(node.key, node.val, node.count + 1, timer++));
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            add(new Node(key, value, node.count + 1, timer++));
        } else {
            if (capacity != 0) {
                if (cache.size() == capacity) {
                    remove(Objects.requireNonNull(queue.peek()));
                }
                add(new Node(key, value, 1, timer++));
            }
        }
    }

    private void add(Node node) {
        cache.put(node.key, node);
        queue.offer(node);
    }

    private void remove(Node node) {
        cache.remove(node.key);
        queue.remove(node);
    }

    static class Node {

        int key;
        int val;
        int count;
        int timer;

        public Node(int k, int v, int c, int t) {
            this.key = k;
            this.val = v;
            this.count = c;
            this.timer = t;
        }
    }
}
