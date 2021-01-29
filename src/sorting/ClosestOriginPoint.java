/*
B Closest Points to Origin
Problem Description

We have a list A, of points(x,y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1,y1) and P2(x2,y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 100000
-100000 <= A[i][0] <= 100000
-100000 <= A[i][1] <= 100000



Input Format
The argument given is list A and an integer B.



Output Format
Return the B closest points to the origin (0, 0) in any order.



Example Input
Input 1:

 A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1
Input 2:

 A = [
       [1, -1],
       [2, -1]
     ]
 B = 1


Example Output
Output 1:

 [ [-2, 2] ]
Output 2:

 [ [1, -1] ]
 */
package sorting;

import java.util.Arrays;

public class ClosestOriginPoint {
    public static long euclideanDistance(int x, int y){
        return x*x + y*y;
    }
    public static int[][] solve(int[][] A, int B) {
        long[] euclid = new long[A.length];
        for(int i = 0; i < A.length; i++){
            euclid[i] = euclideanDistance(A[i][0], A[i][1]);
        }
        Arrays.sort(euclid);
        int[][] ans = new int[B][2];
        long minDist = euclid[B - 1];
        int j = 0;
        for(int i = 0; i < A.length; i++){
            long dist = euclideanDistance(A[i][0], A[i][1]);
            if(dist <= minDist){
                ans[j][0] = A[i][0];
                ans[j][1] = A[i][1];
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {
                {1,3},
                {-2,2}
        };
        System.out.println(solve(x, 1));
    }
}
