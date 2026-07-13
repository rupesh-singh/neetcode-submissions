class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for(int i=s.length() -1;i>=0;i--){
            String curr = s.substring(i,s.length());
            for(int j=0;j<wordDict.size();j++){
                if(wordDict.get(j).length() <= curr.length() && curr.startsWith(wordDict.get(j))){
                    dp[i] = dp[i+wordDict.get(j).length()];   
                }
                if(dp[i])
                    break;
            }
        }
        return dp[0];
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
