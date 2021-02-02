/*
Count Rectangles
Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.



Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered quadruplet that form a rectangle.



Example Input
Input 1:

 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:

 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 All four given points make a rectangle. So, the answer is 1.
Explanation 2:

 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)

 */
package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CountRectangles {
    public static int solve(int[] A, int[] B) {
        HashSet<String> set = new HashSet<>();
        int mod = (int)1e9 + 7;
        int count = 0;
        for(int i = 0; i < A.length; i++){
            String temp = A[i]+","+B[i];
            set.add(temp);
        }
//        System.out.println(set);
        String p1 = "";
        String p2 = "";
        for(int i = 0; i< A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(A[j] > A[i] && B[j] > B[i]){
                    p1 = A[i]+","+B[j];
                    p2 = A[j]+","+B[i];
//                    System.out.println(set.contains(p1) +" **** "+set.contains(p2));
                    if(set.contains(p1) && set.contains(p2)){
//                        System.out.println(p1+" **** "+p2);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] x = {38, 36, 48, 42, 36, 56, 38, 48, 40, 24, 48, 32, 22, 54, 22, 42, 34, 54, 52, 36, 52, 38, 36, 30, 30, 44, 46, 58, 56, 52, 48, 34, 36, 42, 50, 34, 28, 44, 44, 60, 56, 32, 48, 22, 56, 38, 42};
        int[] y = {58, 42, 30, 60, 50, 42, 40, 24, 54, 28, 52, 54, 28, 32, 42, 54, 38, 38, 54, 24, 30, 60, 44, 40, 26, 56, 28, 60, 34, 50, 48, 28, 56, 34, 48, 26, 30, 22, 52, 36, 24, 50, 42, 58, 54, 54, 48};
        System.out.println(solve(x,y));
    }
}
