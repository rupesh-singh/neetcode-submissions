class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        int startIndex = intervals[0][0];
        int endIndex = intervals[0][1];

        int[][] output = new int[intervals.length][2];
        int j = 0;
        for(int i=0;i<intervals.length;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(endIndex >= currStart ){
                endIndex = Math.max(currEnd,endIndex);
            }
            else{
                output[j][0] = startIndex;
                output[j][1] = endIndex;
                j++;                
                startIndex = intervals[i][0];
                endIndex = intervals[i][1];            
            }
        }
        output[j][0] = startIndex;
        output[j][1] = endIndex;
        int[][] o = new int[j+1][2];

        for(int i=0;i<=j;i++){
            o[i][0] = output[i][0];
            o[i][1] = output[i][1];
        }
        return o;

    }
}
