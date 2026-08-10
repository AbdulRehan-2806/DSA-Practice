class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        int[] pref = new int[n];
        pref[0] = stones[0];
        for(int i=1;i<n;i++) pref[i] = pref[i-1] + stones[i];
        int[] suff = new int[n];
        suff[n-1] = stones[n-1];
        for(int i=n-2;i>=0;i--)
        {
            suff[i] = suff[i+1] + stones[i];
        }
        return func(stones , n , 0, n-1, dp, pref , suff);
    }
    static int func(int[] arr ,int n, int i , int j , int[][]dp, int[] pref , int[] suff)
    {
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int left = (pref[j]-pref[i]) - func(arr,n,i+1,j,dp,pref,suff);
        int right = (suff[i]-suff[j]) - func(arr,n,i,j-1,dp,pref,suff);
        return dp[i][j] = Math.max(left,right);
    }
}