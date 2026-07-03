class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : nums)
        {
            al.add(num);
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        Collections.sort(al,(a,b)->{
            int fa = hm.get(a);
            int fb = hm.get(b);
            if(fa != fb)
                return Integer.compare(fb,fa);
            return Integer.compare(a,b);
        });
        int[] ans = new int[k];
        ans[0] = al.get(0);
        int i=1,j=1;
        while(j<k)
        {
            while(ans[j-1] == al.get(i)) i++;
            ans[j++] = al.get(i);
        }
        return ans;
    }
}