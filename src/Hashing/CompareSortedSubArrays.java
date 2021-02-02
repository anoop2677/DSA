/*

 */
package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CompareSortedSubArrays {
    public static int[] solve(int[] A, int[][] B) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            if(map.containsKey(A[i])){
                ArrayList<Integer> al = map.get(A[i]);
                al.add(i);
                map.put(A[i], al);
            }
            else{
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i);
                map.put(A[i], al);
            }
        }
        int[] ans = new int[B.length];
        for(int i = 0; i < B.length; i++){
            boolean check = false;
            if(B[i][0] == B[i][2] && B[i][1] == B[i][3]) check = true;
            if(B[i][0] - B[i][2] == B[i][1] - B[i][3]){
                for(int j = B[i][0]; j <= B[i][1]; j++){
                    ArrayList<Integer> temp = map.get(A[j]);
                    boolean i1 = false;
                    boolean i2 = false;
                    for(int k : temp){
                        if(k >= B[i][0] && k<=B[i][1]){
                            i1 = true;
                        }
                        if(k >= B[i][2] && k<=B[i][3]){
                            i2 = true;
                        }
                    }
                    System.out.println(A[j] + " *** " +Arrays.toString(temp.toArray()));
                    System.out.println(1 >= B[i][0] && 1<=B[i][1]);
                    System.out.println(1 >= B[i][2] && 1<=B[i][3]);
                    if(i1 == true && i2 == true){
                        check = true;
                    }
                    else{
                        check = false;
                        break;
                    }
                }
            }
            if(check == true){
                ans[i] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = {88, 538, 1093, 1508, 2086, 2501, 3090, 3589, 4052, 4508, 5018, 5547, 6039, 6506, 7086, 7589, 8097, 8545, 9081, 9531, 10011, 10540, 11055, 11599, 12057, 12503, 13092, 13534, 14081, 14585, 15043, 15520, 16087, 16550, 17095, 17543, 18003, 18555, 19001, 19525, 20047, 20578, 21015, 21512, 22071, 22514, 23053, 23589, 24062, 24567, 25055, 25560, 26071, 26533, 27006, 27539, 28032, 28555, 29054, 29509, 30009, 30598, 31082, 31538, 32076, 32527, 33022, 33516, 34023, 34550, 35062, 35527, 36003, 36583, 37019, 37596, 38000, 38562, 39064, 39502, 40058, 40501, 41053, 41515, 42010, 42537, 43046, 43586, 44031, 44582, 45010, 45568, 46050, 46567, 47058, 47524, 48076, 48534, 49041, 49570, 50007, 50535, 51016, 51516, 52084, 52563, 53030, 53588, 54091, 54522, 55022, 55504, 56007, 56561, 57099, 57587, 58052, 58538, 59001, 59595, 60070, 60593, 61029, 61563, 62080, 62560, 63001, 63575, 64053, 64529, 65029, 65574, 66074, 66575, 67065, 67555, 68092, 68558, 69020, 69531, 70031, 70518, 71088, 71514, 72083, 72526, 73019, 73556, 74082, 74545, 75009, 75566, 76046, 76594, 77083, 77565, 78036, 78521, 79028, 79594, 80085, 80574, 81098, 81519, 82004, 82548, 83059, 83513, 84013, 84576, 85029, 85594, 86005, 86555, 87038, 87557, 88069, 88568, 89008, 89559, 90011, 90579, 91067, 91573, 92030, 92591, 93084, 93575, 94017, 94515, 95011, 95563, 96028, 96527, 97060, 97590, 98010, 98551, 99003, 99566};
        int[][] b = {{ 27, 39, 25, 37}};
        System.out.println(Arrays.toString(solve(x,b)));
     }
}
