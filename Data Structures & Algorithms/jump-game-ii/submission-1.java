class Solution {
    public int jump(int[] nums) {
        return min_jump(nums,0);
    }

    public int min_jump(int[] nums, int index){
        if(index == nums.length - 1)
            return 0;
        
        if(index >= nums.length)
            return 1000000;

        int min = 1000000;
        for(int i=1;i<=nums[index];i++){
            int val = 1 + min_jump(nums,index+i);
            min = Math.min(min,val);
        }

        return min;
    }
}
