class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long sum = 0;
        int mid = n/2;
        long total =0;
        int res = 0;
        for(int i=0;i<n;i++){
            total += nums[i];
            if(i<mid)
                sum += nums[i];
        }
        if(sum > (total-sum)) res++;
        long cnt = 1;
        int i=mid;
        int left = 0;
        while(cnt<n)
        {
            i = i%n;
            sum -= nums[left++];
            sum += nums[i++];
            if(sum > (total-sum)) res++;
            //System.out.print(sum+" ");
            cnt++;
        }
        return res;

    }
}