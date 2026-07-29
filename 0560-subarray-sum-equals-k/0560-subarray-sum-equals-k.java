class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        int sum = 0;
        for(int i=0;i<n;i++)
        {
            sum += nums[i];
            int rem = sum-k;
            if(hm.containsKey(rem))
            {
                cnt += hm.get(rem);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}