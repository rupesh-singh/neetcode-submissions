class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i=0, j=0;
        int max =0;
        HashSet<Character> hs = new HashSet<>();
        while(j<n){
            char c = s.charAt(j);
            if(hs.contains(c)){
                hs.remove(s.charAt(i));
                i++;
                continue;
            }
            hs.add(s.charAt(j));
            max = Math.max(max, j - i +1);
            j++;
        }
        return max;
    }
}
