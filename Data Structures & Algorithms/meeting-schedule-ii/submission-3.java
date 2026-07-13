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
        int output =0, count =0;
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();

        for(Interval a : intervals){
            start.add(a.start);
            end.add(a.end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int s = 0, e = 0;

        while(s < intervals.size() && e < intervals.size()){            
            if(start.get(s) < end.get(e)){
                count++;
                s++;
            }
            else{
                count--;
                e++;
            }

            if(output < count){
                output = count;
            }
            System.out.println("Count: "+count+"  & Output:"+output);
        }

        return output;

    }
}
