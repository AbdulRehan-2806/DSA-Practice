class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long totalsum = 0;
        int i = nums.length-1;
        while(i>=0 && k>0)
        {
            long ele = (long)nums[i];
            long prod = 1L*mul*ele;
            if(prod>ele)
                totalsum += prod;
            else totalsum += ele;
            mul--;
            k--;
            i--;
        }
        return totalsum;
    }
}