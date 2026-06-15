class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for(int i=1;i<n;i++)
        {
            int cur = nums[i];
            if(cur < 0)
            {
                int t = max;
                max = min;
                min = t;
            }
            max = Math.max(cur,cur*max);
            min = Math.min(cur,cur*min);
            ans = Math.max(ans , max);
        }
        return ans;
    }
}