package LinkedList;

public class ReverseLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static ListNode reverse(ListNode A, int size) {
        if(A == null) return null;
        ListNode curr = A;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;
        while(curr != null && count < size){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        ListNode temp = prev;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = curr;
        return prev;
    }
    public static ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode temp = A;
        ListNode x = A;
        int size = C - B + 1;
        int i = 1;
        while(temp.next != null  && i < B) {
            temp = temp.next;
            if(i < B - 1){
                x = x.next;
            }
            i++;
        }
        System.out.println(temp.val);
        if(temp.next == null) return null;
        ListNode node = temp;
        ListNode temp1 = reverse(node, size);
        temp = temp1;
        if(B == 1) return temp1;
        x.next = temp1;
        return A;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(97);
        root.next = new ListNode(63);
        root.next.next = new ListNode(89);
        root.next.next.next = new ListNode(34);
        root.next.next.next.next = new ListNode(82);
        root.next.next.next.next.next = new ListNode(95);
        root.next.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next.next = new ListNode(70);
        root.next.next.next.next.next.next.next.next = new ListNode(14);
        root.next.next.next.next.next.next.next.next.next = new ListNode(41);
        root.next.next.next.next.next.next.next.next.next.next = new ListNode(38);
        root.next.next.next.next.next.next.next.next.next.next.next = new ListNode(83);
        root.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(49);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(32);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(68);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(56);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(99);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(52);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(33);
        root.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(54);

        ListNode temp = root;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
        temp = reverseBetween(root, 1 ,15);
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}
