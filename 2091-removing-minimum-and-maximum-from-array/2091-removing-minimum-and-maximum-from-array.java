class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        int mini = -1 , maxi = -1;
        for(int i=0;i<n;i++)
        {
            if(nums[i] < min)
            {
                min = nums[i];
                mini = i;
            }
            if(nums[i] > max)
            {
                max = nums[i];
                maxi = i;
            }
        }
        //System.out.println(max+" "+maxi+" "+min+" "+mini);
        int frontmin = mini+1;
        int backmin = n-mini;
        int frontmax = maxi+1;
        int backmax = n-maxi;
        System.out.println(frontmin+" "+frontmax);
        System.out.println(backmin+" "+backmax);
        int minremovals = Integer.MAX_VALUE;
        minremovals = Math.min(minremovals,Math.max(frontmin,frontmax));
        minremovals = Math.min(minremovals , Math.max(backmin,backmax));
        if(frontmin <= backmin)
        {
            if(frontmax <= backmax)
            {
                minremovals = Math.min(minremovals, Math.max(frontmin,frontmax));
            }
            else{
                minremovals = Math.min(minremovals,frontmin+backmax);
            }
        }
        else{
            if(backmax < frontmax)
            {
                minremovals = Math.min(minremovals,Math.max(backmin,backmax));
            }
        }
        minremovals = Math.min(minremovals,backmin + frontmax);
        return minremovals;
    }
}