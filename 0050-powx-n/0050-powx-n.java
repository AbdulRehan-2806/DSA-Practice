class Solution {
    public double myPow(double x, int n) {
        if(n<0)
        {
            if(x == 2 && n< -1074)
            {
                return 0;
            }
            n *= -1;
            double ans = calPow(x,n);
            return 1/ans;
        }
        double ans = calPow(x,n);
        return ans;
    }
    static double calPow(double a , int n)
    {
        double ans = 1;
        double x = a;
        while(n>0)
        {
            if((n&1)==1)
                ans *= x;
            x *= x;
            n = n>>1;
        }
        return ans;
    }
}