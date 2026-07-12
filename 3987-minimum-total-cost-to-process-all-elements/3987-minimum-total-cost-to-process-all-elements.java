class Solution {
    static int MOD = (int)1e9+7;
    public int minimumCost(int[] nums, int k) {
        int n = nums.length;
        long cost = 0;
        long cnt = 0;
        long org = k;
        for(int i=0;i<n;i++)
        {
            if((k-nums[i])%MOD>=0)
            {
                k = (k-nums[i]);
            }
            else{
                long rem = nums[i];
                if(k>0) rem = (rem-k)%MOD;
                long add = ((int)Math.ceil((double)((double)rem/org)))%MOD;
               // System.out.println(add);
                k = (int)((org*add)-rem);
                //System.out.println(nums[i]+" "+add+" "+k);
                cnt = (cnt + add);
            }
        }
        long inv2 = 500000004;
        long ans = (cnt % MOD) * ((cnt + 1) % MOD) % MOD;
        ans = ans * inv2 % MOD;
        return (int)ans;
    }
}