class Solution {
    HashMap<Integer,Character> map = new HashMap<>();
    public int numDecodings(String s) {
        char c = 'A';
        for(int i=1;i<=26;i++){
            map.put(i,c);
            c = (char)((int)c + 1);
        }

        return dfs(s,0);
    }

    private int dfs(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;

        int res = dfs(s,i + 1);
        if (i < s.length() - 1) {
            if (map.containsKey(Integer.parseInt(s.substring(i,i+2)))) {
                res += dfs(s,i + 2);
            }
        }
        return res;
    }
}