class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums) hs.add(i);
        int len = 1 , maxLen = 1;
        int min = nums[0] , prev = nums[0];
        int sum = nums[0];
        for(int i=1;i<n;i++)
        {
            sum += nums[i];
            len++;
            if(prev+1 == nums[i])
            {
                if(len >= maxLen)
                {
                    min = sum;
                    maxLen = len;
                }
            }
            else break;
            prev = nums[i];
        }
        while(hs.contains(min)) min++;
        return min;
    }
}