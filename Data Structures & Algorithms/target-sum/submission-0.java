class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }

    public int dfs(int[] nums, int target, int index, int sum){
        if(index == nums.length)
            return sum == target ? 1 : 0;
        
        return dfs(nums,target,index+1,sum+nums[index]) + dfs(nums,target,index+1,sum-nums[index]);
    }
}
