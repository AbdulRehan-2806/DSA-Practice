class Solution {
    public int[] validSequence(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int j = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            if (j < 0) {
                break;
            }
            if (word1.charAt(i) == word2.charAt(j)) {
                dp[j--] = i;
            }
        }
        int[] result = new int[n];
        boolean mismatch = true;
        j = 0;
        for (int i = 0; i < m; i++) {
            if (j == n) {
                break;
            }
            if (word1.charAt(i) == word2.charAt(j)) {
                result[j++] = i;
            } else if (mismatch && (j == n - 1 || dp[j + 1] > i)) {
                mismatch = false;
                result[j++] = i;
            }
        }
        return j == n ? result : new int[0];
    }
}