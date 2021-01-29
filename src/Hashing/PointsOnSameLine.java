package Hashing;

import java.util.HashMap;

public class PointsOnSameLine {
    static class Pair {
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public static int solve(int[] A, int[] B) {
        int max = 0, vp = 0, op = 0;
        int maxPoint = 0;
        for(int i = 0; i < A.length; i++){
            max = 0; vp = 0; op = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int j = i+1; j < A.length; j++){
                if(B[i] == B[j] && A[i] == A[j]){
                    op++;
                }
                else if(A[i] == A[j]){
                    vp++;
                }
                else{
                    int ydif = B[j] - B[i];
                    int xdif = A[j] - A[i];
                    int g = gcd(xdif, ydif);
                    ydif /= g;
                    xdif /= g;
                    Pair p = new Pair(xdif, ydif);
                    map.put(p.toString(), map.getOrDefault(p.toString(), 1) + 1);
//                    System.out.println(p.toString()+" **** "+map.get(p.toString()));
                    max = Math.max(map.get(p.toString()), max);
                }
                max = Math.max(max, vp+1);
            }
            System.out.print(max+op);
            if(op == 0) {
                System.out.print(max+op);
                maxPoint = Math.max(maxPoint, max + op);
            }
            else {
                System.out.print(max+op+1);
                maxPoint = Math.max(maxPoint, max + op + 1);
            }
        }
        return maxPoint;
    }

    public static void main(String[] args) {
        int[] x = {48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28, -44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37};
        int[] y = {47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44, 23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37};
        System.out.println(solve(x,y));
    }
}
