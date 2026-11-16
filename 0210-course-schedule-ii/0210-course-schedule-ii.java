class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] ans = new int[n];
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites)
        {
            adj.get(arr[1]).add(arr[0]);
            indegree[arr[0]]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        int idx = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans[idx++] = node;
            List<Integer> nbr = adj.get(node);
            for(int it : nbr)
            {
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        if(idx == n)
            return ans;
        else return new int[]{};
    }
}