class Solution {
    public boolean sumGame(String num) {
        int n = num.length(), left = 0, right = 0, lsum = 0, rsum = 0;

        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') lsum++;
            else left += num.charAt(i) - '0';

            if (num.charAt(n / 2 + i) == '?') rsum++;
            else right += num.charAt(n / 2 + i) - '0';
        }

        return (lsum + rsum) % 2 == 1 || left - right != (rsum - lsum) * 9 / 2;
    }
}