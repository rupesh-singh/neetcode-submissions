class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        
        if(nums.length == 1){
            return nums[0];
        }

        int max = nums[0];

        for(int i=0;i<nums.length;i++)
            dp[i] = nums[i];

        for(int i=1;i<nums.length;i++){
            int j = 0;

            while(j < i){

                if(j+1 == i){
                    dp[i] = Math.max(max,dp[i]);
                }
                else{
                    dp[i] = dp[j] + nums[i];
                }

                if(dp[i] > max){
                    max = dp[i];
                }

                j++;
            }
        }

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        return max;
        
    }
}
