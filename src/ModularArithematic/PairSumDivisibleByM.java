package ModularArithematic;

public class PairSumDivisibleByM {
    public static int solve(int[] A, int B) {
        int[] rem = new int[B];
        int mod = (int)1e9 + 7;
        for(int i = 0; i < A.length; i++){
            rem[A[i] % B]++;
        }
        int ans = rem[0] * (rem[0] - 1) / 2;
        for(int i = 1; i <= B/2 && i != B - i; i++){
            ans = (ans + (rem[i] * rem[B - i])) % mod;
        }
        if(B / 2 == 0){
            ans = (ans + (rem[B / 2] * (rem[B / 2] - 1) / 2)) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x= {1, 2, 3, 4, 5};
        System.out.println(solve(x, 2));
    }
}
