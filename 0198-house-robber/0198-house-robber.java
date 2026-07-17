class Solution {
    static int[] t = new int[102];
    public int rob(int[] nums) {
        Arrays.fill(t,-1);
        return helper(nums,nums.length-1);
    }
    static int helper(int[] nums , int idx)
    {
        if(idx == 0) return nums[idx];
        if(idx<0) return 0;
        if(t[idx] != -1) return t[idx];
        int pick = nums[idx] + helper(nums,idx-2);
        int notpick = 0 + helper(nums,idx-1);
        return t[idx] = Math.max(pick,notpick);
    }
}