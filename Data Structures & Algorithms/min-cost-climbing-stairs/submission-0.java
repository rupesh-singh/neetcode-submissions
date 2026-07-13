class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minsteps(cost,0,cost.length),minsteps(cost,1,cost.length));
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
