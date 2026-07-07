class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        List<int[]> al = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
             if (a[0] == b[0]) return Integer.compare(b[1], a[1]); 
            return Integer.compare(a[0], b[0]);
        });
        int ans = 0;
        int maxEnd = 0;
        for (int[] in : intervals) {
            if (in[1] > maxEnd) {
                ans++;
                maxEnd = in[1];
            }
        }
        return ans;
    }
}