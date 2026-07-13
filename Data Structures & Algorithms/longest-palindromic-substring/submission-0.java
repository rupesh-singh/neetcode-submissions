class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String out = "";

        if(s.length() == 1)
            return s;

        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(pali(s.substring(i,j+1))){
                    if(max < j-i + 1){
                        max = j - i + 1;
                        out = s.substring(i,j + 1);
                    }
                }
            }
        }
        System.out.println(max);
        return out;

    }

    public boolean pali(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}