class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        return hm.get(nums[n/2]) == 1;
    }
}