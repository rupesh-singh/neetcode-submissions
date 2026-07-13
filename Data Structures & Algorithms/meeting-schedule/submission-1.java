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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0)
            return true;
        
        // sort based on start time
        Collections.sort(intervals,(a,b) -> a.start - b.start);

        //
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i=1;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(end > curr.start){
                return false;
            }
            else {
                start = Math.min(start,curr.start);
                end = Math.max(end,curr.end);
            }
        }

        return true;
    }
}
