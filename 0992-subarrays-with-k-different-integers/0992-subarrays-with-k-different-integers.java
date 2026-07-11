class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int cnt1 = countAtmostK(nums,n,k);
        int cnt2 = countAtmostK(nums,n,k-1);
        return cnt1-cnt2;
    }
    static int countAtmostK(int[] nums , int n , int k)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0 , cnt = 0; 
        for(int right = 0;right<n;right++)
        {
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            while(hm.size()>k)
            {
                hm.put(nums[left],hm.getOrDefault(nums[left],0)-1);
                if(hm.get(nums[left])==0) hm.remove(nums[left]);
                left++;
            }
            cnt += right-left+1;
        }
        return cnt;
    }
}