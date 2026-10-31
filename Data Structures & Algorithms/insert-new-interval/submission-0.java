class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> output = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for(int i=0;i<intervals.length;i++){

            if(start != -1 && end < intervals[i][0]){
                output.add(new int[]{start,end});
                output.add(intervals[i]);
                start = -1;
                end = -1;
            }
            else if(end !=- 1 && start <= intervals[i][1]){
                start = Math.min(start,intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            else {
                output.add(intervals[i]);
            }
            
        }

        if(start != -1){
           output.add(new int[]{start,end}); 
        }

        return output.toArray(new int[output.size()][]);

    }
}
