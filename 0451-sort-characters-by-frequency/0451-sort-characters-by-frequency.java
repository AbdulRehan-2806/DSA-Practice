class Solution {
    public String frequencySort(String s) {
       int n = s.length();
       HashMap<Character,Integer> hm = new HashMap<>();
       ArrayList<Character> al = new ArrayList<>();
       for(char c : s.toCharArray())
       {
            al.add(c);
            hm.put(c,hm.getOrDefault(c,0)+1);
       }
       Collections.sort(al,(a,b)->{
            int fa = hm.get(a);
            int fb = hm.get(b);
            if(fa!=fb) return Integer.compare(fb,fa);
            return Character.compare(a,b);
       });
       String ans = "";
       for(char c : al) ans += c;
       return ans;
    }
}