public class NoMoreZeroes {
    public static String solve(int A) {
        int x = A + 1;
        String ans = "";
        if(x % 10 != 0) return String.valueOf(x);
        else{
            int k = 0;
            while(x%10 == 0){
                k++;
                x = x / 10;
            }
            String s = String.valueOf(A+1);
            for(int i = s.length() - 1; i >= 0; i--){
                if(i >= s.length() - k)
                    ans = ans + "1";
                else ans = s.charAt(i) + ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(11999));
    }
}
