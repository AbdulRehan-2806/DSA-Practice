class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);
        int max = 0;
        for(int num : hs)
        {
            int n = num;
            if(!hs.contains(n-1))
            {
                int cnt = 0;
                while(hs.contains(n))
                {
                    n++;
                    cnt++;
                }
                max = Math.max(max , cnt);
            }
        }
        return max;
    }
}