class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n : nums){
            total = total + n;
        }
        if(total % 2 != 0)
            return false;
        
        return check(0,total/2,nums);

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