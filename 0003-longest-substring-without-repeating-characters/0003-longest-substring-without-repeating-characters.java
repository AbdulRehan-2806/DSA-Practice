class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0 , right = 0;
        HashMap<Character , Integer> hm = new HashMap<>();
        int max = 0;
        while(right<s.length())
        {
            if(hm.containsKey(s.charAt(right)))
            {
                if(hm.get(s.charAt(right))>=left)
                    left = hm.get(s.charAt(right))+1;
            }
            max = Math.max(max,right-left+1);
            hm.put(s.charAt(right),right);
            right++;
        }
        return max;
    }
}