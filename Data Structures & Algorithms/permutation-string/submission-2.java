class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length())
            return false;

     int[] s1Arr = new int[26];
     
    for(int i=0;i<s1.length();i++){
        s1Arr[s1.charAt(i) - 'a']++;
    }   
     int n = s2.length(), m = s1.length();
     int i=0,j=m-1;
        while(j<n){
            int[] s2Arr = new int[26];
            for(int k = i;k<=j;k++){
                s2Arr[s2.charAt(k) - 'a']++;
            }

            if(ifSame(s1Arr,s2Arr)){
                return true;
            }
            else{
                i++;
                j = i + m - 1 ;
            }

        }

        return false;
    }

    public boolean ifSame(int[] c, int[] s){
        for(int i=0;i<26;i++){
            if(c[i]!= s[i]){
                return false;
            }
        }
        return true;
    }
}
