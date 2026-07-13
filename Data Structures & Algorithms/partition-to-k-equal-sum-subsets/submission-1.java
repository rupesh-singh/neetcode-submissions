class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i: nums){
            sum = sum + i;
        }

        if(sum % k != 0)
            return false;
        
        Arrays.sort(nums);
        reverse(nums);
        int[] sides = new int[k];
        return dfs(nums,sides,sum/k,k,0);
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++; j--;
        }
    }

    public boolean dfs(int[] m, int[] sides, int target, int k, int i){
        if (i == m.length) {
            return true;
        }

        for(int j=0;j<k;j++){
            if(sides[j] + m[i] > target)
                continue;
            sides[j] = sides[j] + m[i];
            if(dfs(m,sides,target,k,i+1))
                return true;
            sides[j] = sides[j] - m[i];

            if(sides[j] == 0)
                return false;
        }
        return false;
    }
}
