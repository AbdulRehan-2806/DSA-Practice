class Solution {
    public long maxPairStrength(int[] nums) {
        long max = 0;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                long res = compute(nums[i],nums[j]);
                max = Math.max(max,res);
            }
        }
        return max;
    }
    static long compute(int n , int m)
    {
        long prod = (1L*n*m);
        long g = gcd(n,m);
        g = g*g;
        return prod/g;
    }
    static long gcd(long a , long b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}