package backtrackinRecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPermutations {
    public static ArrayList<int []> printAllRecursive(int k, int [] a, ArrayList<int []> output){
        if (k == 1) {
            output.add(a.clone());
        } else {
            output = printAllRecursive(k-1, a, output);
            for (int i=0; i<k-1; i++) {
                if (k%2 == 0) {
                    int temp = a[i];
                    a[i] = a[k-1];
                    a[k-1] = temp;
                } else {
                    int temp = a[0];
                    a[0] = a[k-1];
                    a[k-1] = temp;
                }
                printAllRecursive(k-1, a, output);
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ArrayList<int []> ret = new ArrayList<int []> ();
        ret = printAllRecursive(a.length, a, ret);
        for(int[] x: ret){
            System.out.println(Arrays.toString(x));
        }
    }
}
