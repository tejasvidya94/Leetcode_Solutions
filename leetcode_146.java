import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class leetcode_146 {

    Node head;
    Node tail;
    int remaining;
    Map<Integer, Node> map;

    public leetcode_146(int capacity) {
        remaining = capacity;
        // head = null;
        // tail = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            if (curr == head) {
                return curr.value;
            }
            if (curr == tail) {
                tail = curr.prev;
                tail.next = null;
                curr.next = head;
                curr.prev = null;
                head.prev = curr;
                head = curr;
                return curr.value;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = head;
            head.prev = curr;
            curr.prev = null;
            head = curr;
            return curr.value;
        }
        return -1;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            curr.value = value;
            if (curr == head) {
                return;
            }
            if (curr == tail) {
                tail = curr.prev;
                tail.next = null;
                curr.next = head;
                head.prev = curr;
                head = curr;
                return;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = head;
            head.prev = curr;
            curr.prev = null;
            head = curr;
            return;
        }
        if (remaining == 0) {
            // remove last node
            map.remove(tail.key);
            if (tail.prev != null) {
                tail = tail.prev;
                tail.next = null;
            } else {
                head = tail = null;
            }
            remaining++;
        }
        // add new node at front
        Node newNode = new Node(key, value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        map.put(key, newNode);
        remaining--;
        return;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
