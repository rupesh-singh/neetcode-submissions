class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = Integer.MIN_VALUE;
        int buy = prices[0];
        for(int i=1;i<n;i++){
            int temp = prices[i] - buy;
            max = Math.max(temp,max);
            buy = Math.min(buy,prices[i]);
        }
        return max < 0 ? 0 : max;
        
    }
}
