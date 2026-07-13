class Solution {
    public int maxProfit(int[] prices) {
        return profit(prices,0,-1);
    }

    public int profit(int[] prices, int curr, int prev){
        if(curr >= prices.length)
            return 0;
        
        int left = 0;
        int right =0;
        if(prev != -1){
            left = profit(prices,curr+2,-1) + prices[curr] - prices[prev];
            right = profit(prices,curr+1,prev);
        }
        else {
            left = profit(prices,curr+1,curr);
            right = profit(prices,curr+1,-1);
        }

        return Math.max(left,right);
    }
}
