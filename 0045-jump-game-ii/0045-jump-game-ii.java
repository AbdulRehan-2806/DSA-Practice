class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return func(0,nums,(int)1e9,dp);
    }
    static int func(int idx , int[] nums,int ans,int[] dp)
    {
        if(idx>=nums.length) return (int)1e9;
        if(idx == nums.length-1) return 0;
        if(dp[idx]!=-1) return  dp[idx];
        for(int i=1;i<=nums[idx];i++)
        {
           ans = Math.min(ans,1+func(idx+i,nums,ans,dp));
        }
        return dp[idx]=ans;
    }
}