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
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();

        for(Interval temp: intervals){
            start.add(temp.start);
            end.add(temp.end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int i=0,j=0, count=0, max=0;

        while(i<intervals.size()){
            if(start.get(i) < end.get(j)){
                count++;
                i++;
            }
            else{
                j++;
                count--;
            }
            if(max < count)
                max = count;
        }

        return max;
    }
}
