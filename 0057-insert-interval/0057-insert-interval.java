class Solution {
    public int[][] insert(int[][] intervals, int[] newI) {
        int n = intervals.length;
        List<int[]> al = new ArrayList<>();
        int i=0;
        while(i<n && intervals[i][1] < newI[0]){
            al.add(intervals[i]);
            i++;
        }
        while(i<n && intervals[i][0] <= newI[1])
        {
            newI[0] = Math.min(newI[0] , intervals[i][0]);
            newI[1] = Math.max(newI[1] , intervals[i][1]);
            i++;
        }
        al.add(newI);
        while(i<n)
        {
            al.add(intervals[i]);
            i++;
        }
        return al.toArray(new int[al.size()][]);
    }
}