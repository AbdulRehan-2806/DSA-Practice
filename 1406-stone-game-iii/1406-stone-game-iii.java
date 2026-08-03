class Solution {
    public String stoneGameIII(int[] arr) {
        int n = arr.length;
        int[] t = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            t[i] = Integer.MIN_VALUE;
            int sum = 0;
            for (int j = i; j < Math.min(n, i + 3); j++) {
                sum += arr[j];
                t[i] = Math.max(t[i], sum - t[j + 1]);
            }
        }
        if (t[0] > 0) return "Alice";
        if (t[0] < 0) return "Bob";
        return "Tie";
    }
}