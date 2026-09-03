class Solution {
    public int totalFruit(int[] fruits) {
        // Longest subarray with atmost 2 distinct character
        int n = fruits.length;
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0;
        int k = 2;
        for(int right=0;right<n;right++)
        {
            int ele = fruits[right];
            hm.put(ele,hm.getOrDefault(ele,0)+1);
            while(left<n && hm.size()>2)
            {
                int freq = hm.get(fruits[left]);
                if(freq==1) hm.remove(fruits[left]);
                else hm.put(fruits[left],freq-1);
                left++;
            }
            ans = Math.max(ans , right-left+1);
        }
        return ans;
    }
}