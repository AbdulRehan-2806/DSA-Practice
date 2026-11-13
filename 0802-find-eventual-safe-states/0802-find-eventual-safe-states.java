class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            for(int num : graph[i])
            {
                adj.get(i).add(num);
            }
        }
        boolean[] vis = new boolean[n];
        boolean[] curpath = new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            boolean res = dfs(adj , i , vis , curpath);
        }
        for(int i=0;i<n;i++){
            if(!curpath[i]) ans.add(i);
        }
        return ans;
    }
    static boolean dfs(List<List<Integer>> adj , int src ,boolean[] vis , boolean[] curpath)
    {
        vis[src] = true;
        curpath[src] = true;
        for(int it : adj.get(src))
        {
            if(vis[it] && curpath[it])
            {
                return true;
            }
            else if(!vis[it]){
                if(dfs(adj,it,vis,curpath)) return true;
            }
        }
        curpath[src] = false;
        return false;
    }
}