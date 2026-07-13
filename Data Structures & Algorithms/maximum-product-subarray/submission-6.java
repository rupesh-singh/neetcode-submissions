class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix = 0, suffix = 0;
        int max_product = nums[0];

        for(int i=0;i<n;i++){
            prefix = nums[i] * (prefix == 0 ? 1 : prefix);
            suffix = nums[n - i - 1] * (suffix == 0 ? 1 : suffix);

            max_product = Math.max(max_product, Math.max(prefix,suffix));
        }

        return max_product;
    }
}
