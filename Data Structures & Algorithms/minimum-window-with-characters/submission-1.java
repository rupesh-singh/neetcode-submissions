class Solution {
    public String minWindow(String s, String t) {
        
        int n = s.length();
        int m = t.length();

        if(n < m)
            return "";
        
        HashMap<Character,Integer> target = new HashMap<>();
        
        for(char c: t.toCharArray()){
            target.put(c, target.getOrDefault(c,0) + 1 );
        }

        int i=0, j=m-1;
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while(j<n){
            HashMap<Character,Integer> win = new HashMap<>();
            
            for(int k=i;k<=j;k++){
                win.put(s.charAt(k), win.getOrDefault(s.charAt(k),0) + 1 );
            }
            if(checkifall(win,target)){
                int count = j-i+1;
                if(res > count){
                    res = count;
                    start = i;
                    end = j;
                }
                i++;
            }
            else{
                j++;
            }
        System.out.println("count: "+res+" start: "+start+" end:"+end);                
        }

        return res == Integer.MAX_VALUE ? "" : s.substring(start,end+1);


    }

    public boolean checkifall(HashMap<Character,Integer> win, HashMap<Character,Integer> target){
        for (Map.Entry<Character,Integer> mapElement : target.entrySet()) {
            Character key = mapElement.getKey();
            int val = mapElement.getValue();

            if(!win.containsKey(key) || (win.containsKey(key) && win.get(key) < val))
                return false;
        }

        return true;

    }

}

