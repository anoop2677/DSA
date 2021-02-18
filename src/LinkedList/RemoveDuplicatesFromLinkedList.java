package LinkedList;

public class RemoveDuplicatesFromLinkedList {
    static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public static ListNode deleteDuplicates(ListNode A) {
        ListNode temp = A;
        if(temp.next == null) return A;
        while(temp != null){
            if(temp.next != null && temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(1);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(1);
        root.next.next.next.next = new ListNode(1);
        root.next.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next.next.next.next.next.next = new ListNode(3);
        root.next.next.next.next.next.next.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode temp = root;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
        temp = deleteDuplicates(root);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
