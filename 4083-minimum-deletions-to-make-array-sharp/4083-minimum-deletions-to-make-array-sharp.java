class Solution {
    public int minDeletions(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        if(n<=1) return 0;
        int prev = 0 , cur = 1;
        while(cur < n)
        {
            if((nums[prev]^nums[cur]) == 0)
            {
                cnt++;
                cur++;
            }
            else{
                prev = cur;
                cur++;
            }
        }
        return cnt;
    }
}