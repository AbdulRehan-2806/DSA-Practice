class Solution {
    static int ans = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();
        for(int i=0;i<n;i++){
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }
        for(int[] con : connections)
        {
            int u = con[0];
            int v = con[1];
            forward.get(u).add(v);
            backward.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        ans = 0;
        dfs(0 , forward , backward, vis);
        return ans;
    }
    static void dfs(int src , List<List<Integer>> fw ,  List<List<Integer>> bw, boolean[] vis)
    {
        vis[src] = true;
        for(int it : fw.get(src))
        {
            if(!vis[it])
            {
                ans += 1;
                dfs(it , fw , bw , vis);
            }
        }
        for(int it : bw.get(src))
        {
            if(!vis[it])
            {
                dfs(it , fw , bw , vis);
            }
        }
    }
}