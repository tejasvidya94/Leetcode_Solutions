public class leetcode_2130 {
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

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse half linked list
        ListNode curr = slow.next;
        ListNode prev = null;

        while (curr != null) {
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }

        fast = prev;
        slow = head;
        int maxSum = Integer.MIN_VALUE;
        while (fast != null) {
            int sum = slow.val + fast.val;
            if (sum > maxSum) {
                maxSum = sum;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return maxSum;

    }
}
