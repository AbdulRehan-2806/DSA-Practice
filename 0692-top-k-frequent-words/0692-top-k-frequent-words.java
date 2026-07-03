class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String,Integer> hm = new HashMap<>();
        for(String s : words)
        {
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        List<String> al = new ArrayList<>(hm.keySet());
        Collections.sort(al,(a,b)->{
            int fa = hm.get(a);
            int fb = hm.get(b);
            if(fa != fb) return Integer.compare(fb,fa);
            return a.compareTo(b);
        });
        return al.subList(0,k);
    }
}