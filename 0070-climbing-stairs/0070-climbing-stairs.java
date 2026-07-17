class Solution {
    static int[] t = new int[47];
    public int climbStairs(int n) {
        Arrays.fill(t,-1);
        return helper(n);
    }
    static int helper(int idx)
    {
        if(idx == 0 || idx == 1) return 1;
        if(t[idx] != -1) return t[idx];
        return t[idx] = helper(idx-1)+helper(idx-2);
    }
}