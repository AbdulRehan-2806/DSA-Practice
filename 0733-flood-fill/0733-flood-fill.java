class Solution {
    public int[] dx = new int[]{0,-1,0,1};
    public int[] dy = new int[]{-1,0,1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int original = image[sr][sc];
        dfs(image , vis , original , sr , sc , color , n , m);
        return image;
    }
    public void dfs(int[][] image , boolean[][] vis , int org , int sr , int sc , int color ,int n , int m)
    {
        vis[sr][sc] = true;
        image[sr][sc] = color;
        for(int i=0;i<4;i++)
        {
            int ii = sr + dx[i];
            int jj = sc + dy[i];
            if((ii<0 || ii>=n)||(jj<0 || jj>=m)) continue;
            if(!vis[ii][jj] && (image[ii][jj] == org))
            {
                dfs(image ,vis ,org ,  ii , jj , color , n , m);
            }
        }
    }
}