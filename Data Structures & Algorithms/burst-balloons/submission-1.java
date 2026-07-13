class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] padded = new int[n+2];
        int[][] dp = new int[n+2][n+2];

        for(int i=0;i<n+2;i++){
            for(int j=0;j<n+2;j++){
                dp[i][j] =-1;
            }
        }

        padded[0] = 1;
        padded[n+1] = 1;

        for(int i=1;i<=n;i++)
            padded[i] = nums[i-1];
        
        return coins(padded,1,n,dp);
    }

    public int coins(int[] nums, int l, int r, int[][] dp){
        if(l > r)
            return 0;

        if(dp[l][r] != -1)
            return dp[l][r];

        int max = 0;
        for(int i = l; i<=r;i++){
            int curr = nums[i];
            int prev = nums[l-1];
            int next = nums[r+1];

            int count =  prev * curr * next + coins(nums,l,i-1, dp) + coins(nums,i+1,r, dp);
            max = Math.max(count,max);
        }
        dp[l][r] = max;
        return dp[l][r];

    }
}
