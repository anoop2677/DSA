import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ScaredRishik {
    static int bsearch(ArrayList<Integer> al, int k){
        int start = 0; int end = al.size() - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(al.get(mid) >= k){
                end = mid - 1;
            }
            else{
                ans = mid;
                start = mid + 1;
            }
        }
        if(ans == -1)return 0;
        return ans+1;
    }
    public static int[] solve(int A, int B, int[] C) {
        int[] ans = new int[C.length];
        int max = 0;
        for(int i = 0; i < C.length; i++){
            max = Math.max(max, C[i]);
        }
        int count = 1;
        int x = A;
        if(A!=1)
        while(x < max){
            x = x * x;
            count++;
        }
        else count =0;
        System.out.println(count);
        int count1 = 1;
        x = B;
        if(B!=1)
        while(x < max){
            x =x*x;
            count1++;
        }
        else count1 = 0;
        System.out.println(count1);

        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i <= count1; i++){
            for(int j = 0; j <= count; j++){
                int sum = (int)Math.pow(A, i) + (int)Math.pow(B, j);
                if(sum < max){
                    al.add(sum);
                }
                else break;
            }
        }
        System.out.println(Arrays.toString(al.toArray()));
        Collections.sort(al);
        for(int i = 0; i < C.length; i++){
            ans[i] = bsearch(al,C[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {2,4,11};
        System.out.println(Arrays.toString(solve(10,1,x)));
    }
}
