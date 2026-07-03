class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String,Integer> hm = new HashMap<>();
        List<String> al = new ArrayList<>();
        for(String s : words)
        {
            al.add(s);
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        Collections.sort(al,(a,b)->{
            int fa = hm.get(a);
            int fb = hm.get(b);
            if(fa != fb) return Integer.compare(fb,fa);
            return a.compareTo(b);
        });
        List<String> ans = new ArrayList<>();
        ans.add(al.get(0));
        int i=1,j=1;
        while(j<k)
        {
            while(ans.get(j-1).equals(al.get(i))) i++;
            ans.add(al.get(i));
            j++;
        }
        return ans;
    }
}