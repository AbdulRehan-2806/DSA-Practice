class Solution {
    static int MOD = 1000000007;
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] pval = new long[n];
        long[] psum = new long[n];
        long[] pcnt = new long[n];
        long[] pow = new long[n+1];
        pow[0] = 1;
        for(int i=1;i<=n;i++)
            {
                pow[i] = (pow[i-1]*10)%MOD;
            }
        for(int i=0;i<n;i++)
            {
                int d = s.charAt(i)-'0';
                if(i>0){
                    pval[i] = pval[i-1];
                    psum[i] = psum[i-1];
                    pcnt[i] = pcnt[i-1];
                }
                    if(d!=0)
                    {
                        pval[i] = (pval[i]*10+d)%MOD;
                        psum[i] += d;
                        pcnt[i]++;
                    }
                }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++)
            {
                int l = queries[i][0];
                int r = queries[i][1];
                long sum = psum[r]-(l>0 ? psum[l-1] : 0);
                int cnt = (int)(pcnt[r]-(l>0 ? pcnt[l-1]:0));
                if(cnt == 0)
                {
                    ans[i]= 0;
                    continue;
                }
                long x = pval[r];
                if(l>0){
                    x = (x-pval[l-1]*pow[cnt]%MOD+MOD)%MOD;
                }
                ans[i] = (int)(x*(sum%MOD)%MOD);
            }
        return ans;
    }
}