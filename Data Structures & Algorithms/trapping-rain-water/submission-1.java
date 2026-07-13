class Solution {
    public int trap(int[] height) {        
        if(height.length == 1 || height.length == 2)
            return 0;
        int max =0;
        int leftmax=height[0], rightmax =height[height.length -1];
        int i=0,j=height.length-1;
        while(i < j){
            int temp =0;
            if(leftmax > rightmax){
                j--;
                rightmax = Math.max(rightmax,height[j]);
                temp = rightmax - height[j];                      
            }
            else{
                i++;
                leftmax = Math.max(leftmax,height[i]);
                temp = leftmax - height[i];                                
            }

            if(temp>0)
                max = max + temp;
        }

        return max;

    }
}
