/*
Reverse Link List II
Problem Description

Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output
Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation
Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1
 */
package LinkedList;

public class ReverseLinkedList2 {
    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
    public static ListNode reverse(ListNode A, int k){
        if(A == null) return null;
        ListNode next = null;
        ListNode prev =  null;
        ListNode curr = A;
        int count = 0;
        while(curr != null && count < k){
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
        int count = 1;
        if(B == 1) return reverse(temp, C - B + 1);
        while(count < (B - 1) && temp != null){
            temp = temp.next;
            count++;
        }
        ListNode node = temp.next;
        temp.next = null;
        temp.next = reverse(node, C - B + 1);
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
        ListNode tem = reverseBetween(root, 13, 15);
        while (tem != null){
            System.out.print(tem.val+ " ");
            tem = tem.next;
        }
        System.out.println();
    }
}
