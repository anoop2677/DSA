/*
Problem Description

Given an array of integers A of size N which denotes N cylindrical empty bottles. The radius of the ith bottle is A[i].
You can put the ith bottle into the jth bottle if the following conditions are met:

ith bottle is not put into another bottle.
jth bottle dosen't contain any other bottle.
The radius of bottle i is smaller than bottle j (A[i] < A[j]).
You can put bottles into each other any number of times. You want to MINIMIZE the number of visible bottles. A bottle is called visible if it is not put into any other bottle.

Find and return the minimum number of visible bottles.



Problem Constraints
1 <= N <= 100000

1<= A[i] <= 100000000



Input Format
First argument is an integer array A denoting the radius of the cyclindrical bottles.



Output Format
Return a single integer corresponding to the minimum number of visible bottles.



Example Input
Input 1:

A = [1, 2, 3]
Input 2:

A = [1, 1]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 In example 1 it is possible to put bottle 1 into bottle 2, and 2 into 3.
Explanation 2:

 Both bottles will be visible.
 */
package sorting2;

import java.util.HashMap;

public class GameOfBottles {
    public static int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(!map.containsKey(A[i])){
                map.put(A[i], 1);
            }
            else{
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        int maxCount = 0;
        for(int i : map.keySet()){
            maxCount = Math.max(maxCount, map.get(i));
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3};
        System.out.println(solve(x));
    }
}
