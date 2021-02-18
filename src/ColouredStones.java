import java.util.*;
public class ColouredStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfStones = sc.nextInt();
        String str = sc.next();
        int charSwitch = str.charAt(0);
        int ans = -1;
        for(int i = 1; i < str.length();i++){
            if(charSwitch != str.charAt(i)){
                ans = i;
                charSwitch = str.charAt(i);
            }
        }

        if(ans == -1)
            System.out.println(0);
        else System.out.println(ans);
    }
}
