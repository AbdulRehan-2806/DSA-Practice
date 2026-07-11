class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int e = edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] i : edges)
        {
            int u = i[0];
            int v = i[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            if(vis[i]) continue;
            List<Integer> comp = new ArrayList<>();
            dfs(i,adj,vis,comp);
            boolean flag = true;
            int k = comp.size();
            for(int node : comp)
            {
                if(adj.get(node).size() != k-1){
                    flag = false;
                    break;
                }
            }
            if(flag)
                cnt++;
        }
        return cnt;
    }
    static void dfs(int node , List<List<Integer>> adj , boolean[] vis, List<Integer> comp)
    {
        vis[node] = true;
        comp.add(node);
        for(int it : adj.get(node))
        {
            if(!vis[it])
                dfs(it,adj,vis,comp);
        }
    }
}