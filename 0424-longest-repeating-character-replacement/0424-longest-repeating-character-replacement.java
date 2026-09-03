class Solution {
    public int characterReplacement(String s, int k) {
        // Longest substring after atmost k replacements
        int n = s.length();
        int ans = 0;
        int left = 0, maxfreq=0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int right=0;right<n;right++)
        {
            char c = s.charAt(right);
            hm.put(c,hm.getOrDefault(c,0)+1);
            maxfreq = Math.max(maxfreq , hm.get(c));
            if((right-left+1)-maxfreq > k){
                hm.put(s.charAt(left),hm.getOrDefault(s.charAt(left),0)-1);
                if(hm.get(s.charAt(left))<=0) hm.remove(s.charAt(left));
                left++;
            }
            ans = Math.max(ans , right-left+1);
        }
        return ans;
    }
}