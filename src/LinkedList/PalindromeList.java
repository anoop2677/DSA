package LinkedList;

public class PalindromeList {

      static class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
      }
    static ListNode reverse(ListNode A){
          if(A == null) return null;
          ListNode curr =A;
          ListNode next = null;
          ListNode prev = null;
          while (curr != null){
              next = curr.next;
              curr.next = prev;
              prev = curr;
              curr = next;
          }
          A = prev;
          return A;
    }
    public static int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        if(A.next == null) return 1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println();
        ListNode node = slow;
        slow = null;
        node = reverse(node);
        ListNode temp = A;
        while (temp != null && node != null){
            if(temp.val == node.val){
                temp = temp.next;
                node = node.next;
            }
            else {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(3);
        root.next.next = new ListNode(2);
//        root.next.next.next = new ListNode(1);
        System.out.println(lPalin(root));
    }
}
