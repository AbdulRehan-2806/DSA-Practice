class Solution {
    public long getSum(int[] nums) {
        int n = nums.length;
        long[] pf = new long[n+1];
        for(int i=0;i<n;i++)
            {
                pf[i+1] = pf[i]+nums[i];
            }
        int[] t = new int[2*n+1];
        for(int i=0;i<n;i++)
            {
                t[2*i] = -1;
                t[2*i+1] = nums[i];
            }
        t[2*n] = -1;
        int m = t.length;
        int[] p = new int[m];
        int c = 0 , r= 0;
        long max = 0;
        for(int i=0;i<m;i++)
            {
                int mir = 2*c-i;
                if(i<r) p[i] = Math.min(r-i,p[mir]);
                while((i-1-p[i] >= 0 && i+1+p[i]<m) && (t[i-1-p[i]] == t[i+1+p[i]]))
                        p[i]++;
                if(i+p[i]>r){
                    c=i;
                    r=i+p[i];
                }
                int st = (i-p[i])/2;
                int ed = (i+p[i])/2 -1;
                if(st<=ed){
                    long cur = pf[ed+1]-pf[st];
                    max = Math.max(max,cur);
                }
            }
        return max;
    }
}