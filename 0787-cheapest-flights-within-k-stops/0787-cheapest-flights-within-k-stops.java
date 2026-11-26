class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        Queue<int[]> pq = new LinkedList<>();
        Arrays.fill(dist , Integer.MAX_VALUE);
        for(int i=0;i<n;i++) adj.add(new ArrayList<int[]>());
        for(int[] d : flights)
        {
            adj.get(d[0]).add(new int[]{d[1], d[2]});
        }
        dist[src] = 0;
        pq.offer(new int[]{0,src,0});
        while(!pq.isEmpty())
        {
            int[] d = pq.poll();
            int stops = d[0];
            int node = d[1];
            int distFromSrc = d[2];
            if(stops >= k+1) continue;
            for(int[] nbrInfo : adj.get(node))
            {
                int nbr = nbrInfo[0];
                int wt = nbrInfo[1];
                int newDist = distFromSrc + wt;
                if(newDist < dist[nbr])
                {
                    dist[nbr] = newDist;
                    pq.offer(new int[]{stops+1 , nbr , newDist});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}