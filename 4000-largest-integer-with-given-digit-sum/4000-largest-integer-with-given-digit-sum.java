class Solution {
    public int largestInteger(int n, int s) {
        int digits = n;
        int num = 0;
        while(digits>0)
        {
            num = num * 10 + 9;
            digits--;
        }
        while(num>=0)
        {
            if(sum(num) == s) return num;
            num--;
        }
        return -1;
    }
    static int sum(int n)
    {
        int s = 0;
        while(n>0)
        {
            int rem = n%10;
            s += rem;
            n /= 10;
        }
        return s;
    }
}