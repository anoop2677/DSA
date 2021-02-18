package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IntegerContainingOneTwoThree {
    public static int[] solve(int A) {
        if(A == 1){
            return new int[]{1};
        }
        if(A == 2){
            return new int[]{1,2};
        }
        if(A == 3){
            return new int[]{1,2,3};
        }
        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[A];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 3;
        q.add(1);
        q.add(2);
        q.add(3);
        int i = 3;
        while(i <= A){
            int x = q.peek();
            int y = x * 10 + 1;
            ans[i] = y;
            i++;
            System.out.println(i + " **** "+ Arrays.toString(ans));
            if(i == A){
                return ans;
            }
            y = x * 10 + 2;
            ans[i] = y;
            i++;
            System.out.println(i + " **** "+ Arrays.toString(ans));
            if(i == A){
                return ans;
            }
            y = x * 10 + 3;
            ans[i] = y;
            i++;
            System.out.println(i + " **** "+ Arrays.toString(ans));
            q.remove();
            if(i == A){
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(9));
    }
}
