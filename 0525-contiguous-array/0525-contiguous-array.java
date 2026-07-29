class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++) if(nums[i] == 0) nums[i] = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int sum = 0 , ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            if(hm.containsKey(sum))
            {
                ans = Math.max(ans,i-hm.get(sum));
            }
            else hm.put(sum,i);
        }
        return ans;
    }
}