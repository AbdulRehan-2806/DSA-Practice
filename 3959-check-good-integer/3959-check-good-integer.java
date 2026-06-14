class Solution {
    public boolean checkGoodInteger(int n) {
        int dig = 0 , sq = 0;
        while(n>0)
        {
            int rem = n%10;
            dig += rem;
            sq += rem*rem;
            n /= 10;
        }
        return sq-dig >= 50;
    }
}