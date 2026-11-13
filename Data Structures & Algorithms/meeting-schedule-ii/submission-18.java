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
        int size = intervals.size();
        int[] start = new int[size];
        int[] end = new int[size];

        for(int i=0;i<size;i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i=0,j=0;
        int max = Integer.MIN_VALUE;
        int currentRooms=0;

        while(i<size){
            if(start[i] < end[j]){
                i++;
                currentRooms++;
            }
            else {
                j++;    
                currentRooms--;
            }
            max = Math.max(max,currentRooms);
        }

        return max == Integer.MIN_VALUE ? 0 :max;

    }
}
