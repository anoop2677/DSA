package LinkedList;

public class ReorderList {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
    }
    public static ListNode reverse(ListNode A) {
        if(A == null) return null;
        ListNode curr = A;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        A = prev;
        return A;
    }
    public static ListNode reorderList(ListNode A) {
        int i = 0;
        ListNode temp = A;
        ListNode temp1 = A.next;
        while(temp1 != null && temp1.next != null){
            temp = temp.next;
            temp1 = temp1.next.next;
        }
        ListNode node = A;
        ListNode node1 = temp.next;
        temp.next = null;
        node1 = reverse(node1);
        ListNode temp2 = new ListNode(0);
        ListNode curr = temp2;
        while (node != null || node1 != null){
            if (node != null) {
                curr.next = node;
                curr = curr.next;
                node = node.next;
            }
            if (node1 != null) {
                curr.next = node1;
                curr = curr.next;
                node1 = node1.next;
            }
        }
        temp2 = temp2.next;
        return temp2;
    }

    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        ListNode temp = reorderList(n);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}