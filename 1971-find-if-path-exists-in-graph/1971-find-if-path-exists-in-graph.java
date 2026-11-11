class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        return dfs(source , destination , graph , vis);
    }
    static boolean dfs(int src , int dest , List<List<Integer>> graph , boolean[] vis)
    {
        if(src == dest) return true;
        vis[src] = true;
        for(int it : graph.get(src))
        {
            if(!vis[it])
            {
                if(dfs(it,dest,graph,vis)) return true;
            }
        }
        return false;
    }
}