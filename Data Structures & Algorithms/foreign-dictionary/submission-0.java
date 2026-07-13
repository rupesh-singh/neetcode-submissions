class Solution {

    public int[] toposort(List<List<Integer>> adj, HashSet<Character> hs){
        int[] ans = new int[hs.size()];

        int[] indegree = new int[26];

        for(List<Integer> a: adj){
            for(int s: a){
                indegree[s]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<26;i++){
            if(indegree[i] == 0 && hs.contains((char)(i + 'a'))){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int i = q.peek();
            ans[count++] = i;
            q.remove();

            for(int a: adj.get(i)){
                if(hs.contains((char)(i + 'a'))){
                    indegree[a]--;
                    if(indegree[a] == 0){
                        q.add(a);
                    }
                }
            }
            
        }

        return count == hs.size() ? ans : new int[0];

    }

    public String foreignDictionary(String[] words) {
      List<List<Integer>> adj = new ArrayList<>();
      HashSet<Character> hs = new HashSet<>();
      int m = 0;
      while(m<26){
        adj.add(new ArrayList<Integer>());
        m++;
      }
      
      // nodes 
      for(String s: words){
        for(char c: s.toCharArray()){
            hs.add(c);
        }
      }

      int count = words.length;
      // create adjaceny list
      for(int i=0;i<count -1;i++){
        String s1 = words[i];
        String s2 = words[i+1];

        int n = Math.min(s1.length(),s2.length());
        int flag = 0;
        for(int j=0;j<n;j++){
            if(s1.charAt(j) != s2.charAt(j)){
                flag = 1;
                adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                break;
            }            
        }
        if(flag == 0 && s1.length() > s2.length()){
            return "";
        }        
      }

      int[] ans = toposort(adj, hs);
      String output = "";
      for(int a: ans){
        output = output + (char)(a + (int)'a');
      }

      return output;

    }
}
