class Solution {
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i] = new ArrayList<>();
        
        }
        for(int[] e : edges)
        {
            adj[e[0]].add(e[1]);
        }
        return dfs(0,adj,baseTime);
    }
    static long dfs(int n , List<Integer>[] adj , int[] bt)
    {
        if(adj[n].isEmpty()) return bt[n];
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int c : adj[n])
        {
            long child = dfs(c,adj,bt);
            if(child < min) min = child;
            if(child > max) max = child;
            
        }
        return (long)2*max-min+bt[n];
    }
}