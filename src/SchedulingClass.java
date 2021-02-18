import java.util.*;
public class SchedulingClass {
     static class Interval{
        private double start , end;
        public Interval(double start , double end){
            this.start = start;
            this.end = end;
        }
         @Override
         public String toString() {
             return "Interval{" +
                     "start=" + start +
                     ", end=" + end +
                     '}';
         }
     }
    public static int maxActivities(Interval[] time, int n)
    {
        int i, j;
        i = 0;
        int count = 1;
        for (j = 1; j < n; j++){
            if (time[j].start >= time[i].end){
                count++;
                i = j;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfClasses = sc.nextInt();
        int[] ans = new int[noOfClasses];
        int j = 0;
        while(noOfClasses-- > 0){
            int subjects = sc.nextInt();
            String[] subjectName = new String[subjects];
            Interval[] time = new Interval[subjects];
            for(int i = 0; i < subjects; i++){
                subjectName[i] = sc.next();
                String t1 = sc.next();
                t1 = String.join(".", t1.split(":"));
                String t2 = sc.next();
                t2 = String.join(".", t2.split(":"));
                time[i] = new Interval(Double.parseDouble(t1), Double.parseDouble(t2));
            }
            Arrays.sort(time,(o1, o2) -> {
                if(o1.end > o2.end)
                    return 1;
                else return -1;
            });
//            System.out.println(Arrays.toString(time));
            ans[j] = maxActivities(time, subjects);
            j++;
        }
        for(int i: ans){
            System.out.println(i);
        }
    }
}
