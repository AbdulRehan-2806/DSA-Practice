class Solution {
    public int[] frequencySort(int[] nums) {
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
            if(fa != fb) return Integer.compare(fa,fb);
            return Integer.compare(b,a);
        });
        for(int i=0;i<n;i++)
        {
            nums[i] = al.get(i);
        }
        return nums;
    }
}