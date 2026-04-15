class Solution {
    public void recursion(Node head){
        //through recrusion flattern next level
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
                recursion(curr.child);
                Node next = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                while(curr.next != null){
                    curr= curr.next;
                } 
                curr.next = next;
                if(next!= null) {
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return;
    }

    public Node flatten(Node head) {
        if(head == null ){
            return null;
        }
        recursion(head);
        return head;
    }
}