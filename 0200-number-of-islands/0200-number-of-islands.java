// DFS Approach. TC : O(nxm). SC : O(nxm)
class Solution {
    int[] dx = new int[]{0,-1,0,1};
    int[] dy = new int[]{-1,0,1,0};
    int n;
    int m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(!vis[i][j] && grid[i][j] == '1')
                {
                    cnt++;
                    dfs(grid , vis , i , j);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid , boolean[][] vis , int sr , int sc)
    {
        vis[sr][sc] = true;
        for(int i=0;i<4;i++)
        {
            int x = sr+dx[i];
            int y = sc+dy[i];
            if((x < 0 || x >= n) || (y < 0 || y>= m) || (grid[x][y] == '0' || vis[x][y])) continue;
            dfs(grid , vis , x , y);
        }
    }
}