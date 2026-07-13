class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int leftmul = 1, rightmul = 1;
        for(int i=0;i<nums.length;i++){
            left[i] = leftmul;
            leftmul = leftmul * nums[i];            
        }

        System.out.println(Arrays.toString(left));

        for(int i=nums.length-1;i>=0;i--){
            left[i] = left[i]*rightmul;
            rightmul = rightmul * nums[i];
        }

        return left;
    }
}  
