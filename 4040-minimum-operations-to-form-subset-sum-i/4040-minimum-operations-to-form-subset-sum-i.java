class Solution {
    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        int max = 1000000;
        int[] dp = new int[sum+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for(int x : nums)
            {
                HashMap<Integer,Integer> hm = new HashMap<>();
                int val = x;
                int count = 0;
                while(val>0)
                    {
                        if(val <= sum)
                        {
                            hm.put(val,count);
                        }
                        val /= 2;
                        count++;
                    }
                val = x;
                count = 0;
                while(val<=sum){
                    hm.put(val,count);
                    val *= 2;
                    count++;
                }
                int[] arr = dp.clone();
                for(Map.Entry<Integer,Integer> e : hm.entrySet())
                    {
                        int v = e.getKey();
                        int cost = e.getValue();
                        for(int j=0;j+v <= sum ; j++)
                            {
                                if(dp[j] != max)
                                {
                                    arr[j+v] = Math.min(arr[j+v],dp[j]+cost);
                                }
                            }
                    }
                dp = arr;
            }
        return dp[sum] == max ? -1 : dp[sum];
    }
}