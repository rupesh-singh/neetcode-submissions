class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] padded = new int[n+2];
        padded[0] = 1;
        padded[n+1] = 1;

        for(int i=1;i<=n;i++)
            padded[i] = nums[i-1];
        
        return coins(padded,1,n);
    }

    public int coins(int[] nums, int l, int r){
        if(l > r)
            return 0;
    
        int max = 0;
        for(int i = l; i<=r;i++){
            int curr = nums[i];
            int prev = nums[l-1];
            int next = nums[r+1];

            int count =  prev * curr * next + coins(nums,l,i-1) + coins(nums,i+1,r);
            max = Math.max(count,max);
        }

        return max;

    }
}
