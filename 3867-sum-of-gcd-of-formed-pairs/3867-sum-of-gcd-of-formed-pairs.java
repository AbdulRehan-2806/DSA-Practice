class Solution {
    public long gcdSum(int[] nums) {
        long max = 0;
        long[] prefgcd = new long[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(max,nums[i]);
            prefgcd[i] = gcd((long)nums[i],max);
        }
        Arrays.sort(prefgcd);
        //for(long n : prefgcd) System.out.print(n+" ");
        long sum = 0;
        int i=0 , j = nums.length-1;
        while(i<j)
        {
            sum += gcd((long)prefgcd[i],(long)prefgcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    static long gcd(long a , long b)
    {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}