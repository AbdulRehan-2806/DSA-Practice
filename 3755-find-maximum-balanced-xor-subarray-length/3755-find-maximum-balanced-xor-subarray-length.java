class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("0#0",-1);
        int diff = 0 , max = 0 , xor=0;
        for(int i=0;i<nums.length;i++)
            {
                xor ^= nums[i];
                if(nums[i]%2 == 0) diff++;
                else diff--;
                String k = xor + "#" + diff;
                if(hm.containsKey(k))
                {
                    max = Math.max(max,i-hm.get(k));
                }
                else hm.put(k,i);
            }
        return max;
    }
}