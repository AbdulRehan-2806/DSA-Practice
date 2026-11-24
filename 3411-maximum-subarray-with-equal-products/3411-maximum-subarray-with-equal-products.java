class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i=0;i<n;i++)
        {
            long prod = 1;
            for(int j=i;j<n;j++)
            {
                prod *= nums[j];
                long lcm = lcmArray(nums , i , j);
                long gcd = gcdArray(nums , i , j);
                if(prod == (lcm*gcd)) max = Math.max(max , j-i+1);
            }
        }
        return max;
    }
    public long lcm(long a, long b) {
        return (a / gcd((int)a, (int)b)) * b;
    }
    public long lcmArray(int[] arr , int i , int j) {
        long ans = arr[i];
        for(i = i; i <= j; i++) {
            ans = (ans / gcd((int)ans, arr[i])) * arr[i];
        }
        return ans;
    }
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int gcdArray(int[] arr , int i , int j) {
        int ans = arr[i];
        for(i = i; i <= j; i++) {
            ans = gcd(ans, arr[i]);
        }
        return ans;
    }
}