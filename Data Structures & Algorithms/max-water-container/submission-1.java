class Solution {
    public int maxArea(int[] heights) {
        int i =0, j= heights.length-1;
        int max = 0;
        while(i < j){
            int currMax = Math.min(heights[i],heights[j]);
            int currArea = currMax * (j - i);
            if(heights[i] > heights[j]){
                j--;
            }
            else {
                i++;
            }
            max = Math.max(currArea,max);
        }
        return max;
    }
}
