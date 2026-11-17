// Topological Sort using DFS
class Solution {
    static Deque<Integer> dq;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] ans = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites)
        {
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] vis = new boolean[n];
        boolean[] curpath = new boolean[n];
        dq = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                // if cycle is formed we cannot schedule the courses
                if(dfs(i,curpath,vis,adj)) return new int[]{};
            }
        }
        int idx = 0;
        for(int x : dq)
        {
            ans[idx++] = x;
        }
        return ans;
    }
    // check wether cycle is formed.
    static boolean dfs(int src , boolean[] curpath , boolean[] vis , List<List<Integer>> adj)
    {
        curpath[src] = true;
        vis[src] = true;
        for(int nbr : adj.get(src))
        {
            if(!vis[nbr])
            {
                if(dfs(nbr , curpath , vis , adj)) return true;
            }
            else{
                if(curpath[nbr])
                {
                    return true;
                }
            }
        }
        curpath[src] = false;
        dq.offerFirst(src);
        return false;
    }
}