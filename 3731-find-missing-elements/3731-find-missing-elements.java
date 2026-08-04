class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> num = new HashSet<>();
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for(int n : nums)
        {
            num.add(n);
            if(n<min) min = n;
            if(n>max) max = n;
        }
        for(int k=min+1;k<max;k++)
        {
            if(! num.contains(k)) ans.add(k);
        }
        return ans;
    }
}