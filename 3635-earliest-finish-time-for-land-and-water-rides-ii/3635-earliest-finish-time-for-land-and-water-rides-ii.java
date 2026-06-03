class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int t1 = func(landStartTime,landDuration,waterStartTime,waterDuration);
        int t2 = func(waterStartTime,waterDuration,landStartTime,landDuration);
        return Math.min(t1,t2);
    }
    static int func(int[] st1 , int[] ed1 , int[] st2 , int[] ed2)
    {
        int f1 = Integer.MAX_VALUE;
        for(int i=0;i<st1.length;i++)
        {
            f1 = Math.min(f1 , st1[i]+ed1[i]);
        }
        int f2 = Integer.MAX_VALUE;
        for(int i=0;i<st2.length;i++)
        {
            f2 = Math.min(f2 , Math.max(st2[i],f1)+ed2[i]);
        }
        return f2;
    }
}