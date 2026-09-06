class Solution {
    static int[][] dp = new int[1002][1002];
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return func(s,t,n,m);
    }
    static int func(String s , String t , int n , int m)
    {
        if(m<=0) return 1;
        if(n<=0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(s.charAt(n-1) == t.charAt(m-1))
            dp[n][m] = func(s,t,n-1,m-1) + func(s,t,n-1,m);
        else dp[n][m] = func(s,t,n-1,m);
        return dp[n][m];
    }
}