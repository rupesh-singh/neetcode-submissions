class Solution {
    public int maxArea(int[] heights) {
        int max =0;
        int i=0, j=heights.length-1;

        while(i<j){
            int temp =0;
            if(heights[i] > heights[j]){
                temp = heights[j] * (j-i);
                j--;
            }
            else{
                temp = heights[i] * (j-i);
                i++;
            }
            if(temp > max)
                max = temp;
        }

        return max;
        
    }
}
