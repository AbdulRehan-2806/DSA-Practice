class Solution {
    static Integer[][] dp;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1][n+1];
        return func(nums,0,n-1) >= 0;
        
    }
    static int func(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        if (dp[l][r] != null) return dp[l][r];
        int left = nums[l] - func(nums, l + 1, r);
        int right = nums[r] - func(nums, l, r - 1);
        return dp[l][r] = Math.max(left, right);
    }
}