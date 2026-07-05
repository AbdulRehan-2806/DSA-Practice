class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] pm = new int[n];
        int[] sm = new int[n];
        pm[0] = nums[0];
        for(int i=1;i<n;i++)
        {
            pm[i] = Math.max(pm[i-1],nums[i]);
        }
        sm[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            sm[i] = Math.max(sm[i+1],nums[i]);
        }
        int i=0,j=k;
        while(j<n)
        {
            ans = Math.max(ans,pm[i]+sm[j]);
            i++;
            j++;
        }
        return ans;
    }
}