class Solution {
    public int maxSubArray(int[] nums) {
        int temp = 0, max= Integer.MIN_VALUE;
        for(int i=0;i< nums.length;i++){
            temp = temp + nums[i];
            max = Math.max(temp,max);
            temp = (temp < 0) ? 0 : temp;
        }

        return max;
    }
}
