class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        int[] arr1 = new int[nums.length-1];
        int[] arr2 = new int[nums.length-1];

        for(int i=0;i<nums.length -1;i++){
            arr1[i] = nums[i];
        }

        for(int i=1;i<nums.length;i++){
            arr2[i-1] = nums[i];
        }

        int a = robs(arr1);
        int b = robs(arr2);

        return a > b ? a: b;

    }


    public int robs(int[] nums) {
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
        return max;      
    }

}
