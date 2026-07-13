class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int n = s.length();
        int max = 0;   
        HashSet<Character> hs = new HashSet<>();
        while(j<n){
            int len = 0;
            System.out.print("i: "+i+", j: "+j+" ");
            if(hs.contains(s.charAt(j))){
                hs.remove(s.charAt(i));
                i++;
            }
            else {
                len = j - i + 1;
                hs.add(s.charAt(j));
                j++;
            }

            if(len > max)
                max = len;

            System.out.println("max: "+max);
            
        }
        return max;

    }
}
