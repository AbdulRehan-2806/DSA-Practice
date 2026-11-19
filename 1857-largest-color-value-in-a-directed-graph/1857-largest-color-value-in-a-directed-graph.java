class Solution {
    static HashMap<Character,Integer> hm;
    static int max;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        int[][] cnt = new int[n][26];
        int max =0;
        int allocated = 0;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : edges)
        {
            adj.get(arr[0]).add(arr[1]);
            indegree[arr[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==0) q.offer(i);
        while(!q.isEmpty())
        {
            int node = q.poll();
            allocated++;
            cnt[node][colors.charAt(node)-'a']++;
            max = Math.max(max , cnt[node][colors.charAt(node)-'a']);
            for(int nbr : adj.get(node))
            {
                indegree[nbr]--;
                if(indegree[nbr] == 0) q.offer(nbr);
                for(int j=0;j<26;j++)
                {
                    cnt[nbr][j] = Math.max(cnt[nbr][j] , cnt[node][j]);
                }
            }
        }
        return allocated == n ? max : -1;
    }
}