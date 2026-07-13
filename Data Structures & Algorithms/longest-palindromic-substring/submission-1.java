class Solution {
    public String longestPalindrome(String s) {
        String output = "";
        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            String odd = isPalindrome(s,i,i);
            String even = isPalindrome(s,i,i+1);
            String temp = odd.length() > even.length() ? odd: even;

            if(output.length() < temp.length()){
                output = temp;
            }
        }

        return output;
    }

    public String isPalindrome(String s, int i, int j){
        String p = "";
        while(i>=0 && j < s.length()){
            if(s.charAt(i) == s.charAt(j)){
                p = s.substring(i,j+1);
                i--;
                j++;
            }
            else {
                break;
            }
        }
        return p;
    }
}
