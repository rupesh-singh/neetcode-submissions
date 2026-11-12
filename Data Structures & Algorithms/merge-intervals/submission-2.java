class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> output = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0] <= end){
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
            else {
                output.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        output.add(new int[]{start,end});

        int s = output.size();
        int[][] r = new int[s][2];
        int idx=0;
        for(int[] i: output){
            r[idx][0]= i[0];
            r[idx][1]= i[1];
            idx++;
        }
        return r;


    }
}
