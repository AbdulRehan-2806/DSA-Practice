class Solution {
    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] d : connections)
        {
            int u = d[0];
            int v = d[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int components = 0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                components++;
                dfs(adj , vis , i , n);
            }
        }
        int totalNodes = n;
        int totalEdges = connections.length;
        if(totalNodes-1 > totalEdges) return -1;
        return components-1;
    }
    static void dfs(List<List<Integer>> adj , boolean[] vis , int src , int n)
    {
        vis[src] = true;
        for(int nbr : adj.get(src))
        {
            if(!vis[nbr])
            {
                dfs(adj , vis , nbr , n);
            }
        }
    }
}