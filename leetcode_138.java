import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Node newCurr = null;
        Node newHead = null;
        Map<Node, Node> map = new HashMap<>();
        // copy values of real list to duplicate list.
        while (curr != null) {
            Node newNode = new Node(curr.val);
            if (newCurr == null) {
                newHead = newNode;
                newCurr = newHead;
            } else {
                newCurr.next = newNode;
                newCurr = newCurr.next;
            }
            map.put(curr, newCurr);
            curr = curr.next;
        }

        // copy random pointer.
        curr = head;
        newCurr = newHead;
        while (curr != null) {
            if (curr.random != null) {
                newCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
}