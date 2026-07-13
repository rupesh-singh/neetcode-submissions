class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1,word2,0,0);
    }

    public int dfs(String word1, String word2, int i, int j){
        if(i== word1.length())
            return word2.length() - j;
        if (j == word2.length())
            return word1.length() - i;
        
        int noMatch =0;
        if(word1.charAt(i) == word2.charAt(j))
        {
            return dfs(word1,word2,i+1,j+1);
        }
        else {
            int op1 = 1 + dfs(word1,word2,i,j+1); // insert
            int op2 = 1 + dfs(word1,word2,i+1,j); // delete
            int op3 = 1 + dfs(word1,word2,i+1,j+1); // replace

            noMatch = Math.min(Math.min(op1,op2),op3);
        }

        return noMatch;
    }
}
