class Solution {
    class Pair{
        int freq;
        int val;
        Pair(int freq , int val){
            this.freq = freq;
            this.val = val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num : nums)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a.freq,b.freq);
        });
        for(int key : hm.keySet())
        {
            Pair p = new Pair(hm.get(key) , key);
            pq.offer(p);
            if(pq.size() > k) pq.poll();
        }
        int i=0;
        while(pq.size()>0){
            Pair p = pq.poll();
            ans[i++] = p.val;
        }
        return ans;
    }
}