/*
Sort List
Problem Description

Sort a linked list, A in O(n log n) time using constant space complexity.



Problem Constraints
0 <= |A| = 105



Input Format
The first and the only arugment of input contains a pointer to the head of the linked list, A.



Output Format
Return a pointer to the head of the sorted linked list.



Example Input
Input 1:

A = [3, 4, 2, 8]
Input 2:

A = [1]


Example Output
Output 1:

[2, 3, 4, 8]
Output 2:

[1]


Example Explanation
Explanation 1:

 The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
Explanation 2:

 The sorted form of [1] is [1].
 */
package LinkedList;

public class SortList {
    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public ListNode sortList(ListNode A) {
        if(A == null || A.next == null) return A;
        ListNode slow = A, fast = A;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        ListNode left = sortList(A);
        ListNode right = sortList(nextOfMiddle);
        ListNode sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
}
