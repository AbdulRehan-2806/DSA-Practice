class Solution {
    public int missingMultiple(int[] nums, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int num : nums)
        {
            al.add(num);
        }
        int max = Collections.max(al);
        int i=k;
        for(i=k;i<=max;i+=k)
        {
            if(!al.contains(i)) return i;
        }
        return i;
    }
}