class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int mini = ans;
        Arrays.sort(nums);
        int i=0;
        while(i<n)
        {
            int j = i+1 , k = n-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum) < mini){
                    mini = Math.abs(target-sum);
                    ans = sum;
                }
                if(sum < target) j++;
                else k--;
            }
            i++;
        }
        return ans;
    }
}