class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;
        for(int num : nums) total += num;
        int sum = total - x;
        if (sum < 0) return -1;
        if (sum == 0) return n;
        int len = longestSubarray(nums , sum);
        if(len == -1) return -1;
        return n-len;
    }
    static int longestSubarray(int[] nums , int k)
    {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int sum = 0 , max = -1;
        for(int i=0;i<n;i++)
        {
            sum += nums[i];
            if(sum == k) max = i+1;
            if(hm.containsKey(sum-k))
                max = Math.max(max , i-hm.get(sum-k));
            if(!hm.containsKey(sum))
                hm.put(sum , i);
        }
        return max;
    }
}