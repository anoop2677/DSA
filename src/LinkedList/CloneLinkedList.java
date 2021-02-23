/*
Clone a Linked List
Problem Description

Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.

You have to create a copy of this list and return the head pointer of the duplicated list.



Problem Constraints
1 <= length of the list <= 100000

1 <= Value of node <= 100000



Input Format
The only argument given is head pointer of the doubly linked list.



Output Format
Return the head pointer of the duplicated list.



Example Input
Input 1:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
Input 2:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1


Example Output
Output 1:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1
Output 2:

1 -> 2 -> 3 -> 4 -> 5
random pointer of each node
1 -> 5 2 -> 4 3 -> 3 4 -> 2 5 -> 1


Example Explanation
Explanation 1:

 Just clone the given list.
Explanation 2:

 Just clone the given list
 */
package LinkedList;

public class CloneLinkedList {
    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode random;
        ListNode(int x) { val = x; next = null; random = null; }
    }
    ListNode cloneList(ListNode A) {
        ListNode curr = A, temp = null;
        while(curr != null){
            temp = curr.next;
            curr.next = new ListNode(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = A;
        while(curr != null){
            if(curr.next != null)
                curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
            curr = (curr.next != null) ? curr.next.next : curr.next;
        }
        ListNode original = A, copy = A.next;
        temp = copy;
        while(original != null && copy != null){
            original.next = (original.next != null) ? original.next.next : original.next;
            copy.next = (copy.next != null) ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }
}
