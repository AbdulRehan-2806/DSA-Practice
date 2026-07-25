class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length+1];
        return func(0,nums,nums.length,false,dp);
    }
    static boolean func(int idx , int[] nums , int n , boolean ans,Boolean[] dp)
    {
        if(dp[idx]!=null) return dp[idx];
        if(idx == n-1) return dp[idx]=true;
        if(nums[idx] == 0 && idx<n-1) return dp[idx]=false;
        if(nums[idx] == 0) return dp[idx]=true;
        for(int i=1;i<=nums[idx];i++) ans = ans || func(idx+i,nums,n,ans,dp);
        return dp[idx]=ans; 
    }
}