class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j] = -1;
            }
        }
        return lcs(text1,text2,0,0, dp);

    }

    public int lcs(String text1, String text2, int i, int j, int[][] dp){

        if(i >= text1.length() || j >= text2.length())
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        System.out.println(text1.charAt(i)+","+text2.charAt(j));
        int take = 0;
        if(text1.charAt(i) == text2.charAt(j))
            take = 1 + lcs(text1,text2,i+1,j+1,dp);
        
        int Nottake1 = lcs(text1,text2,i,j+1,dp);
        int nottake2 = lcs(text1,text2,i+1,j,dp);

        dp[i][j] = Math.max(take,Math.max(Nottake1,nottake2));

        return dp[i][j];

    }
}


// def abd