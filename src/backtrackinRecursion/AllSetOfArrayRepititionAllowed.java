package backtrackinRecursion;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AllSetOfArrayRepititionAllowed {
    public static void printPowerSet(int[] x, Deque<Integer> out, int ind){
        if(ind == x.length){
            System.out.println(out);
            return;
        }
        out.addLast(x[ind]);
        printPowerSet(x, out, ind + 1);
        out.pollLast();
        while(ind < x.length - 1 && x[ind] == x[ind + 1]){
            ind++;
        }
        printPowerSet(x, out, ind + 1);
    }
    public static void main(String[] args) {
        int[] x = {1, 1, 2, 2, 3};
        Arrays.sort(x);
        Deque<Integer> out = new ArrayDeque<>();
        printPowerSet(x, out, 0);
    }
}
