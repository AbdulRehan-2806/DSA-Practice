class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0 , hi = n-1;
        int ans = Integer.MAX_VALUE;
        while(lo<=hi)
        {
            int m = lo+(hi-lo)/2;
            if(m-1 >=0) if(nums[m-1] > nums[m]) return nums[m];
            else if(m+1 < n) if(nums[m] > nums[m+1]) return nums[m+1];
            if(nums[m] <= nums[hi]) hi = m-1;
            else lo = m+1;
            ans = Math.min(ans,nums[m]);
        }
        return ans;
    }
}