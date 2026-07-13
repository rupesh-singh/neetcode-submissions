class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                int val = hm.get(s.charAt(i)) + 1;
                hm.put(s.charAt(i),val);

                //System.out.println("Loop:" + hm);
            }
            else{
            hm.put(s.charAt(i),1);
            }
        }

//System.out.println("first:" + hm.toString());

        for(int i=0;i<t.length();i++){
            if(hm.containsKey(t.charAt(i))){
                int val = hm.get(t.charAt(i));
                if(val == 1){
                    hm.remove(t.charAt(i));
                }
                else{                
                hm.put(t.charAt(i),val-1);
                }
            }
            else{
                hm.put(t.charAt(i),1);
            }

            
        }
       // System.out.println(hm.toString());
        return hm.size()>0?false:true;
    }
}
