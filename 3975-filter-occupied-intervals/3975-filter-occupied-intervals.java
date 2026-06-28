class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] arr, int st, int ed) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = arr[0];
        // Merge intervals
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] <= prev[1] + 1) {
                prev[1] = Math.max(prev[1], arr[i][1]);
            } else {
                merged.add(new int[]{prev[0], prev[1]});
                prev = arr[i];
            }
        }
        merged.add(new int[]{prev[0], prev[1]});
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] in : merged) {
            int l = in[0];
            int r = in[1];
            if (r < st || l > ed) {
                ans.add(Arrays.asList(l, r));
            }
            else if (st <= l && r <= ed) {
                continue;
            }
            else if (l < st && r > ed) {
                ans.add(Arrays.asList(l, st - 1));
                ans.add(Arrays.asList(ed + 1, r));
            }
            else if (l < st) {
                ans.add(Arrays.asList(l, st - 1));
            }
            else {
                ans.add(Arrays.asList(ed + 1, r));
            }
        }
        return ans;
    }
}