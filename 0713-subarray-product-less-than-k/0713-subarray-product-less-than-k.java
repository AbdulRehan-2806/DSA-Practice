class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        int left = 0;
        int prod = 1;
        for(int right = 0;right < n ; right++)
        {
            prod *= nums[right];
            while(left < n && prod >= k){
                prod /= nums[left];
                left++;
            }
            cnt += (right-left+1);
        }
        return cnt;
    }
}