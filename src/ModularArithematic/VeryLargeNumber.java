/*
Very Large Power
Problem Description

Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power ,

"%" means "mod", and

"!" means factorial.



Problem Constraints
1 <= A, B <= 5e5



Input Format
First argument is the integer A

Second argument is the integer B



Output Format
Return one integer, the answer to the problem



Example Input
Input 1:

A = 1
B = 1
Input 2:

A = 2
B = 2


Example Output
Output 1:

1
Output 2:

4


Example Explanation
Explanation 1:

 1! = 1. Hence 1^1 = 1.
Explanation 2:

 2! = 2. Hence 2^2 = 4.
 */
package ModularArithematic;

public class VeryLargeNumber {
    static long power(long a, long b, long m){
        if(b == 0) return 1;
        if(b == 1) return a;
        System.out.println(a);
        if(b % 2 == 0) return (power((a * a) % m, b / 2, m)) % m;
        else return (a * (power((a * a) % m, b / 2, m)) % m) % m;
    }

    public static int solve(int A, int B) {
        long ans = 0;
        long mod = (long)1e9 + 7;
        long p = 1;
        while(B > 0){
            p = (p * B) % (mod - 1);
            B--;
        }
        ans = (ans + power(A, p, mod)) % mod;
        return (int)(ans % mod);
    }

    public static void main(String[] args) {
        System.out.println(solve(2, 27));
    }
}
