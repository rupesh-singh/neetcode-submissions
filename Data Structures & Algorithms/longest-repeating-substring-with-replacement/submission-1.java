class Solution {
    public int characterReplacement(String s, int k) {
        int[] charArr = new int[26];
        int i = 0, j = 0, n = s.length();
        int result =0;
        boolean add = true;
        while(j < n ){
            if(add)
                charArr[s.charAt(j) - 'A' ]++;
            int max = 0;
            for(int m =0;m<26;m++){
                if(charArr[m]>max)
                    max = charArr[m];
            }
            System.out.print("i: "+i+" j: "+j);
            if(((j-i +1) - max) <= k){
                if(result < (j-i + 1)){
                    result = j - i + 1;
                }
                j++;
                add= true;
                System.out.print(" res: "+result+"max: "+max);
            }
            else{
                charArr[s.charAt(i) - 'A']--;
                i++;
                add = false;

            }
            System.out.println();
            

        }

        return result;
    }
}
