class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for(int i=0; i<n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int c = 0;;
        for(int i = 0; i<n; i++){
            if(visited.contains(i)) continue;
            c++;
            dfs(i, visited,adj);
        }
        return c;
    }

    public static void dfs(int node, Set<Integer> visited, List<Integer>[] adj){
        if(visited.contains(node)) return;
        visited.add(node);
        for(int node1 : adj[node]){
            dfs(node1,visited,adj);
        }
    }
}
