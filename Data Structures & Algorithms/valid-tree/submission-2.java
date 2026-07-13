class Node {
    int node;
    int parent;
    public Node(int node, int parent){
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: edges){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        Queue<Node> q = new LinkedList<>();
        int[] visited = new int[n];

        q.add(new Node(0,-1));
        visited[0] = 1;
        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int i : adj.get(curr.node)){
                if(visited[i] != 1){
                    visited[i] = 1;
                    q.add(new Node(i,curr.node));
                }
                else if(visited[i] == 1 && i != curr.parent){
                    return false;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(visited[i] != 1)
                return false;
        }

        return true;

    }
}
