class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                nums[i] = nums[i]*(-1);
            }
        }
        Arrays.sort(nums);
        int i=0 , j = nums.length-1;
        long ans = 0;
        while(i<=j)
        {
            if(i==j)
            {
                ans += (nums[i]*nums[i]);
            }
            else if(nums[i] != nums[j])
                ans = ans + ((nums[j]*nums[j]) - (nums[i]*nums[i]));
            i++;
            j--;
        }
        return ans;
    }
}