class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        int[] ans = new int[m];
        int j = 0;
        long[] pref = new long[n];
        pref[0] = tasks[0];
        for(int i=1;i<n;i++) pref[i] = pref[i-1]+(long)tasks[i];
        long total = 0;
        for(int i=0;i<m;i++)
        {
            total += shifts[i];
            long idx = find(pref,total);
            if(idx == n-1){
                ans[i] = 0;
                total = 0;
            }
            else if(idx == -1){
                ans[i] = n;
            }
            else{
                ans[i] = n-(int)idx-1;
            }
        }
        return ans;
    }
    static long find(long[] arr , long k)
    {
        int lo = 0 , hi = arr.length-1;
        long ans = -1;
        while(lo<=hi)
        {
            int m = lo + (hi-lo)/2;
            if(arr[m] <= k){
                lo = m+1;
                ans = Math.max(ans,m);
            }
            else{
                hi = m-1;
            }
        }
        return ans;

    }
}