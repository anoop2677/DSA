package backtrackinRecursion;

import java.util.ArrayList;
import java.util.Arrays;

/* generate all possible combinations of size N from A
*/
public class Combinations {
    static ArrayList<Integer> al = new ArrayList<>();
    public static void solve(int n, int[] y, int ind){
        if(ind == n){
            System.out.println(Arrays.toString(al.toArray()));
            al.remove(al.size()-1);
            return;
        }
        for(int i = 0; i < y.length; i++){
            al.add(y[i]);
            solve(n, y, ind + 1);
            if(i == (y.length-1) && al.size() > 0){
                al.remove(al.size()-1);
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] y = {1, 2, 3};
        solve(y.length ,y, 0);
    }
}
