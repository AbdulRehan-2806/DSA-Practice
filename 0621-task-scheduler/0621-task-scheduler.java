class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(char c : tasks)
            hm.put(c,hm.getOrDefault(c,0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int v : hm.values())
            pq.offer(v);
        int ans = 0;
        while (!pq.isEmpty()) {
            int sz = Math.min(n+1 , pq.size());
            ans += sz;
            func(pq,sz);
            if (!pq.isEmpty() && sz < n + 1)
                ans += n + 1 - sz;
        }  
        return ans;
    }
    static void func(PriorityQueue<Integer> pq , int sz)
    {
        List<Integer> al = new ArrayList<>();
        while(sz-->0)
        {
            al.add(pq.poll()-1);
        }
        for(int i : al)
        {
            if(i > 0) pq.offer(i);
        }
    }
}
