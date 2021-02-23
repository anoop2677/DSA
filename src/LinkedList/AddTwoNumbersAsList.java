/*
Add Two Numbers as Lists
Problem Description

You are given two linked lists, A and B representing two non-negative numbers.

The digits are stored in reverse order and each of their nodes contain a single digit.

Add the two numbers and return it as a linked list.



Problem Constraints
1 <= |A|, |B| <= 105



Input Format
The first argument of input contains a pointer to the head of linked list A.

The second argument of input contains a pointer to the head of linked list B.



Output Format
Return a pointer to the head of the required linked list.



Example Input
Input 1:


 A = [2, 4, 3]
 B = [5, 6, 4]
Input 2:


 A = [9, 9]
 B = [1]


Example Output
Output 1:


 [7, 0, 8]
Output 2:


 [0, 0, 1]


Example Explanation
Explanation 1:

 A = 342 and B = 465. A + B = 807.
Explanation 2:

 A = 99 and B = 1. A + B = 100.
 */
package LinkedList;

public class AddTwoNumbersAsList {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode node;
        ListNode prev = null;
        ListNode first = null;
        int carry = 0;
        int sum = 0;

        while (A != null || B != null || carry != 0) {

            node = new ListNode(0);
            sum = carry;

            if (first == null)
                first = node;

            if (prev != null)
                prev.next = node;

            if (A != null) {
                sum += A.val;
                A = A.next;
            }

            if (B != null) {
                sum += B.val;
                B = B.next;
            }

            node.val = sum % 10;

            sum /= 10;
            carry = sum;
            prev = node;
        }

        return first;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(9);
        root.next = new ListNode(9);
//        root.next.next = new ListNode(3);
        ListNode root1 = new ListNode(1);
//        root1.next = new ListNode(6);
//        root1.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(root, root1);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
