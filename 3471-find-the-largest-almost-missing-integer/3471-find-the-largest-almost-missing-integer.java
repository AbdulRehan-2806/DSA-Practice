class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int max = -1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<=(n-k);i++)
        {
            int cnt = 0;
            int j=i;
            while(cnt < k && j < n)
            {
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
                j++;
                cnt++;
            }
        }
        for(int key : hm.keySet())
        {
            int val = hm.get(key);
            if(n == k){
                max = Math.max(max,key);
            }
            if(val == 1) max = Math.max(max,key);
        }
        return max;
    }
}