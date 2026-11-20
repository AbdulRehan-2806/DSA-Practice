class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                if(grid[i][j] != 0) total++;
            }
        }
        int mins = 0 , cnt=0;
        while(!q.isEmpty())
        {
            int sz = q.size();
            cnt += sz;
            for(int j=0;j<sz;j++)
            {
                int[] d = q.poll();
                int sr = d[0];
                int sc = d[1];
                for(int i=0;i<4;i++)
                {
                    int x = sr+dx[i];
                    int y = sc+dy[i];
                    if(x<0 || x>=n || y<0 || y>=m || grid[x][y] != 1) continue;
                    q.offer(new int[]{x,y});
                    grid[x][y] = 2;
                }
            }
            if(!q.isEmpty()) mins++;
        }
        return total == cnt ? mins : -1;
    }
}