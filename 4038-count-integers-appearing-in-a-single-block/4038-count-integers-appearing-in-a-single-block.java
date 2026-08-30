class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
            {
                if(i==0 || nums[i] != nums[i-1])
                        hm.put(nums[i] , hm.getOrDefault(nums[i],0)+1);
            }
        int ans = 0;
        for(int val : hm.values())
            {
                if(val == 1) ans++;
            }
        return ans;
    }
}