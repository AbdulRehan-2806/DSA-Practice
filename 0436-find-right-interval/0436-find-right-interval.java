class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        HashMap<List<Integer> , Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int[] arr = intervals[i];
            List<Integer> key = IntStream.of(arr).boxed().toList();
            hm.put(key , i);
        }
        Arrays.sort(intervals , (a,b)->{
            if(a[0] != b[0]) return Integer.compare(a[0],b[0]);
            else return 0;
        });
        int[] ans = new int[n];
        for(int i=0;i<n;i++)
        {
            int[] arr = intervals[i];
            List<Integer> key = IntStream.of(arr).boxed().toList();
            int pos = hm.get(key);
            int idx = find(intervals[i][1] , intervals , i , hm);
            ans[pos] = idx;
        }
        return ans;
    }
    static int find(int ed , int[][] arr , int idx , HashMap<List<Integer> , Integer> hm)
    {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int[] mini = new int[2];
        int lo = idx , hi = n-1;
        while(lo<=hi)
        {
            int mid = lo+(hi-lo)/2;
            if(arr[mid][0] >= ed)
            {
                if(arr[mid][0] < min)
                {
                    min = arr[mid][0];
                    mini = arr[mid];
                }
                hi = mid-1;
            }
            else lo = mid+1;
        }
        if(min == Integer.MAX_VALUE) return -1;
        List<Integer> key = IntStream.of(mini).boxed().toList();
        return hm.get(key);
    }
}