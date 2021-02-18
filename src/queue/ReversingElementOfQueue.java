package queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReversingElementOfQueue {
    public static int[] solve(int[] A, int B) {
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            if(i < B){
                dq.addFirst(A[i]);
                System.out.println(dq);
            }
            else{
                dq.addLast(A[i]);
                System.out.println(dq);
            }
        }
        int[] ans = new int[A.length];
        int i = 0;
        while(!dq.isEmpty()){
            ans[i] = dq.peekFirst();
            dq.removeFirst();
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {43, 35, 25, 5, 34, 5, 8, 7};
        System.out.println(Arrays.toString(solve(x, 6)));
    }
}
