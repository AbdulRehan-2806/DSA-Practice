class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            int And = nums[i];
            int min = nums[i];
            cnt++;
            for(int j=i+1;j<n;j++)
            {
                min = Math.min(min , nums[j]);
                And = (And & nums[j]);
                if(And == min) cnt++;
            }
        }
        return cnt;
    }
}