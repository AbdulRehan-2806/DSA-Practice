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
        int[] state = new int[n];
        
        for(int i=0;i<n;i++)
        {
            if(dfs(adj , i , state)) ans.add(i);
        }
        return ans;
    }
    static boolean dfs(List<List<Integer>> adj , int src , int[] state)
    {
        if(state[src] == 1) return false;
        if(state[src] == 2) return true;
        state[src] = 1;
        for(int it : adj.get(src))
        {
            if(!dfs(adj ,it,state)) return false;
        }
        state[src] = 2;
        return true;
    }
}