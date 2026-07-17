class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int max = 0;
        int left = 0 , right = 0;
        while(right<n)
        {
            while(!isContinuous(s.substring(left,right+1)))
            {
                left++;
            }
            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
    static boolean isContinuous(String s)
    {
        if(s.length()<=1) return true;
        for(int i=1;i<s.length();i++)
        {
            int ascii = (int)s.charAt(i);
            if((int)s.charAt(i-1) + 1 != ascii) return false;
        }
        return true;
    }
}