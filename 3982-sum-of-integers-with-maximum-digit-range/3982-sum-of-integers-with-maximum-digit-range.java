class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int max = 0;
        for(int i=0;i<n;i++)
            {
                arr[i] = range(nums[i]);
                max = Math.max(max,arr[i]);
            }
        int sum = 0;
        for(int i=0;i<n;i++)
            {
                if(arr[i] == max)
                {
                    sum += nums[i];
                }
            }
        return sum;
    }
    static int range(int n)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(n>0)
            {
                int rem = n%10;
                min = Math.min(min,rem);
                max = Math.max(max,rem);
                n /= 10;
            }
        return max-min;
    }
}