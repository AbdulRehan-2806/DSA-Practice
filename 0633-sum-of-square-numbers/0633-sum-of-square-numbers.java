class Solution {
    public boolean judgeSquareSum(int c) {
        long lo = 0 , hi = (int)(Math.floor(Math.sqrt(c)));
        while(lo<=hi)
        {
            long mid = lo + (hi-lo)/2;
            long sum = ((lo*lo)+(hi*hi));
            if(sum == c) return true;
            else if(sum < c)
            {
                lo++;
            }
            else hi--;
        }
        return false;
    }
}