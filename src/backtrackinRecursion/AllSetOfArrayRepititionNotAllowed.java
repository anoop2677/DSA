package backtrackinRecursion;

import java.util.ArrayList;

public class AllSetOfArrayRepititionNotAllowed {
    static ArrayList<ArrayList<Integer>> all = new ArrayList<>();
    public static void solve(int N, int[] x,int[] y, int ind){
        if(ind == N) {
            for(int i = 0; i < N; i++){
                if(y[i] == 0){
                    System.out.print(x[i]+ "  ");
                }
            }
            System.out.println();
            return;
        }
        y[ind] = 0;
        solve(N, x, y, ind + 1);
        y[ind] = 1;
        solve(N, x, y, ind + 1);

    }

    public static void main(String args[]) {
        int n=3;
        int[] y = {1,2,3};
        int[] z= new int[n];
        solve(n, y, z,0);
    }
}
