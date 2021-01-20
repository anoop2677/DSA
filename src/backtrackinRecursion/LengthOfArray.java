package backtrackinRecursion;

public class LengthOfArray {
    public static void main(String[] args) {
        int a[] = {1,1,2,3,4,5,0,6,7};
        int length = 0;
        while(true){
            try{
                a[length]++;
                a[length]--;
                length++;
            }
            catch(Exception e){
                System.out.println(length);
                break;
            }
        }

//        for(int i : a){
//            length++;
//        }

    }
}
