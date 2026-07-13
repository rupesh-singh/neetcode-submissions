class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums,0,-1);
    }

    public int dfs(int[] nums, int index, int preIndex){
        if(index == nums.length)
            return 0;

        int take = 0;
        if(preIndex == -1 || nums[index] > nums[preIndex]){
            take = 1 + dfs(nums,index+1,index);
        }

        int notTake = dfs(nums,index+1,preIndex);
        
        return Math.max(take,notTake);
    }
}

// [9,1,4,2,3]