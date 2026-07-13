class Solution {
    public int numDistinct(String s, String t) {
        return dfs(s,t,0,0);
    }

    public int dfs(String s, String t, int i, int j){
        if(j == t.length())
            return 1;
        
        if(i >= s.length())
            return 0;

        int count =0;
        if(s.charAt(i) == t.charAt(j)){
            count = count + dfs(s,t,i+1,j+1);
        }

        count = count + dfs(s,t,i+1,j);

        return count;

    }
}
