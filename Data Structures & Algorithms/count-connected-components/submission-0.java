class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        int count =0;

        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                System.out.println(i);
                count++;
                bfs(adj,visited,i);
            }

        }
        return count;

    }

    public void bfs(List<List<Integer>> adj, HashSet<Integer> vis, int node){
 
        vis.add(node);
        for(int temp: adj.get(node)){
            if(!vis.contains(temp)){
                vis.add(temp);
                bfs(adj,vis,temp);
            }
        }
    }
}
