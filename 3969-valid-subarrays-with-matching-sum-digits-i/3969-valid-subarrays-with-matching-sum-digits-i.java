class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int cnt = 0;
        for(int i=0;i<n;i++)
        {
            long sum = nums[i];
            if(isFirstDigit(sum,x) && isLastDigit(sum,x)) cnt+=1;
            for(int j=i+1;j<n;j++)
            {
                sum += nums[j];
                if(isFirstDigit(sum,x) && isLastDigit(sum,x)) cnt+=1;
            }
        }
        return cnt;
    }
    static boolean isLastDigit(long n , long x)
    {
        return (n%10) == x;
    }
    static boolean isFirstDigit(long n , long x)
    {
        while((n/10) >= 1) n/=10;
        return ((n%10) == x);
    }
}