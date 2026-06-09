class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long max = 0 , min = Long.MAX_VALUE;
        for(int n : nums)
        {
            max = Math.max(max,n);
            min = Math.min(min,n);
        }
        return (long)(k*(max-min));
    }
}