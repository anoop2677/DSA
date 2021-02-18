package queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaxMinSum {
    public static int solve(int[] A, int B) {
        int j = 0;
        int mod = (int)1e9 + 7;
        Deque<Integer> dq = new LinkedList<>();
        Deque<Integer> dq1 = new LinkedList<>();
        int sum = 0;
        int i =0;
        for (i = 0; i < B; i++){
            while (!dq.isEmpty() && A[i] >= A[dq.peekLast()])
                dq.removeLast();
            while (!dq1.isEmpty() && A[i] <= A[dq1.peekLast()])
                dq1.removeLast();
            dq.addLast(i);
            dq1.addLast(i);
        }
        for (; i < A.length; i++) {
            sum = (sum + A[dq.peekFirst()] + A[dq1.peekFirst()]) % mod;
            System.out.println(A[dq.peek()] + " **** "+A[dq1.peek()]);
            while ((!dq.isEmpty()) && dq.peekFirst() <= i - B)
                dq.removeFirst();
            while ((!dq.isEmpty()) && A[i] >= A[dq.peekLast()])
                dq.removeLast();
            while ((!dq1.isEmpty()) && dq1.peekFirst() <= i - B)
                dq1.removeFirst();
            while ((!dq1.isEmpty()) && A[i] <= A[dq1.peekLast()])
                dq1.removeLast();
            dq.addLast(i);
            dq1.addLast(i);
        }
        sum = (sum + A[dq.peekFirst()] + A[dq1.peekFirst()]) % mod;
        return (sum) % mod;
    }

    public static void main(String[] args) {
        int[] x = {2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(x, 4));
    }
}
