/*
Kth Smallest Element
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
First argument is vector A.

Second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.
 */
package sorting;

public class KthSmallestElement {
    public int kthsmallest(final int[] A, int B) {

//        for(int i=0;i<B;i++)
//        {
//            int minn = Integer.MAX_VALUE, idx = 0;
//            for(int j=i;j<A.length;j++)
//            {
//                if(A[j] < minn)
//                {
//                    minn = A[j];
//                    idx = j;
//                }
//            }
//
//            int tmp = A[i];
//            A[i] = A[idx];
//            A[idx] = tmp;
//        }
//        return A[B-1];


        if (B > A.length)
            return -1;
        int lo = Integer.MAX_VALUE;
        int hi = 0;
        for(int i = 0; i < A.length; i++){
            lo = Math.min(lo, A[i]);
            hi = Math.max(hi, A[i]);
        }
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            int countLess = 0, countEqual = 0;

            for (int i = 0; i<A.length; i++){
                if (A[i] < mid)
                    countLess++;
                else if (A[i] == mid)
                    countEqual++;
                if (countLess >= B)
                    break;
            }

            if (countLess < B && countLess + countEqual >= B)
                return mid;
            else if (countLess >= B)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return -1;
    }
}
