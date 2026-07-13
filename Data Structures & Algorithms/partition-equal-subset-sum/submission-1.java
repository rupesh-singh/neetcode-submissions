class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n : nums){
            total = total + n;
        }
        if(total % 2 != 0)
            return false;
        int target = total / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i-1] <= j)
                    take = dp[i-1][j-nums[i-1]];
                dp[i][j] = notTake || take;
            }
        }

        return dp[n][target];

        //return check(0,total/2,nums);

    }

    public boolean check(int index, int sum, int[] nums){
        if(sum == 0)
            return true;
        
        if(sum < 0 || index >= nums.length)
            return false;
        
        return check(index+1,sum,nums) || check(index+1,sum-nums[index],nums);
    }
}

/*
[1,2,3,4]
total = 1 + 2 + 3 + 4 = 10;
target = total /2 ;
sum == target 
    true
*/