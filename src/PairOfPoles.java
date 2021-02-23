import java.util.Arrays;
import java.util.Stack;

public class PairOfPoles {
    public static int solve(int[] A){
        int ans = 0;
        int n = A.length;
        if(n <= 1) return 0;
        if(n == 2) return 1;
        int[] precalc = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(A[n - 1]);
        for(int j = n - 2; j >= 0; j-- ){
            if(A[j] < st.peek()){
                precalc[j] = 1;
                st.push(A[j]);
            }
            else{
                int count = 0;
                while(!st.isEmpty() && A[j] > st.peek()){
                    st.pop();
                    count++;
                }
                precalc[j] = count;
                st.push(A[j]);
            }
        }
        System.out.println(Arrays.toString(precalc));
        for(int i = 1; i < n; i++){
            if(A[i] > A[i - 1]){
                ans++;
                System.out.println(1 + " ** "+ ans + " ** "+A[i]);
            }
            else{
                ans = ans + precalc[i] + 1;
                System.out.println((precalc[i] + 1) + " ** " + ans + " ** "+A[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[] a= {120, 131, 101, 30, 17, 127, 55, 35, 45, 50, 64, 62, 96, 92, 63, 76, 25, 52, 85, 75};
//        int[] a= {4,3,6,1,10};
        int[] a= {29,107,130,105,51, 96,36,79,120,55,22,113,60,32,8,127,52};
        System.out.println(solve(a));
    }
}
