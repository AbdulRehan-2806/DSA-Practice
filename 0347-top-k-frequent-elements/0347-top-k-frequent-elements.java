class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        ArrayList<Integer> al = new ArrayList<>(hm.keySet());
        Collections.sort(al,(a,b)->{
            int fa = hm.get(a);
            int fb = hm.get(b);
            if(fa != fb)
                return Integer.compare(fb,fa);
            return Integer.compare(a,b);
        });
        int[] ans = new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i] = al.get(i);
        }
        return ans;
    }
}