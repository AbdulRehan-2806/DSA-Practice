class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0 , ans = 0;
        for(int right = 0 ; right < n ; right++)
        {
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            while(hm.get(nums[right])>k)
            {
                hm.put(nums[left],hm.getOrDefault(nums[left],0)-1);
                if(hm.get(nums[left])==0) hm.remove(nums[left]);
                left++;
            }
            ans = Math.max(ans , right-left+1);
        }
        return ans;
    }
}