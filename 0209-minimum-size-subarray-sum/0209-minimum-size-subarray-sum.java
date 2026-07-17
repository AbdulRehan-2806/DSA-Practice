class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0 , right = 0;
        int sum = 0 , min = n+1;
        while(left < n)
        {
            sum += nums[right];
            while(sum >= target && left<n)
            {
                min = Math.min(min,right-left+1);
                sum -= nums[left];
                left++;
            }
            right++;
            if(right >= n) break;
        }
        return min == n+1 ? 0 : min;
    }
}