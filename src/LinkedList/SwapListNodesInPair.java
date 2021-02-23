package LinkedList;

public class SwapListNodesInPair {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode A, int B) {
        if(A == null || A.next == null) return  A;
        ListNode next = null;
        ListNode prev = null;
        ListNode curr = A;
        int count = 0;
        while(curr != null && count < B){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if(next != null){
            A.next = reverseList(next, 2);
        }
        return prev;
    }
    public ListNode swapPairs(ListNode A) {
        return reverseList(A, 2);
    }
}
