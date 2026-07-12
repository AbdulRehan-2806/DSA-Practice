class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int n : arr)
        {
            pq.add(n);
        }
        if(pq.isEmpty()) return new int[]{};
        int rank = 1;
        int[] ans = new int[arr.length];
        int prev = pq.poll();
        hm.put(prev,rank);
        while(!pq.isEmpty())
        {
            int num = pq.poll();
            if(num != prev)
            {
                ++rank;
                hm.put(num,rank);
            }
            else{
                hm.put(num,rank);
            }
            prev = num;
        }
        for(int i=0;i<arr.length;i++)
        {
            int r = hm.get(arr[i]);
            ans[i] = r;
        }
        return ans;
    }
}