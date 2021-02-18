/*
MAX and MIN
Problem Description

Given an array of integers A .

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A % 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000



Input Format
The first and only argument given is the integer array A.



Output Format
Return the sum of values of all possible subarrays of A % 10^9+7.



Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26
 */
package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAndMin {
    static Stack<Integer> st = new Stack<Integer>();
    static long mod = (long)1e9 + 7;
    static int findMaxSum(int arr[], int n){
        long left[] = new long[n];
        long right[] = new long[n];
        long left1[] = new long[n];
        long right1[] = new long[n];
        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]){
                left[i] += left[st.peek()] + 1;
                st.pop();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(left));
        while (!st.isEmpty()) st.pop();
        for (int i = n - 1; i >= 0; i--){
            while (!st.isEmpty() && arr[st.peek()] < arr[i]){
                right[i] += right[st.peek()] + 1;
                st.pop();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(right));
        while (!st.isEmpty()) st.pop();

        for (int i = 0; i < n; i++){
            while (!st.isEmpty() && arr[st.peek()] > arr[i]){
                left1[i] += left1[st.peek()] + 1;
                st.pop();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(left1));
        while (!st.isEmpty())st.pop();
        for (int i = n - 1; i >= 0; i--){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                right1[i] += right1[st.peek()] + 1;
                st.pop();
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(right1));
        while (st.size() != 0) st.pop();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long x1 = ((left[i] + 1) * (right[i] + 1) - (left1[i] + 1) * (right1[i] + 1)) % mod;
            long mul = ((long) arr[i] * x1) % mod;
            ans = (ans + mul) % mod;
        }
        return (int)((ans + mod)% mod);
    }

    public static int solve(int[] A) {
        return findMaxSum(A,A.length);
    }

    public static void main(String[] args) {
        int[] x = {994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066};
        System.out.println(findMaxSum(x,x.length));
    }
}
