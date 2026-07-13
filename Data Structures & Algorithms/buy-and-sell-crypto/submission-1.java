class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, buy = prices[0];
        for (int i=1;i<prices.length;i++){
            int temp = prices[i]- buy;
            if(max<temp)
                max = temp;

            buy = Math.min(buy,prices[i]);
        }
        return max;

    }
}
