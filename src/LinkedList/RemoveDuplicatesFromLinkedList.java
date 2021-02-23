/*
Remove Duplicates from Sorted List
Problem Description

Given a sorted linked list, delete all duplicates such that each element appear only once.



Problem Constraints
0 <= length of linked list <= 106



Input Format
First argument is the head pointer of the linked list.



Output Format
Return the head pointer of the linked list after removing all duplicates.



Example Input
Input 1:

 1->1->2
Input 2:

 1->1->2->3->3


Example Output
Output 1:

 1->2
Output 2:

 1->2->3


Example Explanation
Explanation 1:

 Each element appear only once in 1->2.
 */
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
