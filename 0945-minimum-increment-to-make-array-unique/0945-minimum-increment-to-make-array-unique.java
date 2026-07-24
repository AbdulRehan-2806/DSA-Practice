class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int cnt =0;
        HashSet<Integer> hs = new HashSet<>();
        hs.add(nums[0]);
        for(int i=1;i<n;i++)
        {
            if(hs.contains(nums[i]))
            {
                cnt += (Math.abs(nums[i]-nums[i-1]) + 1);
                nums[i] = nums[i-1]+1;
            }
            hs.add(nums[i]);
        }
        return cnt;
    }
}