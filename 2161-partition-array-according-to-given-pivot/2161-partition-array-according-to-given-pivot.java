class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ele = 0, dup = 0;
        for(int num : nums){
            if(num == pivot) dup++;
            if(num>pivot) ele++;
        }
        int l = 0 , r = n-ele;
        int[] ans = new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i] == pivot) continue;
            if(nums[i]<pivot) ans[l++] = nums[i];
            else ans[r++] = nums[i];
        }
        while(dup>0)
        {
            ans[l++] = pivot;
            dup--;
        }
        return ans;
    }
}