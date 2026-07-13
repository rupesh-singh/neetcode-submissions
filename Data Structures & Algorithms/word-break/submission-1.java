class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return dfs(wordDict,s,0,dp);
    }

    public boolean dfs(List<String> word, String s, int index, Boolean[] dp){
        if(index == s.length()){
            return true;
        }

        if(dp[index] != null){
            return dp[index];
        }
        
        for(int i=0;i<word.size();i++){
            String curr = s.substring(index,s.length());
            if(word.get(i).length() <= curr.length() && curr.startsWith(word.get(i)) && dfs(word,s,index + word.get(i).length(),dp)){
                return true;
            }
        }

        dp[index] = false;
        return false;
    }
}
