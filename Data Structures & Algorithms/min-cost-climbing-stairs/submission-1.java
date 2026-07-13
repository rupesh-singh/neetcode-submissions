class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        //return Math.min(minsteps(cost,0,cost.length),minsteps(cost,1,cost.length));
        return dp[n];
    }

    public int minsteps(int[] cost, int i, int n){
        if(i == n)
            return 0;

        if ( i > n)
            return 0;
        
        int left = cost[i] + minsteps(cost, i+1, n);
        int right = cost[i] + minsteps(cost, i+2, n);

        return Math.min(left,right);
    }
}
