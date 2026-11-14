class Solution {
    static int longest = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int[] curpath = new int[n];
        longest = -1;
        for(int i=0;i<n;i++)
        {
            if(!vis[i]) dfs(0 , i , edges , vis , curpath);
        }
        return longest;
    }
    static void dfs(int cyclelen , int src , int[] adj , boolean[] vis , int[] curpath)
    {
        cyclelen++;
        curpath[src] = cyclelen;
        vis[src] = true;
        int it = adj[src];
        if(it != -1)
        {
            if(!vis[it]) dfs(cyclelen , it , adj , vis , curpath);
            else if(curpath[it] != 0)
            {
                int len = curpath[src] - curpath[it] + 1;
                longest = Math.max(longest , len);
            }
        }
        curpath[src] = 0;
    }
}