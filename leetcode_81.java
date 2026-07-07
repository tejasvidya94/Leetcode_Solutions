public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class leetcode_81 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            while (right != null && right.val == left.val) {
                right = right.next;
            }
            left.next = right;
            left = left.next;
        }

        return head;

    }
}
