/*
Merge Intervals
Problem Description

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.



Problem Constraints
1 <= |intervals| <= 105



Input Format
First argument is the vector of intervals

second argument is the new interval to be merged



Output Format
Return the vector of intervals after merging



Example Input
Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output
Output 1:

 [ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]


Example Explanation
Explanation 1:

(2,5) does not completely merge the given intervals
Explanation 2:

(2,6) completely merges the given intervals
 */
package ArraysAndMaths;

import java.util.ArrayList;

public class MergeIntervals {

      public static class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> ans = new ArrayList<>();
        if(intervals.size() == 0){
            ans.add(newInterval);
            return ans;
        }
        if(newInterval.start > newInterval.end){
            int temp = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = temp;
        }
        if(newInterval.start < intervals.get(0).start && newInterval.end < intervals.get(0).start){
            ans.add(newInterval);
            intervals.forEach((interv) -> ans.add(interv));
            return ans;
        }
        if(newInterval.start > intervals.get(n-1).end){
            intervals.forEach((interv) -> ans.add(interv));
            ans.add(newInterval);
            return ans;
        }
        boolean st = false, en = false;
        int sind = -1, eind = -1;
        for(int i = 0; i < n; i++){
            if(newInterval.start <= intervals.get(i).end && newInterval.start >= intervals.get(i).start){
                sind = i;st = true;
            }
            if(newInterval.end <= intervals.get(i).end && newInterval.end >= intervals.get(i).start){
                eind = i;en = true;
            }
            if(i < n-1 ){
                if(newInterval.start > intervals.get(i).end && newInterval.start < intervals.get(i+1).start && st == false){
                    sind = i;
                }
                if(newInterval.end > intervals.get(i).end && newInterval.end < intervals.get(i+1).start && en == false){
                    eind = i;
                }
            }
        }
        Interval in = new Interval();
        if(st == true && en == true){
            if(sind == eind) return intervals;
            else{
                for(int i = 0; i <= sind; i++){
                    if(i == sind){
                        in.start = intervals.get(i).start;
                    }
                    else{
                        ans.add(intervals.get(i));
                    }
                }
                for(int i = eind; i < n; i++){
                    if(i == eind){
                        in.end = intervals.get(i).end;
                        ans.add(in);
                    }
                    else{
                        ans.add(intervals.get(i));
                    }
                }
            }
        }
        else if(st == true){
            for(int i = 0;i <=sind; i++){
                if(i == sind){
                    in.start = intervals.get(i).start;
                }
                else{
                    ans.add(intervals.get(i));
                }
            }
            if(eind == -1){
                in.end = newInterval.end;
                ans.add(in);
                return ans;
            }
            else{
                for(int i = eind; i < n; i++){
                    if(i == eind){
                        in.end = newInterval.end;
                        ans.add(in);
                    }
                    else{
                        ans.add(intervals.get(i));
                    }
                }
            }
        }
        else if(en == true){
            if(sind == -1){
                in.start = newInterval.start;
            }
            else{
                for(int i = 0; i <=sind; i++){

                    ans.add(intervals.get(i));
                }
            }
            for(int i = eind; i < n; i++){
                if(i == eind){
                    in.start = newInterval.start;
                    in.end = intervals.get(i).end;
                    ans.add(in);
                }
                else{
                    ans.add(intervals.get(i));
                }
            }
        }
        else{
            if(sind == -1  && eind == -1){
                ans.add(newInterval);
                return ans;
            }
            else if(sind == -1){
                in.start = newInterval.start;
                for(int i = eind; i < n; i++){
                    if(i == eind){
                        in.end = newInterval.end;
                        ans.add(in);
                    }
                    else{
                        ans.add(intervals.get(i));
                    }
                }
            }
            else if(eind == -1){
                for(int i = 0; i <=sind; i++){
                    ans.add(intervals.get(i));
                }
                ans.add(newInterval);
                return ans;
            }
            else{
                // System.out.println(sind + " " +eind);
                for(int i = 0; i <= sind; i++){
                    ans.add(intervals.get(i));
                }
                for(int i = eind; i < n; i++){
                    if(i == eind){
                        ans.add(newInterval);
                    }
                    else{
                        ans.add(intervals.get(i));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
