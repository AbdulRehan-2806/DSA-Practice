class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int cnt = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int even = 0 , odd = 0;
            for(int j=i;j<n;j++)
            {
                if(nums[j]%2 == 0) even++;
                else odd++;
                int E = even*b;
                int O = odd*a;
                if(E <= O) cnt++;
            }
        }
        return cnt;
    }
}