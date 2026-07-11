class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        String last = "";
        for(char c : s.toCharArray())
        {
            if(order.indexOf(c) == -1) last += c;
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        String res = "";
        for(int i=0;i<order.length();i++)
        {
            char c = order.charAt(i);
            if(! hm.containsKey(c)) continue;
            int freq = hm.get(c);
            while(freq>0)
            {
                res += c;
                freq--;
            }
        }
        return res+last;
    }
}