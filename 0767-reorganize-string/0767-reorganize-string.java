class Solution {
    class Pair {
        char val;
        int freq;
        Pair(char val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : s.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if(a.freq != b.freq) return Integer.compare(b.freq,a.freq);
            else return 0;
        });
        StringBuilder res = new StringBuilder("");
        for(char key : hm.keySet())
        {
            Pair p = new Pair(key,hm.get(key));
            pq.add(p);
        }
        while(pq.size()>1)
        {
            Pair p1 = pq.poll();
            Pair p2 = pq.poll();
            res.append(p1.val);
            res.append(p2.val);
            p1.freq--;
            p2.freq--;
            if(p1.freq>0) pq.offer(p1);
            if(p2.freq > 0) pq.offer(p2);
        }
        while(pq.isEmpty() == false)
        {
            if (!pq.isEmpty()) {

                Pair last = pq.poll();

                if (last.freq > 1)
                    return "";

                res.append(last.val);
            }
        }
        return res.toString();
    }
}