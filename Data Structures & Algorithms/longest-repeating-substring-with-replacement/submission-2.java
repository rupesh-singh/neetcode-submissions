class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, j=0, n = s.length();
        int[] map = new int[26];
        int max =0;
        int res=0;
        while(j < n){
            char c = s.charAt(j);
            map[c-'A']++;
            max = Math.max(max,map[c-'A']);

            while((j - i + 1) - max > k){
                map[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
