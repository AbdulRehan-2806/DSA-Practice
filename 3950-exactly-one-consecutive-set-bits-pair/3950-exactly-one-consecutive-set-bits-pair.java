class Solution {
    public boolean consecutiveSetBits(int n) {
        if(n<=1) return false;
        boolean pair = false;
        int prev = (n&1);
        n>>=1;
        while(n>0)
        {
            int bit = (n&1);
            if(bit == 1 && prev == 1){
                if(pair) return false;
                pair = true;
            }
            prev = bit;
            n>>=1;
        }
        return pair;
    }
}