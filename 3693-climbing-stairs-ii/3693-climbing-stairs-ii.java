class Solution {
    public int climbStairs(int n, int[] costs) {
        int m = costs.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return func(n , dp , 0 , 0 , costs);
    
    }
    static int func(int n , int[] dp , int st , int ed, int[] arr)
    {
        if(ed > n) return Integer.MAX_VALUE;
        if(ed == n) return 0;
        if(dp[ed] != -1) return dp[ed];
        int stepone = arr[ed] + calc(ed+1 , st) + func(n , dp , ed+1 , ed+1 , arr);
        int steptwo = Integer.MAX_VALUE;
        if(ed+2 <= n)
            steptwo = arr[ed+1] +calc(ed+2 , st) + func(n , dp , ed+2 , ed+2 , arr);
        int stepthree = Integer.MAX_VALUE;
        if(ed+3 <= n)
            stepthree = arr[ed+2] +calc(ed+3 , st) + func(n , dp , ed+3 , ed+3 , arr);
        return dp[ed] = Math.min(stepone,Math.min(steptwo,stepthree));
    }
    static int calc(int a , int b)
    {
        return (a-b)*(a-b);
    }
}