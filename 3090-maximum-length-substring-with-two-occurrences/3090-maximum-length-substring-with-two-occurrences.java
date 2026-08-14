class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        int left = 0;
        for(int right = 0 ; right<n; right++)
        {
            char c = s.charAt(right);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(hm.containsKey(c) && hm.get(c)>2)
            {
                char ch = s.charAt(left);
                hm.put(ch,hm.get(ch)-1);
                if(hm.get(ch)<=0) hm.remove(ch);
                left++;  
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}