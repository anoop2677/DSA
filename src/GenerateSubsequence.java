public class GenerateSubsequence {
    static int ans = Integer.MIN_VALUE;
    static int getMax(int[] A, int[] b, int mod){
        int res = 0;
        for(int i = 0; i < b.length; i++){
            if(b[i] == 1){
                res = (res + A[i]) % mod;
            }
        }
        return res;
    }
    static void generateSubsequence(int[] A, int index, int[] b, int mod){
        if(index == A.length){
            ans =Math.max(ans, getMax(A, b, mod));
            return;
        }
        b[index] = 1;
        generateSubsequence(A, index + 1, b, mod);
        b[index] = 0;
        generateSubsequence(A, index + 1, b, mod);

    }
    public static int solve(int[] A, int B) {
        for(int i = 0 ; i < A.length; i++){
            A[i] = A[i] % B;
        }
        int[] b = new int[A.length];
        generateSubsequence(A, 0, b, B);
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {47, 100, 49, 299};
        System.out.println(solve(x, 20));
    }
}
