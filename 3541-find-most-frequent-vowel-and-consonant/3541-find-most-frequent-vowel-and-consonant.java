class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> vow = new HashMap<>();
        HashMap<Character,Integer> cnst = new HashMap<>();
        int maxv = 0 , maxc = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
               vow.put(ch,vow.getOrDefault(ch,0)+1);
               maxv = Math.max(maxv,vow.get(ch));
            }
            else{
                cnst.put(ch,cnst.getOrDefault(ch,0)+1);
                maxc = Math.max(maxc,cnst.get(ch));
            }
        }
        return maxv + maxc;
    }
}