class Solution {
    private Integer[][] dp;
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n][2];
        int result = dpp(stoneValue,0,1); // 0 is index & 1/0 is turn for alice/bob
        if(result == 0)
            return "Tie";
        
        return result > 0 ? "Alice" : "Bob";

    }

    public int dpp(int[] stones, int index, int aliceTurn){
        if(index >= stones.length)
            return 0;
        if (dp[index][aliceTurn] != null) 
            return dp[index][aliceTurn];
        // the result should be optimial for alice/bob
        int res = (aliceTurn == 1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int score =0;
        for(int i =index;i<Math.min(index+3,stones.length);i++){
            if(aliceTurn == 1){
                score = score + stones[i];
                res = Math.max(res, score + dpp(stones,i+1,0));
            }
            else {
                score = score - stones[i];
                res = Math.min(res,score + dpp(stones,i+1,1));
            }
        }
        dp[index][aliceTurn] = res;
        return res;
    }


}