class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.length() < t.length())
            return "";
        
        int n = s.length(), m = t.length();
        int i=0,j=0, count=m, minval = Integer.MAX_VALUE;
        int start =0;
        int[] map = new int[128]; 

        for(char c: t.toCharArray()){
            map[c]++;
        }


        while(j<n){
            char ch = s.charAt(j++);
            
            if(map[ch] > 0){                
                count--;
                System.out.println(ch);
            }
            map[ch]--;

            while(count == 0){
                int temp = j - i ;
                if(minval > temp){
                    minval = temp;
                    start = i;
                }
                
                if(map[s.charAt(i)] == 0){
                    count++;
                }
                
                map[s.charAt(i)]++;
                i++;
            }

        }

        return  minval == Integer.MAX_VALUE ? "" : s.substring(start,start + minval);

    }
}