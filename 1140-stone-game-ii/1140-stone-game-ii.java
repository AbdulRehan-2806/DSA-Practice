class Solution {
    private int n;
    private int[] suffix;
    private int[][][] dp;
    private int solve(int i, int m, int turn) {
        if (i == n) {
            return 0;
        }
        if (dp[i][m][turn] != -1) {
            return dp[i][m][turn];
        }
        int best = (turn == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m && i + x <= n; x++) {
            int nextM = Math.max(m, x);
            int current;
            if (turn == 0) {
                current = (suffix[i] - suffix[i + x])
                        + solve(i + x, nextM, 1);
                best = Math.max(best, current);

            } else {
                current = solve(i + x, nextM, 0);
                best = Math.min(best, current);
            }
        }
        return dp[i][m][turn] = best;
    }
    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        dp = new int[n][n + 1][2];
        for (int i = 0; i < n; i++) {
            for (int m = 0; m <= n; m++) {
                java.util.Arrays.fill(dp[i][m], -1);
            }
        }
        return solve(0, 1, 0);
    }
}