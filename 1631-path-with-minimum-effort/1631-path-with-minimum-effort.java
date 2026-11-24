class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        pq.offer(new int[]{0,0,0});
        dist[0][0] = 0;
        while(!pq.isEmpty())
        {
            int[] d = pq.poll();
            int distFromSrc = d[0];
            int r = d[1];
            int c = d[2];
            for(int i=0;i<4;i++)
            {
                int x = r+dx[i];
                int y = c+dy[i];
                if(x<0 || x>=n || y<0 || y>=m) continue;
                int diff = Math.abs(heights[r][c]-heights[x][y]);
                int newDist = Math.max(distFromSrc,diff);
                if(newDist < dist[x][y])
                {
                    pq.offer(new int[]{newDist,x,y});
                    dist[x][y] = newDist;
                }
            }
        }
        return dist[n-1][m-1];
    }
}