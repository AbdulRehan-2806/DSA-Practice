class Solution {
    static long MOD = 1000000007;
    public int sumDecoded(long[] nums) {
        long ans = 0;
        for(long num : nums)
            {
                int width = (int)(num%10);
                long d = num/10;
                int dig = String.valueOf(d).length();
                long pow = 1;
                for(int i=0;i<dig-width;i++)
                    {
                        pow *= 10;
                    }
                long x = d/pow;
                long y = d%pow;
                ans = (ans+func(x,y))%MOD;
            }
        return (int)ans;
    }
    static long func(long x , long y)
    {
        long res = 1;
        while(y>0)
            {
                if(y%2 == 1) res = (res*x)%MOD;
                x = (x*x)%MOD;
                y >>= 1;
            }
        return res;
    }
    
}