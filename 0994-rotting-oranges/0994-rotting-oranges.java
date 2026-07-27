class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> rotten = new LinkedList<>();
        int total = 0 , count = 0 , days = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] != 0) total++;
                if(grid[i][j] == 2)
                {
                    rotten.add(new int[]{i,j});
                }
            }
        }
        while(!rotten.isEmpty())
        {
            int sz = rotten.size();
            count += sz;
            for(int i=0;i<sz;i++)
            {
                int[] dir = rotten.poll();
                int x = dir[0];
                int y = dir[1];
                for(int d=0;d<4;d++)
                {
                    int xi = x + dx[d];
                    int yj = y + dy[d];
                    if(xi<0 || yj<0 || xi>=n || yj>=m || grid[xi][yj] != 1) continue;
                    rotten.add(new int[]{xi,yj});
                    grid[xi][yj] = 2;
                }
            }
            if(rotten.size() != 0) days++;
        }
        if(total == count) return days;
        return -1;
    }
}