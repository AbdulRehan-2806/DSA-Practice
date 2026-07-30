class Solution {
    public int minimumPushes(String word) {
        int len = word.length();
        if(len <= 8) return len;
        int rem = len;
        int moves = 0;
        int p = 1;
        while(rem>0)
        {
            int mul = rem >= 8 ? 8 : rem;
            moves += (mul*p);
            rem -= 8;
            p++;
        }
        return moves;

    }
}