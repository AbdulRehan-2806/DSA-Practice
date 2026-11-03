class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int moves = 0;
        for(int n : nums)
        {
            max = Math.max(max , n);
            moves += n;
        }
        return nums.length * max - moves;
    }
}