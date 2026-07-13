/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        int idx =0;
        for(Interval i: intervals){
            int s = i.start;
            int e = i.end;
            start[idx] = s;
            end[idx] = e;
            idx++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int days =0, i=0, j=0, min_days = Integer.MIN_VALUE;
        while(i<n){
            if(start[i] < end[j]){
                days++;
                i++;
            }
            else {
                days--;
                j++;
            }
            min_days = Math.max(days,min_days);
        }

        return min_days == Integer.MIN_VALUE ? 0 : min_days;
    }
}
