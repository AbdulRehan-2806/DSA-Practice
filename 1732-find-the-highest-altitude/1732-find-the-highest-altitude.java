class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0 , sum = 0;
        for(int n : gain)
        {
            sum += n;
            if(sum > max) max = sum;
        }
        return max;
    }
}