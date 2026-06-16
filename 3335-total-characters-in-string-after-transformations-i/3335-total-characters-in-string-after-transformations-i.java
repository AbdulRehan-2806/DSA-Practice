class Solution {
    static final int M = 1000000007;
    public int lengthAfterTransformations(String s, int t) {
        long[] c = new long[26];
        for (char x : s.toCharArray()) c[x - 'a']++;
        long l = s.length();
        for (int i = 0; i < t; i++) {
            long[] n = new long[26];
            for (int j = 0; j < 25; j++) n[j + 1] = c[j];
            n[0] = (n[0] + c[25]) % M;
            n[1] = (n[1] + c[25]) % M;
            l = (l + c[25]) % M;
            c = n;
        }
        return (int) l;
    }
}