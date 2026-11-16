class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int[] arr : prerequisites)
        {
            adj.get(arr[1]).add(arr[0]);
        }
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            List<Integer> nbr = adj.get(i);
            for(int it : nbr) indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) if(indegree[i] == 0) q.offer(i);
        if(q.isEmpty() && numCourses > 0) return false;
        int cnt = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            cnt++;
            List<Integer> nbr = adj.get(node);
            for(int it : nbr)
            {
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        return cnt == numCourses;
    }
}