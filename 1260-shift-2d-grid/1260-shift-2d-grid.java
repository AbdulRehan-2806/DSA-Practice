class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        k %= (m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newCol = (j + k) % n;
                int newRow = (i + (j + k) / n) % m;
                ans[newRow][newCol] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : ans) {
            List<Integer> list = new ArrayList<>();
            for (int x : row) list.add(x);
            res.add(list);
        }
        return res;
    }
}