package Hashing;

import java.util.HashMap;

public class CountRightTriangles {
    public static int solve(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        int mod = (int)1e9 + 7;
        int count = 0;
        for(int i = 0; i < A.length; i++){
            map.put(A[i],map.getOrDefault(A[i], 0) + 1);
            map1.put(B[i],map1.getOrDefault(B[i], 0) + 1);
        }
        System.out.println(map);
        System.out.println(map1);
        for(int i = 0; i < A.length; i++){
            count = (count + (map.get(A[i]) - 1) * (map1.get(B[i]) - 1)) % mod;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] x = {1, 1, 2};
        int[] y= {1, 2, 1};
        System.out.println(solve(x,y));
    }
}
